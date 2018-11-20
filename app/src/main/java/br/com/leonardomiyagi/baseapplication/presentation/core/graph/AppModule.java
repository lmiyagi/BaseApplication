package br.com.leonardomiyagi.baseapplication.presentation.core.graph;

import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.data.repository.DefaultRepository;
import br.com.leonardomiyagi.baseapplication.domain.repository.Repository;
import br.com.leonardomiyagi.baseapplication.domain.repository.SchedulerProvider;
import br.com.leonardomiyagi.baseapplication.presentation.utils.DefaultSchedulerProvider;
import dagger.Binds;
import dagger.Module;

/**
 * Created by lmiyagi on 11/07/17.
 */
@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Repository provideRepository(DefaultRepository repository);

    @Binds
    @Singleton
    abstract SchedulerProvider provideSchedulerProvider(DefaultSchedulerProvider schedulerProvider);
}
