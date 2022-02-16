package Unit;

public interface Unit{
   
    int hp();
    int movespeed();
    int range();
    int atk();
    int posx();
    int posy();
    int nearby();
    void move(String Direction);

    void attack(String Direction);
}