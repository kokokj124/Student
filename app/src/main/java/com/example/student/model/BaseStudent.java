package com.example.student.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;


public class BaseStudent extends BaseObservable implements Serializable {
    public String SBD,HT;
    public double DT,DL,DH;

    public BaseStudent(String SBD, String HT, double DT, double DL, double DH) {
        this.SBD = SBD;
        this.HT = HT;
        this.DT = DT;
        this.DL = DL;
        this.DH = DH;
    }
    @Bindable
    public String getSBD() {
        return SBD;
    }
    @Bindable
    public String getHT() {
        return HT;
    }
    @Bindable
    public double getDT() {
        return DT;
    }
    @Bindable
    public double getDL() {
        return DL;
    }
    @Bindable
    public double getDH() {
        return DH;
    }
}
