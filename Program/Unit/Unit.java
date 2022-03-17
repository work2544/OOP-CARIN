package Unit;

import ImmuneSystemPack.ImmuneSystem;
import java.util.Arrays;

public interface Unit  {
    int hp();
    int atk();
    int posx();
    int posy();
    int gain();
    int nearby(String direction);
    int nearvirus();
    int nearantibody();
    void move(String Direction);
    void attack(String Direction);
    void getattack(Unit unit);
    int[] minDistanc(String direction,int multipier);
}