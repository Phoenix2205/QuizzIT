package Model;

import java.util.ArrayList;

/**
 * Created by SONY on 5/20/2016.
 */
public class Question {
    public int Ma,Hoanvi;
    public String Cauhoi, CauTL,Muc;

    public Question(int ma,String cauhoi, String cauTL, String muc, int hoanvi)
    {
        Ma=ma;
        Cauhoi=cauhoi;
        CauTL=cauTL;
        Muc=muc;
        Hoanvi=hoanvi;
    }

    static public String  inCauHoi(int vitri, ArrayList<Question> dsCauHoi)
    {
        String temp=dsCauHoi.get(vitri).Ma+"/ "+dsCauHoi.get(vitri).Cauhoi;
        return temp;
    }
}
