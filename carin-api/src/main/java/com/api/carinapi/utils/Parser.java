package com.api.carinapi.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.Expression.BinaryArithExpr;
import com.api.carinapi.statements.Expression.Sensor;
import com.api.carinapi.statements.GlobalFile.MyNumber;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.statements.GlobalFile.RandomVariable;
import com.api.carinapi.statements.GlobalFile.Variable;

public class Parser extends StatmentFac {
    private  ProgramTokenizer tkz;
    private  Map<String,Integer> unitvar;
    private  Unit unit;
    private static boolean havepeekbracket=false;
    private static boolean havepeekif=false;
    static HashSet<String> re_word=new HashSet(){{add("antibody");add("virus");add("if");add("else");add("while");add("shoot");add("move");add("nearby");add("then");add("left");add("right");add("up");add("down");add("upleft");add("upright");add("downleft");add("downright");}};
    static HashSet<String> myDirection=new HashSet(){{add("left");add("right");add("up");add("down");add("upleft");add("upright");add("downleft");add("downright");}};
    public Parser(String input, Map<String, Integer> unitvar, Unit unit) throws SyntaxError {
        tkz=new ProgramTokenizer(input);
        this.unitvar =unitvar;
        this.unit =unit;
    }
    public NodeTree parseProgram() throws SyntaxError, EvalError {
        GeneProgram gp=new GeneProgram();
        while(!tkz.peek("")){

            if(re_word.contains(tkz.peek()))
            {
                if (tkz.peek("move") || tkz.peek("shoot")) {
                gp.add(parseCommand());
            }
            else if (tkz.peek("if")) {
                havepeekif=true;
                gp.add(parseIf());

            }
            else if(tkz.peek("else")&&havepeekif){tkz.consume("else");havepeekif=false;}
            else if (tkz.peek("while")) {
                gp.add(parseWhile());
           }
            }
            else if (tkz.peek("{")||tkz.peek("}")) {
               if(tkz.peek("{")) {
                   havepeekbracket=true;
                   tkz.consume("{");
                   gp.add(parseProgram());
                   if(havepeekbracket)throw new SyntaxError("need }");
               }
               else if(tkz.peek("}")&&havepeekbracket) {tkz.consume("}"); havepeekbracket=false;};

            }
            else if(tkz.peek("\n"))tkz.consume();
            else if(!re_word.contains(tkz.peek())){
                gp.add(parseAssign());
            }
        }
        return gp;
    }
    public  NodeTree parseAssign() throws SyntaxError, EvalError {
            String x = tkz.consume();
            if(tkz.peek("=")){
                tkz.consume("=");
                Variable tempVar= new Variable(x,unitvar);
                StringBuilder expr=new StringBuilder();
                while(!tkz.peek("\n")){
                    expr.append(tkz.consume());
                }
                return creatAssignStatement(tempVar, new Parser(expr.toString(),unitvar,unit).parseExpression().eval());
        }else if(x.equals("random")){
                Variable tempvar=new RandomVariable();
                return creatAssignStatement(tempvar, tempvar.eval());
            }
            else{
                throw new SyntaxError("No assign command");
            }
    }
    public  NodeTree parseCommand() throws SyntaxError {
                String thecmd=tkz.consume();
                String direct= tkz.consume();
                if(myDirection.contains(direct))
                {
                    return creatStatement(thecmd,direct,unit);
                }
        throw new SyntaxError("Wrong command "+tkz.peek());
    }

