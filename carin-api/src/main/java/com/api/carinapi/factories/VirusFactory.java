package com.api.carinapi.factories;

import static java.lang.Thread.sleep;


import java.util.Random;

import com.api.carinapi.interfaces.Unit;


public class VirusFactory implements Runnable {
    private static int hp, atk,gain;
    private Random rd=new Random();
    protected static Unit[][] map=ImmuneSystem.getmap();
    private double spwanrate=rd.nextDouble(0.5,1);
    private static int availVirus=20;
    public static int liveVirus=0;
    public VirusFactory(int hp, int atk, int gain){
    VirusFactory.hp =hp;
    VirusFactory.atk =atk;
    VirusFactory.gain =gain;
    }
    public static Virus CreatVirus(String type,int posx,int posy) {
        Virus virus = null;
        if (type.equals("knight")) {
            virus = new KnightVirus(hp, atk, gain,posx,posy);
        } else if (type.equals("shield")) {
            virus = new ShieldVirus(hp, atk, gain,posx,posy);
        } else if (type.equals("mage")) {
            virus = new MageVirus(hp, atk, gain,posx,posy);
        }
        map[posy][posx]=virus;
        availVirus--;
        liveVirus++;
        return virus;
    }
    public void Vsetup(){
        Virus vr1=CreatVirus("knight",14,0);
        Virus vr2=CreatVirus("shield",14,1);
        Virus vr3=CreatVirus("mage",14,2);
        map[0][map[0].length-1]=vr1;
        map[1][map[0].length-1]=vr2;
        map[2][map[0].length-1]=vr3;
        vr1.setDaemon(true);
        vr2.setDaemon(true);
        vr3.setDaemon(true);
        vr1.start();
        vr2.start();
        vr3.start();
    }
    @Override
    public void run() {
        int spwanpos;
        int typerd;
        while(availVirus>0){
            spwanpos= rd.nextInt(0,map.length);
            typerd= rd.nextInt(0,3);
            Virus vr;
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
                vr.setDaemon(true);
                vr.start();
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