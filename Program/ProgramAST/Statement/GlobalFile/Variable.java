package ProgramAST.Statement.GlobalFile;

import ProgramAST.Statement.ErrorPack.EvalError;

import java.util.Map;


public class Variable implements NodeTree {

    static String identifier;
    static Map<String,Integer> var;

    public Variable(){}
    public Variable(String Identifier,Map<String,Integer> var) {
        this.identifier=Identifier;
        this.var=var;
        if(!var.containsKey(identifier))
        var.put(identifier,0);
    }
    public static void assign(int val)
    {
        if(var.containsKey(identifier))
            var.put(identifier,val);
    }
    @Override
    public int eval() throws EvalError {
        if(var.containsKey(identifier))
        return var.get(identifier);
        else
            throw new EvalError("undefined identifier: "+identifier);
    }
}

