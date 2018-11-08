package br.com.leonardomiyagi.baseapplication.presentation.core.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.presentation.BaseApplication;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        BindingModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {
}
