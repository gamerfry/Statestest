package com.example.fryjc.statestest.ui.stateparks;

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


public class StateParksActivity extends BaseViewModelActivity<StateParksViewModel> implements StateParksViewModel.Listener {

    @Bind(R.id.stateParksRecyclerView) RecyclerView stateParksRecyclerView;

    StateParksRecycleAdapter mStateParksAdapter;
    private Bundle extras;

    @Inject
    StateParksViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_activity_view);
        setTitle("State Parks");
        ButterKnife.bind(this);

        Intent i = getIntent();
        extras = i.getExtras();
        String stateIDData = extras.getString(getString(R.string.stateidkey));

        viewModel.initialize(this.getCacheDir(),stateIDData);
        mStateParksAdapter = new StateParksRecycleAdapter(this, viewModel.getStateParkList());
        stateParksRecyclerView.setAdapter(mStateParksAdapter);
        stateParksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        }


    @Override
    protected StateParksViewModel getViewModel() {
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
    public void onBackPressed(){
        Intent backIntent = new Intent("com.example.fryjc.statestest.ui.state.StateActivity");
        Bundle parkExtras = extras;
        backIntent.putExtras(parkExtras);
        startActivity(backIntent);
    }

    @Override
    public void onChange() {
        mStateParksAdapter.getData().clear();
        mStateParksAdapter.getData().addAll(viewModel.getStateParkList());
        mStateParksAdapter.notifyDataSetChanged();
    }
}
