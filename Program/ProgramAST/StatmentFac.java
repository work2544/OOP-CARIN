package ProgramAST;

import ProgramAST.Statement.BlockStatement;
import ProgramAST.Statement.Command;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.Expression.Sensor;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.IfState;
import ProgramAST.Statement.WhileState;
import Unit.Unit;

public class StatmentFac {
    public static StatmentFac instace;

    public static StatmentFac getInstace() {
        if (instace == null)
            instace = new StatmentFac();
        return instace;
    }

    public NodeTree creatStatement(String actcom, String directionNode, Unit unit) {
        return new Command(actcom, directionNode, unit);
    }

    public NodeTree creatStatement(NodeTree left, String op, NodeTree right) {
        return new BinaryArithExpr(left, op, right);
    }

    public NodeTree creatStatement(Unit unit, String direction) {
        return new Sensor(unit, direction);
    }

    public NodeTree creatStatement(NodeTree statement) {
        return new BlockStatement(statement);
    }

    public NodeTree creatStatement(NodeTree expr, NodeTree statement) {
        return new WhileState(expr, statement);
    }

    public NodeTree creatStatement(NodeTree ifexp, NodeTree thenstate, NodeTree elsestate) {
        return new IfState(ifexp, thenstate, elsestate);
    }

}
