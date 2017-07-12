package br.com.leonardomiyagi.baseapplication.presentation.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.presentation.BaseApplication;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, BindingModule.class})
public interface AppComponent {
    BaseApplication inject(BaseApplication baseApplication);
}
