package br.com.leonardomiyagi.baseapplication.data.repository;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.data.api.ApiClient;
import br.com.leonardomiyagi.baseapplication.domain.repository.Repository;
import io.reactivex.Single;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class DefaultRepository implements Repository {

    private final ApiClient apiClient;

    @Inject
    public DefaultRepository(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Single<String> getMessage() {
        return apiClient.getMessageFromAPI();
    }
}
