package com.example.fryjc.statestest.ui.states;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fryjc.statestest.R;
import com.example.fryjc.statestest.Util.RecyclerItemClickListener;
import com.example.fryjc.statestest.base.BaseApplication;
import com.example.fryjc.statestest.base.BaseViewModel;
import com.example.fryjc.statestest.base.BaseViewModelActivity;
import com.example.fryjc.statestest.dagger.components.DaggerActivityInjectorComponent;
import com.example.fryjc.statestest.dagger.components.DaggerNetworkComponent;
import com.example.fryjc.statestest.dagger.components.NetworkComponent;
import com.example.fryjc.statestest.dagger.modules.NetworkModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class StateActivity extends BaseViewModelActivity<StateViewModel> implements StateViewModel.Listener {

    @Bind(R.id.stateRecyclerView) RecyclerView stateRecyclerView;

    StateRecycleAdapter mStateAdapter;

    @Inject
    StateViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_activity_view);
        ButterKnife.bind(this);
        setTitle("States");


        if(getIntent().getExtras()==null) {
            viewModel.initialize(this.getCacheDir());
        }
        else{
            Intent i = getIntent();
            Bundle extras = i.getExtras();
            String stateData = extras.getString(getString(R.string.statelistkey));
            viewModel.storeStates(stateData);
        }

        mStateAdapter = new StateRecycleAdapter(viewModel.getStateList());
        stateRecyclerView.setAdapter(mStateAdapter);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        stateRecyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener(){
                @Override
                public void onItemClick(View view, int position) {
                    Intent parkIntent = new Intent("com.example.fryjc.statestest.ui.stateparks.StateParksActivity");
                    Bundle parkExtras = new Bundle();
                    parkExtras.putString(getString(R.string.stateidkey),
                            viewModel.getStateList().get(position).getmStateID());
                    parkExtras.putString(getString(R.string.statelistkey),viewModel.getSerializedStateList());
                    parkIntent.putExtras(parkExtras);
                    startActivity(parkIntent);
                }
            })
        );

    }

    @Override
    protected StateViewModel getViewModel() {
        if(viewModel == null){
            NetworkComponent networkComponent = DaggerNetworkComponent
                    .builder()
                    .networkModule(new NetworkModule())
                    .build();
            DaggerActivityInjectorComponent.builder()
                    .networkComponent(networkComponent)
                    .build()
                    .inject(this);
        }
        return viewModel;
    }

    @Override
    public void onChange() {
        mStateAdapter.getData().clear();
        mStateAdapter.getData().addAll(viewModel.getStateList());
        mStateAdapter.notifyDataSetChanged();
    }
}
