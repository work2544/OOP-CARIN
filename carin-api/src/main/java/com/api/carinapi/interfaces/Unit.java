package com.api.carinapi.interfaces;

import java.util.ArrayList;
import java.util.Arrays;

import com.api.carinapi.factories.Antibody;
import com.api.carinapi.factories.ImmuneSystem;

public interface Unit extends Runnable{
    int hp();
    int atk();
    int posx();
    int posy();
    int gain();
    default int nearby(String direction){
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
    default int nearvirus(){
        Unit[][] map=ImmuneSystem.getmap();
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
        //up
        for (int i=posy()-1;i>=0;i--){
            if(map[i][posx()]!=null) {
                if(map[i][posx()].getClass().getName().split("\\.")[0].equals("Virus")){
                    neardist[0]=(posy()-i)*10+1;
                    break;
                }
            }
        }
        //down
        for (int i=posy()+1;i< map.length;i++){
            if(map[i][posx()]!=null) {
                if(map[i][posx()].getClass().getName().split("\\.")[0].equals("Virus")){
                    neardist[1]=(i-posy())*10+5;
                    break;
                }
            }
        }
        //left
        for (int i=posx()-1;i>=0;i--){
            if(map[posy()][i]!=null
            ) {
                if(map[posy()][i].getClass().getName().split("\\.")[0].equals("Virus")){
                    neardist[2]=(posx()-i)*10+7;
                    break;
                }
            }
        }
        //right
        for (int i=posx()+1;i<map[0].length;i++){
            if(map[posy()][i]!=null
            ) {
                if(map[posy()][i].getClass().getName().split("\\.")[0].equals("Virus")){
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
                    if(map[i][j].getClass().getName().split("\\.")[0].equals("Virus")){
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
                    if(map[i][j].getClass().getName().split("\\.")[0].equals("Virus")){
                        neardist[5]=(j-posx())*10+2;
                        break;
                    }
                }
                i--;
                if(i<0)break;
            }

        }
        //downleft
        for (int i=posy()-1;i< map.length;i++){ //down
            for (int j=posx()+1;j>=0;j--) { //left
                if(map[i][j]!=null
                ) {
                    if(map[i][j].getClass().getName().split("\\.")[0].equals("Virus")){
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
                    if(map[i][j].getClass().getName().split("\\.")[0].equals("Virus")){
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
    default int nearantibody(){
        Unit[][] map=ImmuneSystem.getmap();
        //หา 8 ทิศ แล้วหามิน
        int[] neardist=new int[8];
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
            System.out.println(map[posy()][i]);
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