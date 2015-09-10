package com.example.fryjc.statestest.ui.states;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fryjc.statestest.R;
import com.example.fryjc.statestest.models.State;

import java.util.ArrayList;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateRecycleAdapter extends RecyclerView.Adapter<StateViewHolder> {
    private ArrayList<State> mStateList;
    public StateRecycleAdapter(ArrayList<State> stateList) {
        mStateList=stateList;
    }

    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.state_view,viewGroup, false);
        StateViewHolder viewHolder = new StateViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StateViewHolder stateViewHolder, int position) {
        stateViewHolder.stateNameTextView.setText(mStateList.get(position).getmStateName());
        stateViewHolder.fact1TextView.setText(mStateList.get(position).getmFact1());
        stateViewHolder.fact2TextView.setText(mStateList.get(position).getmFact2());
        stateViewHolder.fact3TextView.setText(mStateList.get(position).getmFact3());
        stateViewHolder.fact4TextView.setText(mStateList.get(position).getmFact4());
    }

    @Override
    public int getItemCount() {
        return mStateList.size();
    }

    public ArrayList<State> getData(){
        return mStateList;
    }
}
