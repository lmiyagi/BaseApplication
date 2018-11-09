package br.com.leonardomiyagi.baseapplication.data.api;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import retrofit2.Response;

/**
 * Created by lmiyagi on 09/11/18.
 */
public class ApiClient {

    private final ApiService apiService;

    public ApiClient(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<String> getMessageFromAPI() {
        return Single.just("This message comes from the API Client!").delay(3, TimeUnit.SECONDS);
    }

    private <T> SingleTransformer<Response<T>, Response<T>> verifyResponseError() {
        return upstream -> upstream.doOnSuccess(response -> {
            if (!response.isSuccessful()) {
                throw RequestException.httpError(response.raw().request().url().toString(), response);
            }
        });
    }

    private <T> SingleTransformer<Response<T>, Response<T>> verifyRequestError() {
        return upstream -> upstream.onErrorResumeNext(throwable -> {
            if (throwable instanceof IOException) {
                return Single.error(RequestException.networkError((IOException) throwable));
            } else if (throwable instanceof RequestException) {
                return Single.error(throwable);
            } else if (throwable instanceof JsonSyntaxException) {
                return Single.error(throwable);
            } else {
                return Single.error(RequestException.unexpectedError(throwable));
            }
        });
    }

    private <T> SingleTransformer<Response<T>, T> unwrap() {
        return upstream -> upstream.map(Response::body);
    }
}
