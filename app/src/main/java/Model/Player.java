package Model;

/**
 * Created by SONY on 5/20/2016.
 */
public class Player  {
    public int score;
    private final String mFirstName;


    public Player(String firstName, int score) {
        mFirstName = firstName;
        this.score=score;
    }


    public String getFirstName() {
        return mFirstName;
    }

    public int getScore(){return  this.score;}


}
