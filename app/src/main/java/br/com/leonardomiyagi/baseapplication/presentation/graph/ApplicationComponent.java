package br.com.leonardomiyagi.baseapplication.presentation.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.presentation.main.MainComponent;
import dagger.Component;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    MainComponent main();
}
