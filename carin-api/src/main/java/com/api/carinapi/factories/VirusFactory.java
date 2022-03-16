package com.api.carinapi.factories;

import static java.lang.Thread.sleep;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.api.carinapi.interfaces.Unit;
import com.api.carinapi.statements.ErrorPack.EvalError;
import com.api.carinapi.statements.ErrorPack.SyntaxError;
import com.api.carinapi.statements.GlobalFile.NodeTree;
import com.api.carinapi.utils.Parser;
import com.api.carinapi.utils.ReadGenetic;

public class VirusFactory implements Runnable {
    private  int hp, atk,gain;
    private Random rd=new Random();
    protected Unit[][] map=ImmuneSystem.getmap();
    private double spwanrate=rd.nextDouble(0.5,1);
    private int availVirus=20;
    private int liveVirus=0;
    public VirusFactory(int hp, int atk, int gain){
    this.hp=hp;
    this.atk=atk;
    this.gain=gain;
    }
    public Virus CreatVirus(String type,int posx,int posy) {
        Virus virus = null;
        if (type.equals("knight")) {
            virus = new KnightVirus(hp, atk, gain,posx,posy);
        } else if (type.equals("shield")) {
            virus = new ShieldVirus(hp, atk, gain,posx,posy);
        } else if (type.equals("mage")) {
            virus = new MageVirus(hp, atk, gain,posx,posy);
        }
        map[posy][posx]=virus;
        return virus;
    }
    public void Vsetup(){
        Unit vr1=CreatVirus("knight",14,0);
        Unit vr2=CreatVirus("shield",14,0);
        Unit vr3=CreatVirus("mage",14,0);
        map[0][map[0].length-1]=vr1;
        map[1][map[0].length-1]=vr2;
        map[2][map[0].length-1]=vr3;
        Thread vr1thread=new Thread(vr1);
        Thread vr2thread=new Thread(vr2);
        Thread vr3thread=new Thread(vr3);
        vr1thread.start();
        vr2thread.start();
        vr3thread.start();
        availVirus-=3;
        liveVirus+=3;
    }
    @Override
    public void run() {
        int spwanpos;
        int typerd;
        while(availVirus>0){
            spwanpos= rd.nextInt(0,map.length);
            typerd= rd.nextInt(0,3);
            Unit vr;
            try {
                while(map[map.length-1][spwanpos]!=null)spwanpos= rd.nextInt(0, map.length);
                switch (typerd){
                    case 0:
                        vr=CreatVirus("knight",map[0].length-1,spwanpos);
                        break;
                    case 1:
                        vr=CreatVirus("shield",map[0].length-1,spwanpos);
                        break;
                    default: vr=CreatVirus("mage",map[0].length-1,spwanpos);
                }
                map[spwanpos][map[0].length-1]=vr;
                Thread vrthread=new Thread(vr);
                vrthread.start();
                availVirus--;
                liveVirus++;
                sleep((long) (1000/spwanrate));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class KnightVirus extends Virus {

    public KnightVirus(int hp,  int atk, int gain, int posx, int posy) {
        super(hp,  atk, gain, posx, posy);
    }

}
class ShieldVirus extends Virus {

    public ShieldVirus(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}
class MageVirus extends Virus {

    public MageVirus(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}
class Virus implements Unit {
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
        Unit[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]!=null)
                if(map[i][j].getClass().getName().equals("Antibody"))
                {
                    map[i][j].getattack(this);
                    this.hp+=gain();
                    if(map[i][j].hp()<=0)map[answer[1]][answer[0]]=null;
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
                System.out.println("doing genetic");
                nt.eval();
            sleep(1000);
            }
        } catch (EvalError | SyntaxError | InterruptedException e) {
            e.printStackTrace();
        }
    }
}