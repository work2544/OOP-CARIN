package com.api.carinapi.factories;

import java.util.HashMap;
import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.utils.ReadGenetic;
import com.api.carinapi.utils.Parser;
import static java.lang.Thread.sleep;

public class Virus implements Unit {
    int hp, atk,gain;
    int posx, posy;
    NodeTree nt;
    Map<String,Integer> unitvar=new HashMap<>();
    public Virus(int hp, int atk, int gain,int posx,int posy)  {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.posx=posx;
        this.posy=posy;
        try {
            this.nt=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene"),unitvar,this).parseProgram();
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
                    if(map[i][j].getClass().getName().equals("Antibody"))
                    {
                        map[i][j].getattack(this);
                        this.hp+=gain();
                        if(map[i][j].hp()<=0){
                            map[answer[1]][answer[0]]=null; AntibodyFactory.livedAnti--;
                            VirusFactory.CreatVirus("knight",answer[0],answer[1]);
                        }
                    }
            }
        }
    }

    @Override
    public void getattack(Unit unit) {
        this.hp-=unit.atk();
    }

    @Override
    public void move(String Direction) {
        Unit[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);

        if(answer[0]<map[0].length&&answer[1]<map.length&&answer[0]>-1&&answer[1]>-1)
        {
            Unit tempUnit=this;
            map[posy][posx]=null;
            posx=answer[0];
            posy=answer[1];
            map[posy][posx]=tempUnit;
        }
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
    public int posx() {

        return posx;
    }
    @Override
    public int posy() {

        return posy;
    }
    @Override
    public int gain() {
        return 0;
    }

    @Override
    public void run() {
        try {
            while(true)
            {

                nt.eval();
                sleep(1000);
            }
        } catch (EvalError | SyntaxError | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
