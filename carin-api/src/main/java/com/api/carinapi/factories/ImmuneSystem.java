package com.api.carinapi.factories;

import com.api.carinapi.interfaces.Unit;
public class ImmuneSystem {
    protected static   int m,n;
    protected static int Time;
    protected static Unit[][] map;

    public ImmuneSystem(int m,int n){
        ImmuneSystem.m=m;
        ImmuneSystem.n=n;
        Time=0;
        map=new Unit[n][m];
    }
    public static Unit[][] getmap()
    {
        return map;
    }
    /**
     * manage virus and antibody
     */
    public static class ImmuneHandle implements Runnable{
        protected static int initcred, antibodycost;
        protected static int atbihealth,vrhealth;
        protected static  int vratk,vrgain;
        protected static  int atbatk,atbgain;
        protected static  int movecost;
        protected static  int gaincredit;
        public static void increasedit(){
            initcred+=gaincredit;
        }
        public static void decreasedit(){
            initcred-=antibodycost;
        }
        public ImmuneHandle(int initcred,int antibodycost,int vratk,int vrgain,int vrhealth,int atbatk,int atbgain,int atbihealth,int movecost,int gaincredit){
            ImmuneHandle.initcred=initcred;
            ImmuneHandle.antibodycost = antibodycost;
            ImmuneHandle.vratk=vratk;
            ImmuneHandle.vrgain=vrgain;
            ImmuneHandle.vrhealth = vrhealth;
            ImmuneHandle.atbatk=atbatk;
            ImmuneHandle.atbgain=atbgain;
            ImmuneHandle.atbihealth=atbihealth;
            ImmuneHandle.movecost=movecost;
            ImmuneHandle.gaincredit=gaincredit;
            checkRep();
        }
        private void checkRep() {
            assert m > 0;
            assert n > 0;
            assert initcred > 0;
            assert antibodycost > 0; assert antibodycost<initcred;
            assert atbihealth > 0;
            assert vrhealth > 0;
            assert vratk > 0;
            assert vrgain > 0;
            assert atbatk > 0;
            assert atbgain > 0;
            assert movecost > 0;
            assert movecost < atbihealth;
            assert gaincredit > 0;
        }
        public void imsetup(VirusFactory vf,AntibodyFactory af){
            vf.Vsetup();
            af.AntibodySetup();
        }
        public void run(){
            VirusFactory vr=new VirusFactory(vrhealth,vratk,vrgain);
            AntibodyFactory atb=new AntibodyFactory(atbihealth,atbatk,atbgain,movecost,antibodycost);
            Thread vrthread=new Thread(vr);
            Thread atbthread=new Thread(atb);
            imsetup(vr,atb);
            vrthread.setDaemon(true);
            atbthread.setDaemon(true);
        //    vrthread.start();
            atbthread.start();
            while(AntibodyFactory.livedAnti!=0&&VirusFactory.liveVirus!=0) {
                System.out.println("live an"+AntibodyFactory.livedAnti);
                System.out.println("live vi"+VirusFactory.liveVirus);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j]!=null) {
                            String unitname=map[i][j].getClass().getName().split("\\.")[1];
                                switch (unitname){
                                    case "KnightAntibody":
                                        System.out.print("*");
                                        break;
                                    case "KnightVirus":
                                        System.out.print("(*)");
                                        break;
                                    case "MageAntibody":
                                        System.out.print("#");
                                        break;
                                    case "MageVirus":
                                        System.out.print("(#)");
                                        break;
                                    case "ShieldAntibody":
                                        System.out.print("@");
                                        break;
                                    default:
                                        System.out.print("(@)");
                                }
                        } else {
                            System.out.print("-");
                        }
                    }
                    System.out.println();
                }
                try {
                    Thread.sleep(1000);
                    Time++;
                } catch (InterruptedException e) {
                }
            }
            vrthread.interrupt();
            atbthread.interrupt();
            }
    }
    // public static void main(String[] args) throws InterruptedException {
    //     ImmuneHandle IH = new ImmuneHandle(500, 100, 15, 2, 100, 10, 5, 200, 2, 50);
    //     ImmuneSystem IS = new ImmuneSystem(15, 7);
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             map[i][j] = null;
    //         }
    //     }
    //     Thread ihthread=new Thread(IH);
    //     ihthread.start();


    // }
}