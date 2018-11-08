package br.com.leonardomiyagi.baseapplication.presentation.utils;

import android.content.Context;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.data.api.RequestException;
import br.com.leonardomiyagi.baseapplication.presentation.core.databinding.PlaceholderData;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class ErrorHandler {

    private final Context context;

    @Inject
    public ErrorHandler(Context context) {
        this.context = context;
    }

    public PlaceholderData handleError(Throwable throwable) {
        throwable.printStackTrace();
        return handleError(throwable, null);
    }

    public PlaceholderData handleError(Throwable throwable, Runnable tryAgainAction) {
        throwable.printStackTrace();
        if (throwable instanceof RequestException) {
            return handleRequestException((RequestException) throwable, tryAgainAction);
        } else {
            return unexpectedErrorPlaceholderData();
        }
    }

    public PlaceholderData hideAll() {
        return new PlaceholderData(false, false, null, null, false, null, null);
    }

    public PlaceholderData handleRequestException(RequestException exception, Runnable tryAgainAction) {
        if (exception.isNetworkError()) {
            if (exception.isTimeOutException()) {
                return timeoutError(tryAgainAction);
            } else {
                return new PlaceholderData(true, false, R.drawable.ic_signal_wifi_off, context.getString(R.string.error_network), true, context.getString(R.string.global_try_again), tryAgainAction);
            }
        } else if (exception.isHttpError()) {
            switch (exception.getHtppError()) {
                case INTERNAL_SERVER_ERROR:
                    return new PlaceholderData(true, false, R.drawable.ic_sad, context.getString(R.string.error_server_internal), true, context.getString(R.string.global_try_again), tryAgainAction);
                case TIMEOUT:
                    return timeoutError(tryAgainAction);
                default:
                    return new PlaceholderData(true, false, null, exception.getErrorMessage(), true, context.getString(R.string.global_try_again), tryAgainAction);
            }
        } else {
            return unexpectedErrorPlaceholderData();
        }
    }

    public PlaceholderData unexpectedErrorPlaceholderData() {
        return new PlaceholderData(true, false, R.drawable.ic_sad, context.getString(R.string.error_unexpected), false, null, null);
    }

    private PlaceholderData timeoutError(Runnable tryAgainAction) {
        return new PlaceholderData(true, false, R.drawable.ic_clock, context.getString(R.string.error_timeout), true, context.getString(R.string.global_try_again), tryAgainAction);
    }
}