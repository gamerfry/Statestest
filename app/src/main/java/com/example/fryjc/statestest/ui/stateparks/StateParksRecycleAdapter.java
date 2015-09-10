package com.example.fryjc.statestest.ui.stateparks;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fryjc.statestest.R;
import com.example.fryjc.statestest.models.State;
import com.example.fryjc.statestest.models.StatePark;

import java.util.ArrayList;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateParksRecycleAdapter extends RecyclerView.Adapter<StateParksViewHolder> {
    private ArrayList<StatePark> mStateParkList;
    private ArrayList<Drawable> backgroundPictures;
    public StateParksRecycleAdapter(Activity context, ArrayList<StatePark> stateParkList) {
        backgroundPictures.add(context.getDrawable(R.drawable.park1));
        backgroundPictures.add(context.getDrawable(R.drawable.park2));
        backgroundPictures.add(context.getDrawable(R.drawable.park3));
        backgroundPictures.add(context.getDrawable(R.drawable.park4));
        backgroundPictures.add(context.getDrawable(R.drawable.park5));
        backgroundPictures.add(context.getDrawable(R.drawable.park6));
        mStateParkList=stateParkList;
    }

    @Override
    public StateParksViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.state_view,viewGroup, false);
        StateParksViewHolder viewHolder = new StateParksViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StateParksViewHolder stateParksViewHolder, int position) {
        stateParksViewHolder.itemView.setBackground(backgroundPictures.get(position));
        stateParksViewHolder.stateParkNameTextView.setText(mStateParkList.get(position).getmStateParkName());
    }

    @Override
    public int getItemCount() {
        return mStateParkList.size();
    }

    public ArrayList<StatePark> getData(){
        return mStateParkList;
    }
}
