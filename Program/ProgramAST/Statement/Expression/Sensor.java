package ProgramAST.Statement.Expression;

import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;
import Unit.Unit;

public class Sensor implements NodeTree {
    Unit unit;
    String direction;
    public Sensor(Unit unit, String direction)
    {
        this.direction=direction;
        this.unit=unit;
    }
    @Override
    public int eval() throws EvalError, SyntaxError {
        return unit.nearby();
    }
}
