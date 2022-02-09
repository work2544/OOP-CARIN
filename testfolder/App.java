import java.util.Scanner;
public class App {
   
    public static void main(String[] args) {
        Lung l= new Lung(10,10);
        Scanner scanner = new Scanner(System.in);
       
       for (int i = 0; i < 3; i++) {
          
           
                System.out.print("Input antibody type: ");
                String type=scanner.next();
                System.out.print("Input posx: ");
                int posx=scanner.nextInt();
                System.out.print("Input posy: ");
                int posy=scanner.nextInt();
                Antibody antibody=Antibody.CreatAntibody(type.toLowerCase(),posx,posy);
                System.out.println(antibody);
                if(antibody!=null)
                {
                    l.playerAntibodies.add(antibody);
                }
                System.out.print("end round");
               
               
        }
        scanner.close();
        System.out.println(l.playerAntibodies.size());
        for(Antibody at:l.playerAntibodies)
        {
            System.out.println(at);
        }
    }
}
