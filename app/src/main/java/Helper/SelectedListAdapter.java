package Helper;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.quizz.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import Model.Selected;

/**
 * Created by SONY on 5/30/2016.
 */
public class SelectedListAdapter extends RecyclerView.Adapter<SelectedListAdapter.ViewHolder> {

    ArrayList<Selected>selectedList= new ArrayList<>();
    Context context;

    public SelectedListAdapter(ArrayList<Selected>selectedList, Context context)
    {
        this.selectedList=selectedList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_list_recycler_view_cell,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((ViewHolder) holder).selected.setText(selectedList.get(position).selected);
        if (selectedList.get(position).correct == 1) {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.ic_check_black))
                    .build();
            ((ViewHolder) holder).checkImage.setImageURI(uri);
        } else
        {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.ic_close_black_24dp))
                    .build();
            ((ViewHolder) holder).checkImage.setImageURI(uri);
        }
    }

    @Override
    public int getItemCount() {
        return selectedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public static SimpleDraweeView checkImage;
        public static TextView selected;

        public ViewHolder(View itemView) {
            super(itemView);
            checkImage=(SimpleDraweeView)itemView.findViewById(R.id.fresco_iamge_check_holder);
            selected=(TextView)itemView.findViewById(R.id.textview_selected);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
