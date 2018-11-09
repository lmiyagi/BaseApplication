package br.com.leonardomiyagi.baseapplication.data.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by lmiyagi on 13/07/17.
 */

public class RequestException extends Exception {

    private final String url;
    private final String errorMessage;
    private final Response response;
    private final ErrorType errorType;
    private final Throwable throwable;

    private RequestException(String url, String errorMessage, Response response, ErrorType errorType, Throwable throwable) {
        super(errorMessage);
        this.url = url;
        this.errorMessage = errorMessage;
        this.response = response;
        this.errorType = errorType;
        this.throwable = throwable;
    }

    public static RequestException httpError(String url, String message) {
        return new RequestException(url, message, null, ErrorType.HTTP, null);
    }

    public static RequestException httpError(String url, Response response) {
        String message = response.message() + " (" + response.code() + ")";

        try {
            ResponseBody responseBody = response.errorBody();
            if (responseBody != null) {
                JSONObject errorObject = new JSONObject(responseBody.string());

                String serverMessage = errorObject.optString("error");
                Integer code = errorObject.optInt("status_code");

                message = serverMessage + " (" + code + ")";
            }
        } catch (JSONException | NullPointerException | IOException ignored) {
        }

        return new RequestException(url, message, response, ErrorType.HTTP, null);
    }

    public static RequestException networkError(IOException e) {
        return new RequestException(null, e.getMessage(), null, ErrorType.NETWORK, e);
    }

    public static RequestException unexpectedError(Throwable t) {
        t.printStackTrace();
        return new RequestException(null, t.getMessage(), null, ErrorType.UNEXPECTED, t);
    }

    public boolean isHttpError() {
        return errorType == ErrorType.HTTP;
    }

    public boolean isNetworkError() {
        return errorType == ErrorType.NETWORK;
    }

    public boolean isUnexpectedError() {
        return errorType == ErrorType.UNEXPECTED;
    }

    public boolean isUnauthorizedError() {
        return isHttpError() && getHtppError() == HttpError.UNAUTHORIZED;
    }

    public String getUrl() {
        return url;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Response getResponse() {
        return response;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public boolean isTimeOutException() {
        return throwable instanceof SocketTimeoutException;
    }

    private enum ErrorType {HTTP, NETWORK, UNEXPECTED}

    public HttpError getHtppError() {
        switch (response.code()) {
            case 400:
                return HttpError.BAD_REQUEST;
            case 401:
                return HttpError.UNAUTHORIZED;
            case 403:
                return HttpError.FORBIDDEN;
            case 404:
                return HttpError.NOT_FOUND;
            case 408:
                return HttpError.TIMEOUT;
            case 422:
                return HttpError.UNPROCESSABLE_ENTITY;
            case 500:
                return HttpError.INTERNAL_SERVER_ERROR;
            default:
                return HttpError.UNEXPECTED_ERROR;
        }
    }

    public enum HttpError {
        BAD_REQUEST,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        TIMEOUT,
        UNPROCESSABLE_ENTITY,
        INTERNAL_SERVER_ERROR,
        UNEXPECTED_ERROR
    }
}
