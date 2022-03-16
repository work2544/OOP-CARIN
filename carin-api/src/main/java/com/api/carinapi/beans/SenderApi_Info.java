package com.api.carinapi.beans;

public class SenderApi_Info {
    String type;
    int posx, posy;

    public SenderApi_Info(String type, int posx, int posy) {
        this.type = type;
        this.posx = posx;
        this.posy = posy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    
}
