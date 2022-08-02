package com.example.toastproba;

public class DisplayUpr {
    private boolean plus=false;
    private boolean minus=false;
    private boolean umn=false;
    private boolean razd=false;

    public void setPlus() {
        this.plus=true;
        this.minus=false;
        this.umn=false;
        this.razd=false;

    }
    public boolean getPlus(){
        return this.plus;

    }

    public void setMinus() {
        this.plus=false;
        this.minus=true;
        this.umn=false;
        this.razd=false;

    }

    public boolean getMinus(){
       return this.minus;
    }

    public void setUmn(){
        this.plus=false;
        this.minus=false;
        this.umn=true;
        this.razd=false;

    }
    public boolean getUmn(){
        return this.umn;
    }


    public void setRazd() {
        this.plus = false;
        this.minus = false;
        this.umn = false;
        this.razd = true;

    }
    public boolean getRazd(){
        return this.razd;
    }
}