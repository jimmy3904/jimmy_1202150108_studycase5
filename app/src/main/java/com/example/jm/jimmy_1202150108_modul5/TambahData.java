package com.example.jm.jimmy_1202150108_modul5;

/**
 * Created by JM on 3/24/2018.
 */

class TambahData {
    String todo, desc, prior;

    public TambahData(String todo, String deskrips, String priory){
        this.todo=todo;
        this.desc=deskrips;
        this.prior=priory;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}

