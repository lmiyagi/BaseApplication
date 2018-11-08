package br.com.leonardomiyagi.baseapplication.domain.message;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.repository.Repository;
import io.reactivex.Single;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class GetMainMessage {

    private final Repository repository;

    @Inject
    public GetMainMessage(Repository repository) {
        this.repository = repository;
    }

    public Single<String> execute() {
        return repository.getMessage();
    }
}
