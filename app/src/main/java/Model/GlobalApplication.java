package Model;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

/**
 * Created by SONY on 5/30/2016.
 */
public class GlobalApplication extends Application {

    String name;
    ArrayList<Selected>selectedList;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ArrayList<String>selectedList= new ArrayList<>();

    }

    public void setSelectedList(ArrayList<Selected>selectedList) {
        this.selectedList=selectedList;
    }

    public ArrayList<Selected> getSelectedList()
    {
        return selectedList;
    }

    public void setName(String name){ this.name=name;}

    public String getName(){return name;}



}
