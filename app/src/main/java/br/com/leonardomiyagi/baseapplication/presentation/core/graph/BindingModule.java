package br.com.leonardomiyagi.baseapplication.presentation.core.graph;

import br.com.leonardomiyagi.baseapplication.presentation.main.MainActivity;
import br.com.leonardomiyagi.baseapplication.presentation.main.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lmiyagi on 7/12/17.
 */
@Module
abstract class BindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivity();
}