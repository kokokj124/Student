package com.example.student.model;

import android.util.Log;

public class ConverBaseStudent{
    public ConverBaseStudent() {
    }
    public static String getContenSBD(String SBD) {
        return "SBD : "+SBD;
    }
    public static String getContentHT(String HT) {
        return "HoTen: "+HT;
    }
    public static String getContenDTB(double DTB){
        Log.d("ACV",""+(double)Math.round(DTB*100/100));
        return "DTB: "+ (double)Math.round(DTB*100/100);
    }
}
