package Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import Model.Answer;
import Model.Player;
import Model.Question;
import Model.Test;

/**
 * Created by SONY on 4/25/2016.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "TRACNGHIEM.sqlite";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    public ArrayList<Question> layCauHoi() {
        ArrayList<Question> dsch=new ArrayList<Question>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from DuLieu",null);
        if(c.moveToFirst())
        {
            do{
                int ma=c.getInt(0);
                String cauhoi=c.getString(1);
                String cauTL=c.getString(2);
                String muc=c.getString(3);
                int hoanVi=c.getInt(4);
                Question ch=new Question(ma,cauhoi,cauTL,muc,hoanVi);
                dsch.add(ch);
            }while(c.moveToNext());
        }

        return dsch;
    }

    public ArrayList<Answer> layCauTL() {
        ArrayList<Answer> dsda=new ArrayList<Answer>();//danh sach dap an
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Answer",null);
        if(c.moveToFirst())
        {
            do{
                int ma=c.getInt(0);
                String cauA=c.getString(1);
                String cauB=c.getString(2);
                String cauC=c.getString(3);
                String cauD=c.getString(4);

                Answer dapan=new Answer(ma,cauA,cauB,cauC,cauD);
                dsda.add(dapan);
            }while(c.moveToNext());
        }

        return dsda;
    }

    public ArrayList<Test> layDeThi() {
        ArrayList<Test> dsDeThi=new ArrayList<Test>();//danh sach de thi
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from DeThi",null);
        if(c.moveToFirst())
        {
            do{
                int ma=c.getInt(0);
                int macauhoi=c.getInt(1);
                Test de= new Test(ma,macauhoi);
                dsDeThi.add(de);
            }while(c.moveToNext());
        }
        return dsDeThi;
    }

    public boolean DeleteDatafromDatabase(String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete  from "+ table);
        return  true;
    }

    public boolean insertPlayerIntoDB(Player player)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String fName=player.getFirstName();
        int score=player.getScore() ;
        db.execSQL("insert into Player (Fname,Score) values (' " + fName +" ' , "+" "+score+"  )");
        return true;

    }

    public ArrayList<Player> getUser() {
        ArrayList<Player> playerList=new ArrayList<Player>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from Player",null);
        if(c.moveToFirst())
        {
            do{

                String fName=c.getString(1);
                int score=c.getInt(2);
                Player player= new Player(fName, score);
                playerList.add(player);
            }while(c.moveToNext());
        }

        return playerList;
    }
}




