package ProgramAST.Parser;

import ProgramAST.ProgramTokenizer;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.Expression.Sensor;
import ProgramAST.Statement.GlobalFile.MyNumber;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;

import java.util.Map;

public class Parser {
    static ProgramTokenizer tkz;
    static Map<String,Integer> UnitVariable;
    public Parser(String src) throws SyntaxError {
        tkz=new ProgramTokenizer(ReadGenetic.GetGenetic(src));
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
        NodeTree nt = parseSensor(); //sensor case
        //identity and number case
        if(xL.equals("<"))
        {
            tkz.consume("<");
            String x = tkz.consume();
            if (ProgramTokenizer.isNumber(xL)) {
                if(Integer.parseInt(x)<0) throw new EvalError(x+" is negative");
                else nt= new MyNumber(Integer.parseInt(x));
            }
            else{
                nt = new Variable(x,UnitVariable);
            }
            tkz.consume(">");
        }
        //exp case
        else if(xL.equals("("))
        {
            tkz.consume("(");
            nt = parseExpression();
            tkz.consume(")");
        }
        return nt;

    }
    private static NodeTree parseSensor()
    {
        if()
        String direction=tkz.consume();
return new Sensor()
    }

}
