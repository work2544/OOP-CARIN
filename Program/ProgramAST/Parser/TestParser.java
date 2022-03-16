package ProgramAST.Parser;


import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;

import ProgramAST.Statement.GlobalFile.NodeTree;
import Unit.*;

import java.util.HashMap;

import java.util.Map;


public class TestParser {
    static ImmuneSystem IS=new ImmuneSystem(15,7);
    public static void main(String[] args) throws SyntaxError, EvalError {

        Parser exp;
        Unit x= new VirusFactory(1,1,1).CreatVirus("knight",14,6);
        Unit y= new AntibodyFactory(1,1,1,1,1).CreatAntibody("knight",0,6);
        Map<String,Integer> unitvar=new HashMap<>();
        System.out.println(x.nearby("left"));
        System.out.println(y.nearby("right"));
        System.out.println(y.nearby("up"));
        String[] xx=IS.getmap()[6][0].getClass().getName().split("\\.");
//        x.move("left");
//        x.move("left");
//        x.move("left");
//        x.move("left");
//        x.move("left");x.move("left");
         Printmap();
   //     exp=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene"),unitvar,x);
        Parser exp2=new Parser("ant=antibody",unitvar,x);
      //  NodeTree theGene=exp.parseProgram();
        System.out.println(exp2.parseProgram().eval());
       // System.out.println(theGene.eval());
        System.out.println();
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
                        case "SheildAntibody":
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
