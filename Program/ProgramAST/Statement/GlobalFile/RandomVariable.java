package ProgramAST.Statement.GlobalFile;

import java.util.Map;
import java.util.Random;

public class RandomVariable extends Variable{
    Random rd;

    public RandomVariable() {
       rd=new Random();
       identifier="random";
    }
    public int evaluate() {
        return rd.nextInt()*100;
    }

    public void assignValue(int value){
        return;
    }

}
