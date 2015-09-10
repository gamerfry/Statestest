package com.example.fryjc.statestest.dagger.modules;

import com.example.fryjc.statestest.network.StateParkAPI;
import com.example.fryjc.statestest.ui.stateparks.StateParksViewModel;
import com.example.fryjc.statestest.ui.states.StateViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fryjc on 9/10/2015.
 */
@Module
public class StateVMModule {

    @Provides
    StateViewModel providesStateViewModel(StateParkAPI api){
        return new StateViewModel(api);
    }
}
