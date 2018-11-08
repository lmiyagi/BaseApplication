package br.com.leonardomiyagi.baseapplication.presentation.main;

import br.com.leonardomiyagi.baseapplication.presentation.core.base.RequestView;

/**
 * Created by SES\leonardom on 11/07/17.
 */

public interface MainContract {

    interface View extends RequestView {
        void renderMessage(String message);
    }

    interface Presenter {
        void attachView(View view);

        void detachView();
    }
}
