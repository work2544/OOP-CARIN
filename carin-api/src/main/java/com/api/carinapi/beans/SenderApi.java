package com.api.carinapi.beans;

public class SenderApi {
    SenderApi_Info[] id;
    boolean complete;

    public SenderApi(SenderApi_Info[] data, boolean isPause) {
        this.id = data;
        this.complete = isPause;
    }
    
    public SenderApi_Info[] getData() {
        return id;
    }
    public void setData(SenderApi_Info[] data) {
        this.id = data;
    }
    public boolean isPause() {
        return complete;
    }
    public void setPause(boolean isPause) {
        this.complete = isPause;
    }
    
}

