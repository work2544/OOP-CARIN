package ProgramAST.Statement;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.Expression.BinaryArithExpr;
import ProgramAST.Statement.GlobalFile.MyNumber;
import ProgramAST.Statement.GlobalFile.NodeTree;
import ProgramAST.Statement.GlobalFile.Variable;
import Unit.Unit;


public class Command implements NodeTree {
    NodeTree cmd;
    public Command(String actcom, String directionNode,Unit unit)
    {
        cmd=new ActionCommand(actcom,directionNode,unit);
    }
    public Command(Variable name) throws EvalError {
        cmd=new AssignCommand(name);
    }
    public Command(Variable name,NodeTree expr)
    {
        cmd=new AssignCommand(name,expr);
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
        if(actcom.equals("move"))
        {
            unit.move(directionNode);
        }
        else if(actcom.equals("shoot"))
        {
            unit.attack(directionNode);
        }
        return 0;
    }

}
class AssignCommand implements NodeTree{
    Variable name;
    NodeTree exp;

    public AssignCommand(Variable name, NodeTree exp) {
        this.name=name;
        this.exp=exp;
    }
    public AssignCommand(Variable name) throws EvalError {
        this.name=name;
        this.exp=new MyNumber(name.eval());
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        int expVal =exp.eval();
        Variable.assign(expVal);
        return expVal;
    }
}

