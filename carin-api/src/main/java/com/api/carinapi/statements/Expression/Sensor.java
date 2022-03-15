package com.api.carinapi.statements.Expression;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

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
