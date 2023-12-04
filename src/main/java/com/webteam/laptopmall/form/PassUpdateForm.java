package com.webteam.laptopmall.form;

public class PassUpdateForm {
    private String oldPlainPass;
    private String newPlainPass;
    private String reTypePlainPass;

    public PassUpdateForm() {
    }

    public PassUpdateForm(String oldPlainPass, String newPlainPass, String reTypePlainPass) {
        this.oldPlainPass = oldPlainPass;
        this.newPlainPass = newPlainPass;
        this.reTypePlainPass = reTypePlainPass;
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
