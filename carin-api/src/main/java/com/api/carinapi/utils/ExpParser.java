package com.api.carinapi.utils;

import java.util.HashMap;
import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;


public class ExpParser {


    public static void main(String[] args) throws SyntaxError, EvalError {
        Parser exp;
        Unit x=null;
        Map<String,Integer> unitvar=new HashMap<>();
        exp=new Parser("<10>+<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<a>=<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<a2>=<10>+<10>",unitvar,x);
        System.out.println(exp.parseState().eval());
        exp=new Parser("<b2>=<a2>*<2>",unitvar,x);
        System.out.println(exp.parseState().eval());
    }


}
