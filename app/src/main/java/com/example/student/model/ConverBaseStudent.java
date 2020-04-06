package com.example.student.model;
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
        return "DTB: "+ Math.round(DTB*1000/1000);
    }
}
