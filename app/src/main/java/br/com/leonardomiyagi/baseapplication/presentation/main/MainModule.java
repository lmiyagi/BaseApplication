package br.com.leonardomiyagi.baseapplication.presentation.main;

import br.com.leonardomiyagi.baseapplication.presentation.core.graph.ActivityScoped;
import dagger.Binds;
import dagger.Module;

/**
 * Created by lmiyagi on 12/07/17.
 */
@Module
public abstract class MainModule {

    @Binds
    @ActivityScoped
    abstract MainContract.Presenter bindMainPresenter(MainPresenter presenter);
}