package ProgramAST.Statement;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;
import Unit.Unit;


public class Command implements NodeTree {
    NodeTree cmd;
    public Command(String actcom, String directionNode,Unit unit)
    {
        cmd=new ActionCommand(actcom,directionNode,unit);
    }
    public Command(Variable name, BinaryArithExpr exp)
    {
        cmd=new AssignCommand(name,exp);
    }

    @Override
    public int eval() throws EvalError, SyntaxError {
        return cmd.eval();
    }
}
class ActionCommand implements NodeTree{
    String actcom; //move or acttack
    String directionNode;
    Unit unit;
    public ActionCommand(String actcom, String directionNode,Unit unit)
    {
        this.actcom=actcom;
        this.directionNode=directionNode;
        this.unit=unit;
    }

    @Override
    public int eval() {
        if(actcom.equalsIgnoreCase("move"))
        {
            unit.move(directionNode);
        }
        else if(actcom.equalsIgnoreCase("shoot"))
        {
            unit.attack(directionNode);
        }
        return 0;
    }

}
class AssignCommand implements NodeTree{
    Variable name;
    BinaryArithExpr exp;

    public AssignCommand(Variable name, BinaryArithExpr exp) {
        this.exp=exp;
        this.name=name;
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        Variable.assign(exp.eval());
        return 0;
    }
}

