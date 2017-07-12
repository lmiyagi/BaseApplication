package br.com.leonardomiyagi.baseapplication.presentation.main;

import br.com.leonardomiyagi.baseapplication.presentation.graph.ActivityScoped;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by SES\leonardom on 12/07/17.
 */
@ActivityScoped
@Subcomponent(modules = MainComponent.MainModule.class)
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }

    @Module
    abstract class MainModule {
        @Provides
        @ActivityScoped
        MainContract.Presenter providePresenter() {
            return new MainPresenter();
        }
    }
}
