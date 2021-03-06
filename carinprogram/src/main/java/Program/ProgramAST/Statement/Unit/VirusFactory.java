package Unit;

import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Parser.Parser;
import ProgramAST.Parser.ReadGenetic;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;

public class VirusFactory implements Runnable {
    private  int hp, atk,gain;
    private Random rd=new Random();
    protected ArrayList<Unit>[][] map=ImmuneSystem.getmap();
    private double spwanrate=rd.nextDouble(0,1);
    private int availVirus=20;
    private int liveVirus=0;
    public VirusFactory(int hp, int atk, int gain){
    this.hp=hp;
    this.atk=atk;
    this.gain=gain;
    }
    public Virus CreatVirus(String type,int posx,int posy) {
        Virus virus = null;
        if (type.equals("melee")) {
            virus = new Virus(hp, atk, gain,posx,posy);
        } else if (type.equals("tank")) {
            virus = new Virus(hp, atk, gain,posx,posy);
        } else if (type.equals("archer")) {
            virus = new Virus(hp, atk, gain,posx,posy);
        }
        return virus;
    }
    public void Vsetup(){
        map[0][7].add(CreatVirus("melee",0,7));
        map[1][7].add(CreatVirus("tank",1,7));
        map[2][7].add(CreatVirus("range",2,7));
        availVirus-=3;
        liveVirus+=3;
    }
    @Override
    public void run() {
        int spwanpos;
        int typerd;
        while(availVirus>0){
            try {
                spwanpos= rd.nextInt(0,5);
                typerd= rd.nextInt(0,3);
                while(map[spwanpos][7].size()>0)spwanpos= rd.nextInt(0,5);
                switch (typerd){
                    case 0:
                        map[spwanpos][7].add(CreatVirus("melee",spwanpos,7));
                        break;
                    case 1:
                        map[spwanpos][7].add(CreatVirus("tank",spwanpos,7));
                        break;
                    default: map[spwanpos][7].add(CreatVirus("range",spwanpos,7));
                }
                availVirus--;
                liveVirus++;
                sleep((long) (1000/spwanrate));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
            this.nt= (NodeTree) new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene"),unitvar,this);
        }
        catch (SyntaxError e){
            System.out.println("cannot parse gene");
        }

    }
    @Override
    public void attack(String Direction) {
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
        for (Unit unit :map[answer[1]][answer[0]]
             ) {
            if(unit.getClass().getName().equals("Antibody"))
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
    public void move(String Direction) {
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
       if(answer[0]<map[0].length&&answer[1]<map.length&&answer[0]>-1&&answer[1]>-1)
       {  posx+=answer[0];
        posy+=answer[1];}
    }
//    @Override
//    public int nearby(String direction) {
//        ArrayList[][] map=ImmuneSystem.getmap();
//        if(direction.equals("up"))
//        {
//            for (int i=posy;i>=0;i--){
//                if(!map[i][posx].isEmpty()){
//                    return (posy-i)*10+1;
//                }
//            }
//        }
//        else if(direction.equals("down")){
//            for (int i=posy;i< map.length;i++){
//                if(!map[i][posx].isEmpty()){
//                    return (i-posy)*10+5;
//                }
//            }
//        }
//        else if(direction.equals("left")){
//            for (int i=posx;i>=0;i--){
//                if(!map[posy][i].isEmpty()){
//                    return (posx-i)*10+7;
//                }
//            }
//        }
//        else if(direction.equals("right"))
//        {
//            for (int i=posx;i<map[0].length;i++){
//                if(!map[posy][i].isEmpty()){
//                    return (i-posx)*10+3;
//                }
//            }
//        }
//        else if(direction.equals("upleft")){
//            for (int i=posy;i>=0;i--){ //up
//                for (int j=posx;i>0;i--){ //left
//                    if(!map[i][j].isEmpty()){
//                        return (posx-j)*10+8;
//                    }
//                    i--;
//                    if(i<0)break;
//                }
//
//            }
//        }
//        else if(direction.equals("upright")){
//            for (int i=posy;i>=0;i--){ //up
//                for (int j=posx;j<map[0].length;j++){ //right
//                    if(!map[i][j].isEmpty()){
//                        return (j-posx)*10+2;
//                    }
//                    i--;
//                    if(i<0)break;
//                }
//
//            }
//        }
//        else if(direction.equals("downleft")){
//            for (int i=posy;i< map.length;i++){ //down
//                for (int j=posx;j>=0;j--) { //left
//                    if (!map[i][j].isEmpty()) {
//                        return (posx-j) * 10 + 6;
//                    }
//                    i++;
//                }
//                if(i>= map.length)break;
//            }
//        }
//        else if(direction.equals("downright")){
//            for (int i=posy;i< map.length;i++){ //down
//                for (int j=posx;j<map[0].length;j++) { //right
//                    if (!map[i][posx].isEmpty()) {
//                        return (posx-j) * 10 + 4;
//                    }
//                    if(i>= map.length)break;
//                }
//            }
//        }
//
//        return 0;
//    }

//    @Override
//    public int nearvirus() {
//        ArrayList[][] map=ImmuneSystem.getmap();
//        //?????? 8 ????????? ???????????????????????????
//        int[] neardist=new int[8];
//        //up
//        for (int i=posy;i>=0;i--){
//            if(map[i][posx].isEmpty()){
//                return (posy-i)*10+1;
//            }
//        }
//        //down
//        for (int i=posy;i< map.length;i++){
//            if(!map[i][posx].isEmpty()){
//                return (i-posy)*10+5;
//            }
//        }
//        //left
//        for (int i=posx;i>=0;i--){
//            if(!map[posy][i].isEmpty()){
//                return (posx-i)*10+7;
//            }
//        }
//        //right
//        for (int i=posx;i<map[0].length;i++){
//            if(!map[posy][i].isEmpty()){
//                return (i-posx)*10+3;
//            }
//        }
//        //upleft
//        for (int i=posy;i>=0;i--){ //up
//            for (int j=posx;i>0;i--){ //left
//                if(!map[i][j].isEmpty()){
//                    return (posx-j)*10+8;
//                }
//                i--;
//                if(i<0)break;
//            }
//        }
//        //upright
//        for (int i=posy;i>=0;i--){ //up
//            for (int j=posx;j<map[0].length;j++){ //right
//                if(!map[i][j].isEmpty()){
//                    return (j-posx)*10+2;
//                }
//                i--;
//                if(i<0)break;
//            }
//
//        }
//        //downleft
//        for (int i=posy;i< map.length;i++){ //down
//            for (int j=posx;j>=0;j--) { //left
//                if (!map[i][j].isEmpty()) {
//                    return (posx-j) * 10 + 6;
//                }
//                i++;
//            }
//            if(i>= map.length)break;
//        }
//        //downright
//        for (int i=posy;i< map.length;i++){ //down
//            for (int j=posx;j<map[0].length;j++) { //right
//                if (!map[i][posx].isEmpty()) {
//                    return (posx-j) * 10 + 4;
//                }
//                if(i>= map.length)break;
//            }
//        }
//        return 0;
//    }

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