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
import com.api.carinapi.statements.GlobalFile.Variable;

public class Parser extends StatmentFac {
    private static ProgramTokenizer tkz;
    private static Map<String,Integer> unitvar;
    private static Unit unit;
    private static int line;
    private static String[] input;
    static HashSet<String> re_word=new HashSet(){{add("antibody");add("virus");add("if");add("else");add("while");add("shoot");add("move");add("nearby");add("then");add("left");add("right");add("up");add("down");add("upleft");add("upright");add("downleft");add("downright");}};
    static HashSet<String> myDirection=new HashSet(){{add("left");add("right");add("up");add("down");add("upleft");add("upright");add("downleft");add("downright");}};
    public Parser(String input[], Map<String, Integer> unitvar, Unit unit) throws SyntaxError {
        Parser.input =input;
        tkz=new ProgramTokenizer(input[line]);
        Parser.unitvar =unitvar;
        Parser.unit =unit;
    }
    public Parser(String input) throws SyntaxError {
        tkz=new ProgramTokenizer(input);
    }
    public static void GoNextLine() throws SyntaxError {
        line++;
        tkz=new ProgramTokenizer(input[line]);
    }
    public static LinkedList<NodeTree> parseProgram() throws SyntaxError, EvalError {
        LinkedList<NodeTree> nt=new LinkedList<>();
        while(line<input.length){
            nt.add(parseState());
            GoNextLine();
        }
        return nt;
    }
    public static NodeTree parseState() throws SyntaxError, EvalError {

           if (tkz.peek("move") || tkz.peek("shoot")) {
               return parseCommand();
           }
           else if (tkz.peek("if")) {
               return parseIf();
           } else if (tkz.peek("while")) {
            return parseWhile();
           } else if (tkz.peek("{")) {
            return  parseBlock();
           }
           else if(!re_word.contains(tkz.peek())){
               return parseAssign();
           }
   throw new SyntaxError("Wrong State");
    }
    public static NodeTree parseAssign() throws SyntaxError, EvalError {
            String x = tkz.consume();
            if(tkz.peek("=")){
                tkz.consume("=");
                Variable tempVar= new Variable(x,unitvar);
                StringBuilder expr=new StringBuilder();
                while(!tkz.peek("")){
                    expr.append(tkz.consume());
                }
                return creatAssignStatement(tempVar, new Parser(expr.toString()). parseExpression().eval());
        }
            else{
                throw new SyntaxError("No assign command");
            }
    }
    public static NodeTree parseCommand() throws SyntaxError {
                String thecmd=tkz.consume();
                String direct= tkz.consume();
                if(myDirection.contains(direct))
                {
                    return creatStatement(thecmd,direct,unit);
                }
        throw new SyntaxError("Wrong command "+tkz.peek());
    }

    public static NodeTree parseIf() throws SyntaxError, EvalError {
        StringBuilder ifexpr=new StringBuilder();
        StringBuilder thenstate=new StringBuilder();
        StringBuilder elsstate=new StringBuilder();
        tkz.consume("if");
        while(!tkz.peek("then")) //find the expr
        {
            ifexpr.append(tkz.consume());
            if(tkz.peek("")&&line<input.length)GoNextLine();
        }
        if(tkz.peek("then"))
        {
            tkz.consume("then");
            while(!tkz.peek("else")) //find the state
            {
                thenstate.append(tkz.consume());
                if(tkz.peek("")&&line<input.length)GoNextLine();
            }

        }

        return creatIfStatement(new Parser(ifexpr.toString()).parseExpression(),new Parser(thenstate.toString()).parseState(),new Parser(elsstate.toString()).parseState());
    }
    public static NodeTree parseElse() throws SyntaxError {
        if(tkz.peek("else"))
        {
            tkz.consume("else");
            while(!tkz.peek("")) //find the expr
            {
                elsstate.append(tkz.consume());
            }
        }
    }
        public static NodeTree parseWhile() throws SyntaxError, EvalError {
        tkz.consume("while");
        return parseExpression();

    }
    public static NodeTree parseBlock() throws SyntaxError, EvalError {
        NodeTree nt=null;
    tkz.consume("{");
    nt=parseState();
    tkz.consume("}");
    return nt;
    }
    public static NodeTree parseExpression() throws SyntaxError, EvalError {
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

    private static NodeTree parseTerm() throws SyntaxError, EvalError {

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
    private static NodeTree parseFactor() throws SyntaxError, EvalError {
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
    private static NodeTree parsePower() throws SyntaxError, EvalError {
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
    private static NodeTree parseSensor() throws SyntaxError {
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
    public static boolean isNumber(String peek) {
        try {
            Double.parseDouble(peek);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
