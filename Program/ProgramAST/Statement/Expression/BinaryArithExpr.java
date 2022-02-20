package ProgramAST.Statement.Expression;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

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

