package br.com.leonardomiyagi.baseapplication.data.repository;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.repository.Repository;
import io.reactivex.Single;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class DefaultRepository implements Repository {

    @Inject
    public DefaultRepository() {
    }

    @Override
    public Single<String> getMessage() {
        return Single.just("This message comes from the repository!").delay(3, TimeUnit.SECONDS);
    }
}
