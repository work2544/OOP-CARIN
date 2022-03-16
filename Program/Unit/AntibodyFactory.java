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

public class AntibodyFactory implements Runnable {
    int hp,atk,gain,movecost,placecost;
    int livedAnti=0;
    protected Unit[][] map= ImmuneSystem.getmap();

    public AntibodyFactory(int hp, int atk, int gain,int movecost, int placecost) {
        this.hp = hp;
        this.atk = atk;
        this.gain = gain;
        this.movecost = movecost;
        this.placecost = placecost;
    }
    public void AntibodySetup(){
        map[0][0]=CreatAntibody("knight",0,0);
        map[1][0]=CreatAntibody("shield",0,1);
        map[2][0]=CreatAntibody("mage",0,1);
        livedAnti+=3;
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

