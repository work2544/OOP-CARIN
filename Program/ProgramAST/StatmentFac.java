package ProgramAST;

import ProgramAST.Parser.ExpParser;
import ProgramAST.Statement.BlockStatement;
import ProgramAST.Statement.Command;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.Expression.Sensor;
import ProgramAST.Statement.GlobalFile.MyNumber;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;
import ProgramAST.Statement.IfState;
import ProgramAST.Statement.WhileState;
import Unit.Unit;

import java.util.HashSet;
import java.util.Map;

public  class StatmentFac {

    public static NodeTree creatStatement(String actcom, String directionNode, Unit unit) {
        return new Command(actcom, directionNode, unit);
    }
    public static NodeTree creatStatement(NodeTree left, String op, NodeTree right) {
        return new BinaryArithExpr(left, op, right);
    }
    public static NodeTree creatStatement(Unit unit, String direction) {
        return new Sensor(unit, direction);
    }

    public static  NodeTree creatStatement(NodeTree statement) {
        return new BlockStatement(statement);
    }

    public static NodeTree creatWhileStatement(NodeTree expr, NodeTree statement) {
        return new WhileState(expr, statement);
    }
    public static NodeTree creatAssignStatement(Variable var,int bina){
        return new Command(var,bina);
    }
    public static NodeTree creatIfStatement(NodeTree ifexp, NodeTree thenstate, NodeTree elsestate) {
        return new IfState(ifexp, thenstate, elsestate);
    }
    public static NodeTree creatStatement(String identifier, Map<String,Integer> allvar)
    {
        return new Variable(identifier,allvar);
    }

}
