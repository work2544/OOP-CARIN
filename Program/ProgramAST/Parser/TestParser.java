package ProgramAST.Parser;


import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;

import Unit.*;

import java.util.HashMap;
import java.util.Map;


public class TestParser {
    static ImmuneSystem IS=new ImmuneSystem(15,7);
    public static void main(String[] args) throws SyntaxError, EvalError, InterruptedException {
        Unit x = null;
        Map<String,Integer> mapvar=new HashMap<>();
Parser ps=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/testrand"),mapvar,x);
        System.out.println(ps.parseProgram().eval());
    }
    public static void Printmap(){
        for (int i = 0; i < IS.getmap().length; i++) {
            for (int j = 0; j < IS.getmap()[0].length; j++) {
                if (IS.getmap()[i][j]!=null) {
                    String unitname=IS.getmap()[i][j].getClass().getName().split("\\.")[1];
                    switch (unitname){
                        case "KnightAntibody":
                            System.out.print("*");
                            break;
                        case "KnightVirus":
                            System.out.print("(*)");
                            break;
                        case "MageAntibody":
                            System.out.print("#");
                            break;
                        case "MageVirus":
                            System.out.print("(#)");
                            break;
                        case "ShieldAntibody":
                            System.out.print("@");
                            break;
                        default:
                            System.out.print("(@)");
                    }
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println("\n|\n|\n|\n|");
    }
}
