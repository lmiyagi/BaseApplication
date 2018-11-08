package br.com.leonardomiyagi.baseapplication.presentation.core.databinding;

import android.content.Context;
import android.support.annotation.DrawableRes;

import br.com.leonardomiyagi.baseapplication.R;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class PlaceholderData {
    private boolean visible;
    private boolean loadingVisible;
    private String message;
    private boolean showTryAgain;
    private String tryAgainMessage;
    private Runnable tryAgainAction;
    private Integer icon;

    public PlaceholderData(boolean visible, boolean loadingVisible, @DrawableRes Integer icon, String message, boolean showTryAgain, String tryAgainMessage, Runnable tryAgainAction) {
        this.visible = visible;
        this.loadingVisible = loadingVisible;
        this.icon = icon;
        this.message = message;
        this.showTryAgain = showTryAgain;
        this.tryAgainMessage = tryAgainMessage;
        this.tryAgainAction = tryAgainAction;
    }

    public static PlaceholderData loadingData(Context context) {
        return loadingData(context, null);
    }

    public static PlaceholderData loadingData(Context context, String message) {
        return new PlaceholderData(true, true, null, message == null ? context.getString(R.string.global_loading) : message, false, null, null);
    }

    public static PlaceholderData emptyData(Context context) {
        return emptyData(context, R.drawable.ic_empty, null);
    }

    public static PlaceholderData emptyData(Context context, String message) {
        return emptyData(context, R.drawable.ic_empty, message);
    }

    public static PlaceholderData emptyData(Context context, @DrawableRes int icon, String message) {
        return new PlaceholderData(true, false, icon, message == null ? context.getString(R.string.global_empty_message) : message, false, null, null);
    }

    public static PlaceholderData warningData(Context context) {
        return warningData(context, null);
    }

    public static PlaceholderData warningData(Context context, String message) {
        return new PlaceholderData(true, false, R.drawable.ic_warning_gray, message == null ? context.getString(R.string.error_unexpected) : message, false, null, null);
    }

    public static PlaceholderData hideAll() {
        return new PlaceholderData(false, false, null, null, false, null, null);
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isLoadingVisible() {
        return loadingVisible;
    }

    public String getMessage() {
        return message;
    }

    public boolean showTryAgain() {
        return showTryAgain;
    }

    public String getTryAgainMessage() {
        return tryAgainMessage;
    }

    public void executeTryAgainAction() {
        if (tryAgainAction != null) {
            tryAgainAction.run();
        }
    }

    public Integer getIcon() {
        return icon;
    }
}
