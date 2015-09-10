package com.example.fryjc.statestest.dagger.components;

import com.example.fryjc.statestest.dagger.modules.StateParkVMModule;
import com.example.fryjc.statestest.dagger.modules.StateVMModule;
import com.example.fryjc.statestest.ui.stateparks.StateParksActivity;
import com.example.fryjc.statestest.ui.states.StateActivity;

import dagger.Component;

/**
 * Created by fryjc on 9/10/2015.
 */
@Component(dependencies = NetworkComponent.class, modules = {StateParkVMModule.class, StateVMModule.class})
public interface ActivityInjectorComponent {

    void inject(StateActivity stateActivity);

    void inject(StateParksActivity stateParksActivity);
}
