package Model;

import java.util.ArrayList;

/**
 * Created by SONY on 5/20/2016.
 */
public class Answer {

    int Ma;
    public String CauA, CauB, CauC, CauD;

    public Answer(int ma, String A, String B, String C, String D)
    {
        Ma=ma;
        CauA=A;
        CauB=B;
        CauC=C;
        CauD=D;
    }
    static public String dapAnA(int vitri, ArrayList<Answer> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauA;
    }
    static public String dapAnB(int vitri, ArrayList<Answer> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauB;
    }
    static public String dapAnC(int vitri, ArrayList<Answer> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauC;
    }
    static public String dapAnD(int vitri, ArrayList<Answer> danhsachdapan)
    {
        return danhsachdapan.get(vitri).CauD;
    }

}
