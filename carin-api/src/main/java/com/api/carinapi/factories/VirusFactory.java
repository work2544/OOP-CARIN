package com.api.carinapi.factories;

import java.util.ArrayList;
import java.util.Random;

import com.api.carinapi.interfaces.Unit;

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

    public Virus(int hp, int atk, int gain,int posx,int posy) {
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
    public int nearby() {
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

}