import java.util.ArrayList;

import Unit.Antibody;
import Unit.Virus;

public class Lung {
    int[][] map;
    //humanHost
    //virusHost
    ArrayList<Antibody> playerAntibodies;
    ArrayList<Virus> botVirus;
    public Lung(int m,int n){
        map=new int[m][n];
        playerAntibodies=new ArrayList<Antibody>();
        botVirus        =new ArrayList<Virus>();
    }
    public static void main(String[] args) {
        
    }
}
