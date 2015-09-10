package com.example.fryjc.statestest.ui.states;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.fryjc.statestest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateViewHolder extends RecyclerView.ViewHolder {

    @Bind (R.id.stateName) TextView stateNameTextView;
    @Bind (R.id.fact1) TextView fact1TextView;
    @Bind (R.id.fact2) TextView fact2TextView;
    @Bind (R.id.fact3) TextView fact3TextView;
    @Bind (R.id.fact4) TextView fact4TextView;
    public StateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
