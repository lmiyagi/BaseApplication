package br.com.leonardomiyagi.baseapplication.domain.repository;

import io.reactivex.Scheduler;

/**
 * Created by lmiyagi on 08/11/18.
 */
public interface SchedulerProvider {
    Scheduler io();

    Scheduler main();
}
