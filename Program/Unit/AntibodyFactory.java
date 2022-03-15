package Unit;

import ImmuneSystemPack.ImmuneSystem;

import java.util.ArrayList;

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
        } else if (type.equals("archer")) {
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

    public Antibody(int hp, int atk, int gain,int posx,int posy) {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.posx=posx;
        this.posy=posy;
    }
    @Override
    public void attack(String Direction) {

    }

    @Override
    public void move(String Direction) {

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
        return gain;
    }

    @Override
    public int nearby(String Direction) {
        return 0;
    }

    @Override
    public int nearvirus() {
        return 0;
    }

    @Override
    public int nearantibody() {
        return 0;
    }
}
