package br.com.leonardomiyagi.baseapplication.presentation.core.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.data.repository.DefaultRepository;
import br.com.leonardomiyagi.baseapplication.domain.repository.Repository;
import dagger.Binds;
import dagger.Module;

/**
 * Created by SES\leonardom on 11/07/17.
 */
@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Repository provideRepository(DefaultRepository repository);
}