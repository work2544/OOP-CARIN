package Unit;

import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Parser.Parser;
import ProgramAST.Parser.ReadGenetic;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Antibody implements Unit{
    int hp, atk,gain;
    int posx, posy;
    NodeTree nt;
    Map<String,Integer> unitvar=new HashMap<>();
    public Antibody(int hp, int atk, int gain,int posx,int posy) {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.posx=posx;
        this.posy=posy;
        try {
            this.nt= new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/AntibodyGene"),unitvar,this).parseProgram();
        }
        catch (SyntaxError | EvalError e){
            System.out.println("cannot parse gene");
        }
    }
    @Override
    public void attack(String Direction) {
        Unit[][] map= ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]!=null)
                    if(map[i][j].getClass().getName().equals("Virus"))
                    {
                        map[i][j].getattack(this);
                        this.hp+=gain();
                        if(map[i][j].hp()<=0){map[answer[1]][answer[0]]=null; VirusFactory.liveVirus--;}
                    }
            }
        }
    }

    @Override
    public void getattack(Unit unit) {
        this.hp-=unit.atk();
    }

    @Override
    public int hp() {
        return hp;
    }

    @Override
    public int atk() {
        return atk;
    }

    @Override
    public void move(String Direction) {
        Unit[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
        if(answer[0]<map[0].length&&answer[1]<map.length&&answer[0]>-1&&answer[1]>-1)
        {  posx+=answer[0];
            posy+=answer[1];}
    }
    @Override
    public int posx() {

        return posx;
    }

    @Override
    public int posy() {

        return posy;
    }

    @Override
    public int gain() {
        return gain;
    }


    @Override
    public void run() {
        try {
            nt.eval();
            sleep(1000);
        } catch (EvalError | SyntaxError | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
