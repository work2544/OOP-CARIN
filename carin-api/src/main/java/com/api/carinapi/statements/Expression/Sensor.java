package com.api.carinapi.statements.Expression;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

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