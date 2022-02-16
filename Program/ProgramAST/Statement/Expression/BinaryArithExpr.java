package ProgramAST.Expression;

import ProgramAST.ErrorPack.EvalError;
import ProgramAST.ErrorPack.SyntaxError;
import ProgramAST.GlobalFile.NodeTree;

public class BinaryArithExpr implements NodeTree {
    private NodeTree left, right;
    private String op;

    public BinaryArithExpr(NodeTree left, String op, NodeTree right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public int eval() throws EvalError, SyntaxError {
        int lv = left.eval();
        int rv = right.eval();
        switch (op) {
            case "+":
                return lv + rv;
            case "-":
                return lv - rv;
            case "*":
                return lv * rv;
            case "^":
                return (int) Math.pow(lv, rv);
            case "/":
                if (rv == 0) throw new SyntaxError("/ by zero ");
                else return lv / rv;
            case "%":
                if (rv == 0) throw new SyntaxError("% by zero ");
                else return lv % rv;
            default:
                throw new EvalError("unknown op: " + op);
        }

    }
}

//public class ExprParser {
//    private static ExprTokenizer tkz;
//
//    public ExprParser(String src) throws SyntaxError {
//        this.tkz = new ExprTokenizer(src);
//    }
//
//    public static ExprPaser parseE() throws SyntaxError {
//        ExprPaser e = parseT();
//        while (tkz.peek("+") || tkz.peek("-")) {
//            String op = tkz.consume();
//            if (op.equals("+"))
//                e = new BinaryArithExpr(e, "+", parseT());
//            else if (op.equals("-"))
//                e = new BinaryArithExpr(e, "-", parseT());
//        }
//        return e;
//    }
//
//    private static ExprPaser parseT() throws SyntaxError {
//        ExprPaser v = parseF();
//        while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
//            String op = tkz.consume();
//            if (op.equals("*"))
//                v = new BinaryArithExpr(v, "*", parseF());
//            else if (op.equals("/")) {
//                v = new BinaryArithExpr(v, "/", parseF());
//
//            } else if (op.equals("%")) {
//
//                v = new BinaryArithExpr(v, "%", parseF());
//            }
//        }
//        return v;
//    }
//
//    private static ExprPaser parseF() throws SyntaxError {
//        ExprPaser v=parseP();
//        while (tkz.peek("^")) {
//            String op = tkz.consume();
//            if(op.equals("^"))
//            {v=new BinaryArithExpr(v, "^",parseF());}
//        }
//        return v;
//    }
//    private static ExprPaser parseP() throws SyntaxError {
//        String xL = tkz.peek();
//        if (isNumber(xL)) {
//            String x = tkz.consume();
//            if(Integer.parseInt(x)<0)
//                try {
//                    throw new EvalError(x+" is negative");
//                } catch (EvalError e) {
//                    // TODO Auto-generated catch block
//                }
//            return new MyNumber(Integer.parseInt(x));
//        }
//        //case identity else if(){}
//        else {
//            tkz.consume("(");
//            ExprPaser v = parseE();
//            tkz.consume(")");
//            return v;
//        }
//    }
//
//    private static boolean isNumber(String peek) {
//        try {
//            Double.parseDouble(peek);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//}
