package Model;

/**
 * Created by SONY on 5/21/2016.
 */
public class Test implements Comparable<Test>{
    //public int made=0;
    public int macauhoi=0;
    public Test(int made, int cauhoi)
    {
       // this.made =made;
        this.macauhoi=cauhoi;
    }

    @Override
    public int compareTo(Test another) {
        this.macauhoi=another.macauhoi;
       // this.made=another.made;
        return 1;
    }
}
