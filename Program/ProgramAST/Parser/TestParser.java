package ProgramAST.Parser;


import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;

import Unit.*;

import java.util.HashMap;

import java.util.Map;


public class TestParser {
    public static void main(String[] args) throws SyntaxError, EvalError {
        Parser exp;
        Unit x= new AntibodyFactory(1,1,1,1,1).CreatAntibody("melee",0,0);
        Map<String,Integer> unitvar=new HashMap<>();
        exp=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene"),unitvar,x);
        System.out.println(exp.parseProgram().eval());
    }
}
