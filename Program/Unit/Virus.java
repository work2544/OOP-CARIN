package Unit;

import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Parser.Parser;
import ProgramAST.Parser.ReadGenetic;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Virus extends Thread implements Unit {
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

    }
    @Override
    synchronized public void attack(String Direction) {
        Unit[][] map= ImmuneSystem.getmap();
        int[] answer=minDistanc(Direction,1);
                if(map[answer[1]][answer[0]]!=null)
                    if(map[answer[1]][answer[0]] instanceof Antibody)
                    {
                        map[answer[1]][answer[0]].getattack(this);
                        this.hp+=gain();
                        if(map[answer[1]][answer[0]].hp()<=0){
                            map[answer[1]][answer[0]]=null;
                            AntibodyFactory.livedAnti--;
                            VirusFactory.CreatVirus("knight",answer[0],answer[1]);
                        }
                    }
        }


    @Override
    synchronized public void getattack(Unit unit) {
        this.hp-=unit.atk();
    }

    @Override
    synchronized public void move(String Direction) {
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
    synchronized public int nearby(String direction) {
        Unit[][] map= ImmuneSystem.getmap();
        if(direction.equals("up"))
        {
            for (int i=posy()-1;i>=0;i--){
                if(map[i][posx()]!=null){
                    return (posy()-i)*10+1;
                }
            }
        }
        else if(direction.equals("down")){
            for (int i=posy()+1;i< map.length;i++){
                if(map[i][posx()]!=null){
                    return (i-posy())*10+5;
                }
            }
        }
        else if(direction.equals("left")){
            for (int i=posx()-1;i>=0;i--){
                if(map[posy()][i]!=null){
                    return (posx()-i)*10+7;
                }
            }
        }
        else if(direction.equals("right"))
        {
            for (int i=posx()+1;i<map[0].length;i++){
                if(map[posy()][i]!=null){
                    return (i-posx())*10+3;
                }
            }
        }
        else if(direction.equals("upleft")){
            for (int i=posy()-1;i>=0;i--){ //up
                for (int j=posx()-1;i>0;i--){ //left
                    if(map[i][j]!=null){
                        return (posx()-j)*10+8;
                    }
                    i--;
                    if(i<0)break;
                }

            }
        }
        else if(direction.equals("upright")){
            for (int i=posy()-1;i>=0;i--){ //up
                for (int j=posx()+1;j<map[0].length;j++){ //right
                    if(map[i][j]!=null){
                        return (j-posx())*10+2;
                    }
                    i--;
                    if(i<0)break;
                }

            }
        }
        else if(direction.equals("downleft")){
            for (int i=posy()+1;i< map.length;i++){ //down
                for (int j=posx()-1;j>=0;j--) { //left
                    if (map[i][j]!=null) {
                        return (posx()-j) * 10 + 6;
                    }
                    i++;
                    if(i>= map.length)break;
                }

            }
        }
        else if(direction.equals("downright")){
            for (int i=posy()+1;i< map.length;i++){ //down
                for (int j=posx()+1;j<map[0].length;j++) { //right
                    if (map[i][j]!=null) {
                        return (posx()-j) * 10 + 4;
                    }
                    i++;
                    if(i>= map.length)break;
                }
            }
        }

        return 0;
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
            while(hp>0)
            {
                System.out.println("vr"+posx()+" "+posy);
                this.nt=new Parser(ReadGenetic.GetGenetic("Program/ProgramAST/GeneticCode/VirusGene"),unitvar,this).parseProgram();
                nt.eval();
                sleep(1000);
            }
        } catch (EvalError | SyntaxError | InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public int nearvirus(){
        Unit[][] map=ImmuneSystem.getmap();
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
        if(VirusFactory.liveVirus==0)return 0;
        for (int i = 0; i < 8; i++) {
            neardist[i]=Integer.MAX_VALUE;
        }
        //up
        for (int i=posy()-1;i>=0;i--){
            if(map[i][posx()]!=null) {
                if(map[i][posx()] instanceof Virus){
                    neardist[0]=(posy()-i)*10+1;
                    break;
                }
            }
        }
        //down
        for (int i=posy()+1;i< map.length;i++){
            if(map[i][posx()]!=null) {
                if(map[i][posx()] instanceof Virus){
                    neardist[1]=(i-posy())*10+5;
                    break;
                }
            }
        }
        //left
        for (int i=posx()-1;i>=0;i--){
            if(map[posy()][i]!=null
            ) {
                if(map[posy()][i] instanceof Virus){
                    neardist[2]=(posx()-i)*10+7;
                    break;
                }
            }
        }
        //right
        for (int i=posx()+1;i<map[0].length;i++){
            if(map[posy()][i]!=null
            ) {
                if(map[posy()][i] instanceof Virus){
                    neardist[3]=(i-posx())*10+3;
                    break;
                }
            }
        }
        //upleft
        for (int i=posy()-1;i>=0;i--){ //up
            for (int j=posx()-1;j>0;j--){ //left
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Virus){
                        neardist[4]=(posx()-j)*10+8;
                        break;
                    }
                }
                i--;
                if(i<0)break;
            }
        }
        //upright
        for (int i=posy()-1;i>=0;i--){ //up
            for (int j=posx()+1;j<map[0].length;j++){ //right
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Virus){
                        neardist[5]=(j-posx())*10+2;
                        break;
                    }
                }
                i--;
                if(i<0)break;
            }

        }
        //downleft
        for (int i=posy()+1;i< map.length;i++){ //down
            for (int j=posx()-1;j>=0;j--) { //left
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Virus){
                        neardist[6]=(posx()-j) * 10 + 6;
                        break;
                    }
                }
                i++;
                if(i>= map.length)break;
            }

        }
        //downright
        for (int i=posy()+1;i< map.length;i++){ //down
            for (int j=posx()+1;j<map[0].length;j++) { //right
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Virus){
                        neardist[7]=(posx()-j) * 10 + 4;
                        break;
                    }
                }
                i++;
                if(i>= map.length)break;
            }
        }
        Arrays.sort(neardist);
        return neardist[0] ;
    }
    synchronized public int nearantibody(){
        Unit[][] map=ImmuneSystem.getmap();
        if(AntibodyFactory.livedAnti==0)return 0;
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
        for (int i = 0; i < 8; i++) {
            neardist[i]=Integer.MAX_VALUE;
        }
        //up
        for (int i=posy()-1;i>=0;i--){
            if(map[i][posx()]!=null
            ) {
                if(map[i][posx()] instanceof Antibody){
                    neardist[0]=(posy()-i)*10+1;
                    break;
                }
            }
        }
        //down
        for (int i=posy()+1;i< map.length;i++){
            if(map[i][posx()]!=null
            ) {
                if(map[i][posx()] instanceof Antibody){
                    neardist[1]=(i-posy())*10+5;
                    break;
                }
            }
        }
        //left
        for (int i=posx()-1;i>=0;i--){
            if(map[posy()][i]!=null) {
                if(map[posy()][i] instanceof Antibody){
                    neardist[2]=(posx()-i)*10+7;
                    break;
                }
            }
        }
        //right
        for (int i=posx()+1;i<map[0].length;i++){
            if(map[posy()][i]!=null
            ) {
                if(map[posy()][i] instanceof Antibody){
                    neardist[3]=(i-posx())*10+3;
                    break;
                }
            }
        }
        //upleft
        for (int i=posy()-1;i>=0;i--){ //up
            for (int j=posx()-1;j>0;j--){ //left
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Antibody){
                        neardist[4]=(posx()-j)*10+8;
                        break;
                    }
                }
                i--;
                if(i<0)break;
            }
        }
        //upright
        for (int i=posy()-1;i>=0;i--){ //up
            for (int j=posx()+1;j<map[0].length;j++){ //right
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Antibody){
                        neardist[5]=(j-posx())*10+2;break;
                    }
                }
                i--;
                if(i<0)break;
            }

        }
        //downleft
        for (int i=posy()+1;i< map.length;i++){ //down
            for (int j=posx()-1;j>=0;j--) { //left
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Antibody){
                        neardist[6]=(posx()-j) * 10 + 6;
                        break;
                    }
                }
                i++;
                if(i>= map.length)break;
            }

        }
        //downright
        for (int i=posy()+1;i< map.length;i++){ //down
            for (int j=posx()+1;j<map[0].length;j++) { //right
                if(map[i][j]!=null
                ) {
                    if(map[i][j] instanceof Antibody){
                        neardist[7]=(posx()-j) * 10 + 4;
                        break;
                    }
                }
                i++;
                if(i>= map.length)break;
            }
        }
        Arrays.sort(neardist);
        return neardist[0] ;
    }
    synchronized public int[] minDistanc(String direction,int multipier){
        if(direction.equals("up")&&posy()- multipier>=0)
        {
            return new int[]{posx(),posy()- multipier};
        }
        else if(direction.equals("down")&&posy()+ multipier<=ImmuneSystem.getmap().length){
            return new int[]{posx(),posy()+ multipier};
        }
        else if(direction.equals("left")&&posx()- multipier>=0){
            return new int[]{posx()- multipier,posy()};
        }
        else if(direction.equals("right")&&posx()+ multipier<=ImmuneSystem.getmap()[0].length)
        {
            return new int[]{posx()+ multipier,posy()};
        }
        else if(direction.equals("upleft")&&posy()- multipier>=0&&posx()- multipier>=0){
            return new int[]{posx()- multipier,posy()- multipier};
        }
        else if(direction.equals("upright")&&posy()- multipier>=0&&posx()+ multipier<=ImmuneSystem.getmap()[0].length){
            return new int[]{posx()+ multipier,posy()- multipier};
        }
        else if(direction.equals("downleft")&&posy()+ multipier<=ImmuneSystem.getmap().length&&posx()- multipier>=0){
            return new int[]{posx()- multipier,posy()+ multipier};
        }
        else if(direction.equals("downright")&&posy()+ multipier<=ImmuneSystem.getmap().length&&posx()+ multipier<=ImmuneSystem.getmap()[0].length){
            return new int[]{posx()+ multipier,posy()+ multipier};
        }
        return new int[]{posx(),posy()};
    }
}
