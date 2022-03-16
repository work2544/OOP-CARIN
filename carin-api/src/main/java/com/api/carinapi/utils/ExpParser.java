package com.api.carinapi.utils;

import java.util.HashMap;
import java.util.Map;

import com.api.carinapi.factories.AntibodyFactory;
import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;


public class ExpParser {


    public static void main(String[] args) throws SyntaxError, EvalError {
        Parser exp;
        Unit x= new AntibodyFactory(1,1,1,1,1).CreatAntibody("melee",0,0);
        Map<String,Integer> unitvar=new HashMap<>();
        exp=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene").split("\n"),unitvar,x);
        System.out.println(exp.parseProgram());

    }


}
