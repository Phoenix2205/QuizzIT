package Model;

import java.util.ArrayList;

/**
 * Created by SONY on 4/26/2016.
 */
public class QuestionLevel {
    public int macauhoi, hoanvi;
    public String cauhoi, cauTL;
    public String CauA, CauB, CauC, CauD;

    public QuestionLevel(int ma, String cauhoi, String cauTL, String da_A, String da_B, String da_C, String da_D, int hoanvi)
    {
        this.macauhoi=ma;
        this.cauhoi=cauhoi;
        this.cauTL=cauTL;
        this.CauA=da_A;
        this.CauB=da_B;
        this.CauC=da_C;
        this.CauD=da_D;
        this.hoanvi=hoanvi;
    }

    static public String dapAnA(int vitri, ArrayList<QuestionLevel> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauA;
    }
    static public String dapAnB(int vitri, ArrayList<QuestionLevel> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauB;
    }
    static public String dapAnC(int vitri, ArrayList<QuestionLevel> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauC;
    }
    static public String dapAnD(int vitri, ArrayList<QuestionLevel> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauD;
    }

    static public String inCauHoi(int vitri, ArrayList<QuestionLevel> dsCauHoi)
    {
        String temp=dsCauHoi.get(vitri).macauhoi+"/ "+dsCauHoi.get(vitri).cauhoi;
        return temp;
    }


}
