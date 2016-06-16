package Helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.quizz.R;

import java.util.ArrayList;

import Model.Player;

/**
 * Created by SONY on 5/30/2016.
 */
public class TopScoreAdapter extends RecyclerView.Adapter<TopScoreAdapter.ViewHolder> {

    ArrayList<Player>playerList = new ArrayList<>();
    Context context;
    public TopScoreAdapter(Context context, ArrayList<Player>playerList)
    {
        this.context=context;
        this.playerList=playerList;
    }

    @Override
    public TopScoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_score_recycler_view_cell,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TopScoreAdapter.ViewHolder holder, int position) {
        ((ViewHolder) holder).name.setText(playerList.get(position).getFirstName());
        ((ViewHolder) holder).score.setText(Integer.toString(playerList.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public static TextView name;
        public static TextView score;

        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.text_view_name);
            score=(TextView)itemView.findViewById(R.id.text_view_point);
        }
    }
}
