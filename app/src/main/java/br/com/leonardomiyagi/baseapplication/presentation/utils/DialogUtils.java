package br.com.leonardomiyagi.baseapplication.presentation.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import br.com.leonardomiyagi.baseapplication.R;

/**
 * Created by lmiyagi on 08/11/18.
 */
public class DialogUtils {

    public static void showYesOrNoDialog(Context context, String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        buildDialog(context, title, message, context.getString(R.string.global_yes), context.getString(R.string.global_no), positiveAction, negativeAction, null, true).show();
    }

    public static void showYesOrNoDialog(Context context, @StringRes int title, @StringRes int message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        buildDialog(context, context.getString(title), context.getString(message), context.getString(R.string.global_yes), context.getString(R.string.global_no), positiveAction, negativeAction, null, true).show();
    }

    public static void showUncancelableDialog(Context context, @StringRes int title, @StringRes int message, @StringRes int positiveMessage, DialogInterface.OnClickListener positiveAction) {
        buildDialog(context, context.getString(title), context.getString(message), context.getString(positiveMessage), null, positiveAction, null, null, false).show();
    }

    public static void showDialog(Context context, @StringRes int title, @StringRes int message, @StringRes int positiveMessage, DialogInterface.OnClickListener positiveAction) {
        buildDialog(context, context.getString(title), context.getString(message), context.getString(positiveMessage), null, positiveAction, null, null, true).show();
    }

    public static void showDialog(Context context, @StringRes int title, @StringRes int message, @StringRes int positiveMessage, DialogInterface.OnClickListener positiveAction, DialogInterface.OnCancelListener cancelListener) {
        buildDialog(context, context.getString(title), context.getString(message), context.getString(positiveMessage), null, positiveAction, null, cancelListener, true).show();
    }

    public static void showDialog(Context context, @StringRes int title, @StringRes int message, @StringRes int positiveMessage, @StringRes int negativeMessage, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        buildDialog(context, context.getString(title), context.getString(message), context.getString(positiveMessage), context.getString(negativeMessage), positiveAction, negativeAction, null, true).show();
    }

    public static void showFailureDialog(Context context, @StringRes int message, @StringRes int positiveMessage, DialogInterface.OnClickListener positiveAction) {
        buildDialog(context, context.getString(R.string.global_op_failure), context.getString(message), context.getString(positiveMessage), null, positiveAction, null, null, true).show();
    }

    public static void showFailureDialog(Context context, String message, String positiveMessage, DialogInterface.OnClickListener positiveAction) {
        buildDialog(context, context.getString(R.string.global_op_failure), message, positiveMessage, null, positiveAction, null, null, true).show();
    }

    public static void showFailureDialog(Context context, @StringRes int message, @StringRes int positiveMessage, @StringRes int negativeMessage, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        buildDialog(context, context.getString(R.string.global_op_failure), context.getString(message), context.getString(positiveMessage), context.getString(negativeMessage), positiveAction, negativeAction, null, true).show();
    }

    public static void showFailureDialog(Context context, @StringRes int message, @StringRes int positiveMessage, @StringRes int negativeMessage, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, DialogInterface.OnCancelListener cancelListener) {
        buildDialog(context, context.getString(R.string.global_op_failure), context.getString(message), context.getString(positiveMessage), context.getString(negativeMessage), positiveAction, negativeAction, cancelListener, true).show();
    }

    private static AlertDialog buildDialog(Context context, String title, String message, String positiveMessage, String negativeMessage, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, DialogInterface.OnCancelListener cancelListener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveMessage, positiveAction);
        builder.setNegativeButton(negativeMessage, negativeAction);
        builder.setCancelable(cancelable);
        AlertDialog alertDialog = builder.create();
        alertDialog.setOnCancelListener(cancelListener);
        return alertDialog;
    }
}