    public  NodeTree parseIf() throws SyntaxError, EvalError {
        StringBuilder ifexpr=new StringBuilder();
        NodeTree ifexprnode;
        NodeTree thenexprnode;
        NodeTree elseexprnode;
        tkz.consume("if");
        while(!tkz.peek("then")) //find the expr
        {
            if(tkz.peek("\n"))tkz.consume();
            ifexpr.append(tkz.consume());
        }
        ifexprnode=new Parser(ifexpr.toString(),unitvar,unit).parseExpression();
        thenexprnode=parseThen();
        elseexprnode=parseElse();
        return creatIfStatement(ifexprnode,thenexprnode,elseexprnode);

    }
    public   NodeTree parseThen() throws SyntaxError, EvalError {
        StringBuilder thenstate=new StringBuilder();
        if(tkz.peek("then"))
        {
            tkz.consume("then");
            while(true) //find the state
            {
//                if(tkz.peek("\n"))tkz.consume();
//                System.out.println(tkz.peek());
                if(tkz.peek("else")||tkz.peek(""))break;
                thenstate.append(tkz.consume()+" ");
            }
        }
        return new Parser(thenstate.toString(),unitvar,unit).parseProgram();
    }
    public  NodeTree parseElse() throws SyntaxError, EvalError {
        StringBuilder elsestate=new StringBuilder();
        if(tkz.peek("else"))
        {
            tkz.consume("else");

                    while(!tkz.peek("")) //find the expr
                {

                    elsestate.append(tkz.consume()+" ");
                }
        }
        return new Parser(elsestate.toString(),unitvar,unit).parseProgram();
    }

        public  NodeTree parseWhile() throws SyntaxError, EvalError {
        tkz.consume("while");
        StringBuilder exprS=new StringBuilder();
        StringBuilder stateS=new StringBuilder();
        if(tkz.peek("("))
        {
            while (!tkz.peek(")"))
            {
                exprS.append(tkz.consume());
            }
            exprS.append(tkz.consume());
        }
        NodeTree expr=new Parser(exprS.toString(),unitvar,unit).parseExpression();
            while (!tkz.peek("\n"))
            {
                stateS.append(tkz.consume());
            }
        NodeTree State=new Parser(stateS.toString(),unitvar,unit).parseProgram();
        return creatWhileStatement(expr,State);

    }
    public  NodeTree parseExpression() throws SyntaxError, EvalError {
        NodeTree e = parseTerm();
        while (tkz.peek("+") || tkz.peek("-")) {
            String op = tkz.consume();
            if (op.equals("+"))
                e = new BinaryArithExpr(e, "+", parseTerm());
            else if (op.equals("-"))
                e = new BinaryArithExpr(e, "-", parseTerm());
        }
        return e;
    }

    private  NodeTree parseTerm() throws SyntaxError, EvalError {

        NodeTree v = parseFactor();
        while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
            String op = tkz.consume();
            if (op.equals("*"))
                v = new BinaryArithExpr(v, "*", parseFactor());
            else if (op.equals("/")) {
                v = new BinaryArithExpr(v, "/", parseFactor());
            } else if (op.equals("%")) {
                v = new BinaryArithExpr(v, "%", parseFactor());
            }
        }
        return v;
    }
    private  NodeTree parseFactor() throws SyntaxError, EvalError {
        NodeTree v=parsePower();
        while (tkz.peek("^")) {
            String op = tkz.consume();
            if(op.equals("^"))
            {
                v=new BinaryArithExpr(v, "^",parseFactor());
            }
        }
        return v;
    }
    private  NodeTree parsePower() throws SyntaxError, EvalError {
        String xL = tkz.peek();
        NodeTree nt=parseSensor();
        //identity and number case
            if (isNumber(xL)) {
                String x = tkz.consume();
                if(Integer.parseInt(x)<0) throw new EvalError(x+" is negative");
                else nt= new MyNumber(Integer.parseInt(x));
            }
        //exp case
        else if(xL.equals("("))
        {
            tkz.consume("(");
            nt = parseExpression();
            tkz.consume(")");
        }
            else{
                String x = tkz.consume();
                nt=new MyNumber(new Variable(x,unitvar).eval());
            }

        return nt;

    }
    private  NodeTree parseSensor() throws SyntaxError {
        if(tkz.peek("virus")){ //closet virus
            return new Sensor(unit,tkz.consume());
        }
        else if(tkz.peek("antibody"))
        {
            return new Sensor(unit,tkz.consume());
        }
        else if(tkz.peek("nearby"))
        {
            String sens=tkz.consume();
            String direct= tkz.consume();
            if(!myDirection.contains(direct))throw new SyntaxError("Wrong direction");
            return new Sensor(unit,direct,sens);
        }
       return null;
    }
    public  boolean isNumber(String peek) {
        try {
            Double.parseDouble(peek);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
