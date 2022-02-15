package Unit;
public class Antibody implements Unit {
    int hp, movespeed, atk, range;
    int posx, posy;

    public Antibody(int hp, int movespeed, int atk, int range,int posx, int posy) {
        this.hp = hp;
        this.movespeed = movespeed;
        this.atk = atk;
        this.range = range;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    public void attact() {

    }

    @Override
    public void move() {

    }

    @Override
    public int hp() {
        return hp;
    }

    @Override
    public int movespeed() {
        return movespeed;
    }

    @Override
    public int range() {
        return range;
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
    public String toString() {
        return "atk: " + atk + ","+"hp: " + hp +"range: " + range+", posx: " + posx + ", posy: " + posy;
    }
    
        
    public static Antibody CreatAntibody(String type,int posx,int posy) {
        Antibody antibody = null;
        if (type.equals("melee")) {
            antibody = new MeleeAntibody(100, 0, 10, 1,posx,posy);
        } else if (type.equals("tank")) {
            antibody = new TankAntibody(200, 0, 1, 1,posx,posy);
        } else if (type.equals("archer")) {
            antibody = new RangeAntibody(80, 0, 20, 5,posx,posy);
        }
        return antibody;
    }
}
class MeleeAntibody extends Antibody {

    public MeleeAntibody(int hp, int movespeed, int atk, int range, int posx, int posy) {
        super(hp, movespeed, atk, range, posx, posy);
        //TODO Auto-generated constructor stub
    }

}
class TankAntibody extends Antibody {

    public TankAntibody(int hp, int movespeed, int atk, int range, int posx, int posy) {
        super(hp, movespeed, atk, range, posx, posy);
        //TODO Auto-generated constructor stub
    }

}
class RangeAntibody extends Antibody {

    public RangeAntibody(int hp, int movespeed, int atk, int range, int posx, int posy) {
        super(hp, movespeed, atk, range, posx, posy);
        //TODO Auto-generated constructor stub
    }
    
}
