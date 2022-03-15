package ProgramAST.Statement.Expression;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;
import Unit.Unit;

public class Sensor implements NodeTree {
    Unit unit;
    String direction;
    String cmd;
    public Sensor(Unit unit,String cmd)
    {
        this.cmd=cmd;
        this.unit=unit;
    }
    public Sensor(Unit unit, String direction,String cmd)
    {
        this.direction=direction;
        this.unit=unit;
        this.cmd=cmd;
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        if(cmd.equals("virus"))
            return unit.nearvirus();
        else if(cmd.equals("antibody"))
            return unit.nearantibody();
        else return unit.nearby(direction);
    }
}
