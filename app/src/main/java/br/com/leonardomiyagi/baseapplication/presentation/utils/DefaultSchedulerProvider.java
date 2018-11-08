package br.com.leonardomiyagi.baseapplication.presentation.utils;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.repository.SchedulerProvider;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class DefaultSchedulerProvider implements SchedulerProvider {

    @Inject
    public DefaultSchedulerProvider() {
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler main() {
        return AndroidSchedulers.mainThread();
    }
}
