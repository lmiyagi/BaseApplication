package br.com.leonardomiyagi.baseapplication.presentation.main;

import br.com.leonardomiyagi.baseapplication.presentation.core.base.BasePresenter;
import br.com.leonardomiyagi.baseapplication.presentation.core.base.RequestView;

/**
 * Created by lmiyagi on 11/07/17.
 */

public interface MainContract {

    interface View extends RequestView {
        void renderMessage(String message);
    }

    abstract class Presenter extends BasePresenter<View> {
    }
}
