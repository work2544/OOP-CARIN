package ImmuneSystemPack;
import ProgramAST.Statement.GlobalFile.NodeTree;
import Unit.*;
import org.w3c.dom.Node;

import java.util.ArrayList;
public class ImmuneSystem {
    protected static   int m,n;
    protected static int Time;
    protected static ArrayList<Unit>[][] map;

    public ImmuneSystem(int m,int n){
        ImmuneSystem.m=m;
        ImmuneSystem.n=n;
        Time=0;
        map=new ArrayList[n][m];
    }
    public static ArrayList[][] getmap()
    {
        return map;
    }
    /**
     * manage virus and antibody
     */
    public static class ImmuneHandle extends Thread{
        protected static int initcred, antibodycost;
        protected static int atbihealth,vrhealth;
        protected static  int vratk,vrgain;
        protected static  int atbatk,atbgain;
        protected static  int movecost;
        protected static  int gaincredit;

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
        private  void imsetup(VirusFactory vf,AntibodyFactory af){
            vf.Vsetup();
            af.AntibodySetup();
        }
        public void run(){
            VirusFactory vr=new VirusFactory(vrhealth,vratk,vrgain);
            AntibodyFactory atb=new AntibodyFactory(atbihealth,atbatk,atbgain,movecost,antibodycost);
            Thread vrthread=new Thread(vr);
            imsetup(vr,atb);
            vrthread.setDaemon(true);
            vrthread.start();
            while(true) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j].size() > 0) {
                            System.out.print("*" + map[i][j].size());
                        } else {
                            System.out.print("-");
                        }
                    }
                    System.out.println();
                }
                try {
                    sleep(1000);
                    Time++;
                } catch (InterruptedException e) {
                }
            }
            }
    }
    public static void main(String[] args) throws InterruptedException {
        ImmuneHandle IH=new ImmuneHandle(500,100,15,2,100,10,5,200,2,50);
        ImmuneSystem IS=new ImmuneSystem(15,7);
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]= new ArrayList<Unit>();
            }
        }
        IH.start();
    }
}
