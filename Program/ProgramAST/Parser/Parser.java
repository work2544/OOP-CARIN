package ProgramAST.Parser;

import ProgramAST.ProgramTokenizer;
import ProgramAST.Statement.Command;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.Expression.Sensor;
import ProgramAST.Statement.GlobalFile.MyNumber;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;
import ProgramAST.StatmentFac;
import Unit.Unit;

import java.util.HashSet;
import java.util.Map;

public class Parser extends StatmentFac {
    private static ProgramTokenizer tkz;
    private static Map<String,Integer> unitvar;
    private static Unit unit;
    static HashSet<String> myDirection=new HashSet(){{add("left");add("right");add("up");add("down");add("upleft");add("upright");add("downleft");add("downright");}};
    public Parser(String input, Map<String, Integer> unitvar, Unit unit) throws SyntaxError {
        this.tkz=new ProgramTokenizer(input);
        this.unitvar=unitvar;
        this.unit=unit;
    }
    public static NodeTree parseState()  {
       try {
           if (tkz.peek("<") || tkz.peek("move") || tkz.peek("shoot")) {
               return parseCommand();
           } else if (tkz.peek("if")) {
               return parseIf();
           } else if (tkz.peek("while")) {

           } else if (tkz.peek("{")) {

           }
           return null;
       }
       catch (EvalError e){

       }
       catch (SyntaxError e){

       }
    return new MyNumber(0);
    }
    public static NodeTree parseCommand() throws SyntaxError, EvalError {
        if(tkz.peek("<")){ //assign command
            tkz.consume("<");
            String x = tkz.consume();
            tkz.consume(">");
            if(tkz.peek("=")){
                tkz.consume("=");
                Variable tempVar= new Variable(x,unitvar);
                StringBuilder expr=new StringBuilder();
                while(!tkz.peek("")){
                    expr.append(tkz.consume());
                }
                return creatAssignStatement(tempVar, new Parser(expr.toString(), unitvar,unit).parseExpression().eval());
            }
            else{
                throw new SyntaxError("No assign command");
            }
        }
        else{
            if(tkz.peek("move")||tkz.peek("shoot")){
                String thecmd=tkz.consume();
                String direct= tkz.consume();
                if(myDirection.contains(direct))
                {
                    return creatStatement(thecmd,direct,unit);
                }
                else throw new SyntaxError("Wrong direction "+direct);
            }
            throw new SyntaxError("Wrong command "+tkz.peek());
        }
    }

    public static NodeTree parseIf() throws SyntaxError, EvalError {
        StringBuilder ifexpr=new StringBuilder();
        StringBuilder thenstate=new StringBuilder();
        StringBuilder elsstate=new StringBuilder();
        while(!tkz.peek("then")) //find the expr
        {
            ifexpr.append(tkz.consume());
        }
        if(tkz.peek("then"))
        {
            tkz.consume("then");
            while(!tkz.peek("else")) //find the state
            {
                thenstate.append(tkz.consume());
            }
        }
        if(tkz.peek("else"))
        {
            tkz.consume("else");
            while(!tkz.peek("")) //find the expr
            {
                elsstate.append(tkz.consume());
            }
        }
        return creatIfStatement(new Parser(ifexpr.toString(),unitvar,unit).parseExpression(),new Parser(thenstate.toString(),unitvar,unit).parseState(),new Parser(thenstate.toString(),unitvar,unit).parseState());
    }
    //    public static NodeTree parseWhile() throws SyntaxError, EvalError {
//
//    }
//    public static NodeTree parseBlock() throws SyntaxError, EvalError {
//
//    }
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
        NodeTree nt=null;
        //identity and number case
        if(xL.equals("<"))
        {
            tkz.consume("<");
            String x = tkz.consume();
            tkz.consume(">");
            if (isNumber(x)) {
                if(Integer.parseInt(x)<0) throw new EvalError(x+" is negative");
                else nt= new MyNumber(Integer.parseInt(x));
            }
            else{
                nt=new MyNumber(new Variable(x,unitvar).eval());
            }

        }
        //exp case
        else if(xL.equals("("))
        {
            tkz.consume("(");
            nt = parseExpression();
            tkz.consume(")");
        }
        else //sensor case
        {
            nt=parseSensor();
        }
        return nt;

    }
    private static NodeTree parseSensor() throws SyntaxError {
        if(tkz.peek("virus")){ //closet virus

        }
        else if(tkz.peek("antibody"))
        {

        }
        else if(tkz.peek("nearby"))
        {

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
