package Unit;

import ImmuneSystemPack.ImmuneSystem;
import ProgramAST.Statement.GlobalFile.NodeTree;

import java.util.ArrayList;
import java.util.Arrays;

public interface Unit extends Runnable{
    int hp();
    int atk();
    int posx();
    int posy();
    int gain();
    default int nearby(String direction){
        ArrayList[][] map= ImmuneSystem.getmap();
        if(direction.equals("up"))
        {
            for (int i=posy();i>=0;i--){
                if(!map[i][posx()].isEmpty()){
                    return (posy()-i)*10+1;
                }
            }
        }
        else if(direction.equals("down")){
            for (int i=posy();i< map.length;i++){
                if(!map[i][posx()].isEmpty()){
                    return (i-posy())*10+5;
                }
            }
        }
        else if(direction.equals("left")){
            for (int i=posx();i>=0;i--){
                if(!map[posy()][i].isEmpty()){
                    return (posx()-i)*10+7;
                }
            }
        }
        else if(direction.equals("right"))
        {
            for (int i=posx();i<map[0].length;i++){
                if(!map[posy()][i].isEmpty()){
                    return (i-posx())*10+3;
                }
            }
        }
        else if(direction.equals("upleft")){
            for (int i=posy();i>=0;i--){ //up
                for (int j=posx();i>0;i--){ //left
                    if(!map[i][j].isEmpty()){
                        return (posx()-j)*10+8;
                    }
                    i--;
                    if(i<0)break;
                }

            }
        }
        else if(direction.equals("upright")){
            for (int i=posy();i>=0;i--){ //up
                for (int j=posx();j<map[0].length;j++){ //right
                    if(!map[i][j].isEmpty()){
                        return (j-posx())*10+2;
                    }
                    i--;
                    if(i<0)break;
                }

            }
        }
        else if(direction.equals("downleft")){
            for (int i=posy();i< map.length;i++){ //down
                for (int j=posx();j>=0;j--) { //left
                    if (!map[i][j].isEmpty()) {
                        return (posx()-j) * 10 + 6;
                    }
                    i++;
                    if(i>= map.length)break;
                }

            }
        }
        else if(direction.equals("downright")){
            for (int i=posy();i< map.length;i++){ //down
                for (int j=posx();j<map[0].length;j++) { //right
                    if (!map[i][j].isEmpty()) {
                        return (posx()-j) * 10 + 4;
                    }
                    i++;
                    if(i>= map.length)break;
                }
            }
        }

        return 0;
    }
    default int nearvirus(){
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
        //up
        for (int i=posy();i>=0||neardist[0]!=0;i--){
            for (Unit unit:map[i][posx()]
                 ) {
                if(unit.getClass().getName().equals("Virus")){
                    neardist[0]=(posy()-i)*10+1;
                }
            }
        }
        //down
        for (int i=posy();i< map.length||neardist[1]!=0;i++){
            for (Unit unit:map[i][posx()]
            ) {
                if(unit.getClass().getName().equals("Virus")){
                    neardist[1]=(i-posy())*10+5;
                }
            }
        }
        //left
        for (int i=posx();i>=0||neardist[2]!=0;i--){
            for (Unit unit:map[posy()][i]
            ) {
                if(unit.getClass().getName().equals("Virus")){
                    neardist[2]=(posx()-i)*10+7;
                }
            }
        }
        //right
        for (int i=posx();i<map[0].length||neardist[3]!=0;i++){
            for (Unit unit:map[posy()][i]
            ) {
                if(unit.getClass().getName().equals("Virus")){
                    neardist[3]=(i-posx())*10+3;
                }
            }
        }
        //upleft
        for (int i=posy();i>=0||neardist[4]!=0;i--){ //up
            for (int j=posx();i>0;i--){ //left
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Virus")){
                        neardist[4]=(posx()-j)*10+8;;
                    }
                }
                i--;
                if(i<0)break;
            }
        }
        //upright
        for (int i=posy();i>=0||neardist[5]!=0;i--){ //up
            for (int j=posx();j<map[0].length;j++){ //right
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Virus")){
                        neardist[5]=(j-posx())*10+2;;
                    }
                }
                i--;
                if(i<0)break;
            }

        }
        //downleft
        for (int i=posy();i< map.length||neardist[6]!=0;i++){ //down
            for (int j=posx();j>=0;j--) { //left
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Virus")){
                        neardist[6]=(posx()-j) * 10 + 6;
                    }
                }
                i++;
                if(i>= map.length)break;
            }

        }
        //downright
        for (int i=posy();i< map.length||neardist[7]!=0;i++){ //down
            for (int j=posx();j<map[0].length;j++) { //right
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Virus")){
                        neardist[7]=(posx()-j) * 10 + 4;
                    }
                }
                i++;
                if(i>= map.length)break;
            }
        }
        Arrays.sort(neardist);
        return neardist[0] ;
    }
    default int nearantibody(){
        ArrayList<Unit>[][] map=ImmuneSystem.getmap();
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
        //up
        for (int i=posy();i>=0||neardist[0]!=0;i--){
            for (Unit unit:map[i][posx()]
            ) {
                if(unit.getClass().getName().equals("Antibody")){
                    neardist[0]=(posy()-i)*10+1;
                }
            }
        }
        //down
        for (int i=posy();i< map.length||neardist[1]!=0;i++){
            for (Unit unit:map[i][posx()]
            ) {
                if(unit.getClass().getName().equals("Antibody")){
                    neardist[1]=(i-posy())*10+5;
                }
            }
        }
        //left
        for (int i=posx();i>=0||neardist[2]!=0;i--){
            for (Unit unit:map[posy()][i]
            ) {
                if(unit.getClass().getName().equals("Antibody")){
                    neardist[2]=(posx()-i)*10+7;
                }
            }
        }
        //right
        for (int i=posx();i<map[0].length||neardist[3]!=0;i++){
            for (Unit unit:map[posy()][i]
            ) {
                if(unit.getClass().getName().equals("Antibody")){
                    neardist[3]=(i-posx())*10+3;
                }
            }
        }
        //upleft
        for (int i=posy();i>=0||neardist[4]!=0;i--){ //up
            for (int j=posx();i>0;i--){ //left
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Antibody")){
                        neardist[4]=(posx()-j)*10+8;;
                    }
                }
                i--;
                if(i<0)break;
            }
        }
        //upright
        for (int i=posy();i>=0||neardist[5]!=0;i--){ //up
            for (int j=posx();j<map[0].length;j++){ //right
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Antibody")){
                        neardist[5]=(j-posx())*10+2;;
                    }
                }
                i--;
                if(i<0)break;
            }

        }
        //downleft
        for (int i=posy();i< map.length||neardist[6]!=0;i++){ //down
            for (int j=posx();j>=0;j--) { //left
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Antibody")){
                        neardist[6]=(posx()-j) * 10 + 6;
                    }
                }
                i++;
                if(i>= map.length)break;
            }

        }
        //downright
        for (int i=posy();i< map.length||neardist[7]!=0;i++){ //down
            for (int j=posx();j<map[0].length;j++) { //right
                for (Unit unit:map[i][j]
                ) {
                    if(unit.getClass().getName().equals("Antibody")){
                        neardist[7]=(posx()-j) * 10 + 4;
                    }
                }
                i++;
                if(i>= map.length)break;
            }
        }
        Arrays.sort(neardist);
        return neardist[0] ;
    }
    void move(String Direction);
    void attack(String Direction);
    void getattack(Unit unit);
    default int[] minDistanc(String direction,int multipier){
        if(direction.equals("up"))
        {
            return new int[]{posx(),posy()- multipier};
        }
        else if(direction.equals("down")){
            return new int[]{posx(),posy()+ multipier};
        }
        else if(direction.equals("left")){
            return new int[]{posx()- multipier,posy()};
        }
        else if(direction.equals("right"))
        {
            return new int[]{posx()+ multipier,posy()};
        }
        else if(direction.equals("upleft")){
            return new int[]{posx()- multipier,posy()- multipier};
        }
        else if(direction.equals("upright")){
            return new int[]{posx()+ multipier,posy()- multipier};
        }
        else if(direction.equals("downleft")){
            return new int[]{posx()- multipier,posy()+ multipier};
        }
        else if(direction.equals("downright")){
            return new int[]{posx()+ multipier,posy()+ multipier};
        }
        return null;
    }
}