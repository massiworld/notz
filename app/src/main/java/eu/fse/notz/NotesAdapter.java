package eu.fse.notz;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Amministratore on 12/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter {
    private ArrayList <Note> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTv;
        public TextView descriptionTv;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.title_tv);
            descriptionTv = (TextView) itemView.findViewById(R.id.description_tv);
        }
    }
    public NotesAdapter(ArrayList[] myDataset){mDataset = myDataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NotesAdapter.ViewHolder  noteVH = (NotesAdapter.ViewHolder)holder;
        Note currentNote = mDataset.get(position);
        noteVH.titleTv.setText(currentNote.getTitle());
        noteVH.descriptionTv.setText (currentNote.getdescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();

    }
}
