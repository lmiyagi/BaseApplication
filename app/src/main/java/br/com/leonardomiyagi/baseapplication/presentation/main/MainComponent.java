package br.com.leonardomiyagi.baseapplication.presentation.main;

import br.com.leonardomiyagi.baseapplication.presentation.graph.ActivityScoped;
import br.com.leonardomiyagi.baseapplication.presentation.graph.SubcomponentBuilder;
import dagger.Binds;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@ActivityScoped
@Subcomponent(modules = MainComponent.MainModule.class)
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<MainComponent> {
        @BindsInstance
        @ActivityScoped
        Builder message(String message);
    }

    @Module
    @ActivityScoped
    abstract class MainModule {
        @Binds
        @ActivityScoped
        abstract MainContract.Presenter providePresenter(MainContract.Presenter presenter);
    }
}
