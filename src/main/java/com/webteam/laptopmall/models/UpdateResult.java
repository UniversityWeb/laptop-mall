package com.webteam.laptopmall.models;

import java.io.Serializable;

public class UpdateResult implements Serializable {
    private int effectRows;
    private long generatedKey;

    public UpdateResult(int effectRows, long generatedKey) {
        this.effectRows = effectRows;
        this.generatedKey = generatedKey;
    }

    public int getEffectRows() {
        return effectRows;
    }

    public void setEffectRows(int effectRows) {
        this.effectRows = effectRows;
    }

    public long getGeneratedKey() {
        return generatedKey;
    }

    public void setGeneratedKey(long generatedKey) {
        this.generatedKey = generatedKey;
    }

    public boolean isSuccess(){
        return effectRows>0;
    }
}
