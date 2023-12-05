package com.webteam.laptopmall.form;

import java.util.logging.Logger;

public class PassUpdateForm {
    private Long userId;
    private String oldPlainPass;
    private String newPlainPass;
    private String reTypePlainPass;

    public PassUpdateForm() {
    }

    public PassUpdateForm(Long userId, String oldPlainPass, String newPlainPass, String reTypePlainPass) {
        this.userId = userId;
        this.oldPlainPass = oldPlainPass;
        this.newPlainPass = newPlainPass;
        this.reTypePlainPass = reTypePlainPass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPlainPass() {
        return oldPlainPass;
    }

    public void setOldPlainPass(String oldPlainPass) {
        this.oldPlainPass = oldPlainPass;
    }

    public String getNewPlainPass() {
        return newPlainPass;
    }

    public void setNewPlainPass(String newPlainPass) {
        this.newPlainPass = newPlainPass;
    }

    public String getReTypePlainPass() {
        return reTypePlainPass;
    }

    public void setReTypePlainPass(String reTypePlainPass) {
        this.reTypePlainPass = reTypePlainPass;
    }
}
