package com.api.carinapi.utils;

import java.util.HashSet;
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
            else if (tkz.peek("if")||tkz.peek("else")) {
                if(tkz.peek("if"))
                {

                    gp.add(parseIf());
                }
                else if(tkz.peek("else")){
                    //tkz.consume("else");
                    break;
                }
            }
            else if (tkz.peek("while")) {
                gp.add(parseWhile());
           }
            }
            else if (tkz.peek("{")||tkz.peek("}")) {
               if(tkz.peek("{")) {
                   tkz.consume("{");
                   gp.add(parseProgram());
                   if(!tkz.peek("}"))throw new SyntaxError("need }");
                   tkz.consume("}");
               }
               else if(tkz.peek("}")) {break;}
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
                NodeTree expr=parseExpression();
                return creatAssignStatement(tempVar,expr);
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
        NodeTree ifexprnode;
        NodeTree thenexprnode;
        NodeTree elseexprnode;
        tkz.consume("if");
        tkz.consume("(");
        ifexprnode=parseExpression();
        tkz.consume(")");
        tkz.consume("then");
        thenexprnode=parseProgram();
        if(tkz.peek("else")) {
            tkz.consume("else");
            elseexprnode = parseProgram();
            return creatIfStatement(ifexprnode,thenexprnode,elseexprnode);
        }
       return creatIfStatement(ifexprnode,thenexprnode);

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
        if(nt!=null) return nt;


        //exp case
        if(xL.equals("("))
        {
            tkz.consume("(");
            nt = parseExpression();
            tkz.consume(")");
        }
        //identity and number case
        else  if (isNumber(xL)) {
            String x = tkz.consume();
            if(Integer.parseInt(x)<0) throw new EvalError(x+" is negative");

            else nt= new MyNumber(Integer.parseInt(x));
        }
            else{
                String x = tkz.consume();
                if(x.equals("random")){
                    {
                        RandomVariable tempvar=new RandomVariable();
                    new Variable(x,unitvar);
                    Variable.assign(tempvar.evaluate());
                     return creatAssignStatement(tempvar);
                    }
            }
                nt=new Variable(x,unitvar);
            }

        return nt;

    }
    private  NodeTree parseSensor() throws SyntaxError, EvalError {
        if(tkz.peek("virus")){ //closet virus
            return new MyNumber(new Sensor(unit,tkz.consume()).eval());
        }
        else if(tkz.peek("antibody"))
        {
            return new MyNumber(new Sensor(unit,tkz.consume()).eval());
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