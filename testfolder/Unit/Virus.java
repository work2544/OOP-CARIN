package Unit;
public class Virus implements Unit {
    int hp, movespeed, atk, range;
    int posx, posy;

    public Virus(int hp, int movespeed, int atk, int range) {
        this.hp = hp;
        this.movespeed = movespeed;
        this.atk = atk;
        this.range = range;
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

    public Virus CreatVirus(String type) {
        Virus virus = null;
        if (type.equals("melee")) {
            virus = new Virus(100, 0, 10, 1);
        } else if (type.equals("tank")) {
            virus = new Virus(200, 0, 1, 1);
        } else if (type.equals("archer")) {
            virus = new Virus(80, 0, 20, 5);
        }
        return virus;
    }

}