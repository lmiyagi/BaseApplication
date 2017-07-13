package br.com.leonardomiyagi.baseapplication.presentation.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.presentation.BaseApplication;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        BindingModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {
}
