package com.api.carinapi.beans;

public class RecieveApi {
    Info[] data;
    boolean isPause;

    public RecieveApi(Info[] data, boolean isPause) {
        this.data = data;
        this.isPause = isPause;
    }
    
    public Info[] getData() {
        return data;
    }
    public void setData(Info[] data) {
        this.data = data;
    }
    public boolean isPause() {
        return isPause;
    }
    public void setPause(boolean isPause) {
        this.isPause = isPause;
    }
    
}

class Info{
    String type;
    int posx;
    int posy;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPosx() {
        return posx;
    }
    public void setPosx(String posx) {
        int newPosx = Integer.parseInt(posx);
        this.posx = newPosx;
    }
    public int getPosy() {
        return posy;
    }
    public void setPosy(String posy) {
        int newPosy = Integer.parseInt(posy);
        this.posy = newPosy;
    }

    
}
