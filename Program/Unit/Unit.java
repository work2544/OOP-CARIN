package Unit;

public interface Unit{
   
    int hp();
    int atk();
    int posx();
    int posy();
    int gain();
    int nearby(String Direction);
    int nearvirus();
    int nearantibody();
    void move(String Direction);
    void attack(String Direction);
}