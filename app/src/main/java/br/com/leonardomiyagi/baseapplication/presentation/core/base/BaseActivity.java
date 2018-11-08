package br.com.leonardomiyagi.baseapplication.presentation.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.presentation.utils.DialogUtils;
import dagger.android.AndroidInjection;

/**
 * Created by SES\leonardom on 11/07/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    public void showErrorDialog(Throwable throwable) {
        showErrorDialog(throwable, null);
    }

    public void showErrorDialog(Throwable throwable, Runnable tryAgainAction) {
        String message;
        if (throwable.getMessage() == null) {
            message = getString(R.string.error_unexpected);
        } else {
            message = throwable.getMessage();
        }
        DialogUtils.showFailureDialog(this,
                message,
                getString(R.string.global_ok),
                (dialogInterface, i) -> {
                    if (tryAgainAction != null) {
                        tryAgainAction.run();
                    }
                });
    }
}
