package com.example.fryjc.statestest.ui.stateparks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.fryjc.statestest.R;
import com.example.fryjc.statestest.models.StatePark;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateParksViewHolder extends RecyclerView.ViewHolder {

    @Bind (R.id.parkname) TextView stateParkNameTextView;

    public StateParksViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
