package com.api.carinapi.factories;

import com.api.carinapi.interfaces.Unit;


public class AntibodyFactory implements Runnable {
    int hp,atk,gain,movecost,placecost;
    public static int livedAnti=0;
    protected Unit[][] map= ImmuneSystem.getmap();

    public AntibodyFactory(int hp, int atk, int gain,int movecost, int placecost) {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.movecost = movecost;
        this.placecost = placecost;
    }
    public void AntibodySetup(){
        Antibody atb1=CreatAntibody("knight",0,0);
        Antibody atb2=CreatAntibody("shield",0,1);
        Antibody atb3=CreatAntibody("mage",0,2);
        map[0][0]=atb1;
        map[1][0]=atb2;
        map[2][0]=atb3;
        atb1.setDaemon(true);
        atb2.setDaemon(true);
        atb3.setDaemon(true);
        atb1.start();
        atb2.start();
        atb3.start();
    }
    public Antibody CreatAntibody(String type,int posx,int posy) {
        Antibody antibody = null;
        if (type.equals("knight")) {
            antibody = new KnightAntibody(hp, atk, gain,posx,posy);
        } else if (type.equals("shield")) {
            antibody = new ShieldAntibody(hp, atk, gain,posx,posy);
        } else if (type.equals("mage")) {
            antibody = new MageAntibody(hp, atk, gain,posx,posy);
        }
        livedAnti++;
        map[posy][posx]=antibody;
        return antibody;
    }

    @Override
    public void run() {

    }
}
class KnightAntibody extends Antibody {

    public KnightAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp,  atk, gain, posx, posy);
    }

}
class ShieldAntibody extends Antibody {

    public ShieldAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}
class MageAntibody extends Antibody {

    public MageAntibody(int hp,  int atk, int gain, int posx, int posy) {
        super(hp, atk, gain, posx, posy);
    }

}