package com.api.carinapi.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;

import static java.lang.Thread.sleep;

public class AntibodyFactory implements Runnable {
    int hp,atk,gain,movecost,placecost;
    int livedAnti=0;
    protected ArrayList<Unit>[][] map= ImmuneSystem.getmap();

    public AntibodyFactory(int hp, int atk, int gain,int movecost, int placecost) {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.movecost = movecost;
        this.placecost = placecost;
    }
    public void AntibodySetup(){
        map[0][0].add(CreatAntibody("melee",0,0));
        map[1][0].add(CreatAntibody("tank",1,0));
        map[2][0].add(CreatAntibody("range",2,0));
        livedAnti+=3;
    }
    public Antibody CreatAntibody(String type,int posx,int posy) {
        Antibody antibody = null;
        if (type.equals("melee")) {
            antibody = new MeleeAntibody(hp, atk, gain,posx,posy);
        } else if (type.equals("tank")) {
            antibody = new TankAntibody(hp, atk, gain,posx,posy);
        } else if (type.equals("range")) {
            antibody = new RangeAntibody(hp, atk, gain,posx,posy);
        }
        return antibody;
    }

    @Override
    public void run() {

    }
}
class MeleeAntibody extends Antibody {

    public MeleeAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp,  atk, gain, posx, posy);
    }

}
class TankAntibody extends Antibody {

    public TankAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}
class RangeAntibody extends Antibody {

    public RangeAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}
class Antibody implements Unit{
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

    }
    @Override
    public void attack(String Direction) {
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
        for (Unit unit :map[answer[1]][answer[0]]
        ) {
            if(unit.getClass().getName().equals("Virus"))
            {
                unit.getattack(this);
                this.hp+=gain();
                if(unit.hp()<=0)map[answer[1]][answer[0]].remove(unit);
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
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
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
        } catch (EvalError e) {
            e.printStackTrace();
        } catch (SyntaxError e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
