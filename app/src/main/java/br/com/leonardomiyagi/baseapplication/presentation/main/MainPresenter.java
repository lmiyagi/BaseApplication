package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.message.GetMainMessage;

/**
 * Created by lmiyagi on 11/07/17.
 */

public class MainPresenter extends MainContract.Presenter {

    private final GetMainMessage getMainMessage;

    @Inject
    MainPresenter(GetMainMessage getMainMessage) {
        this.getMainMessage = getMainMessage;
    }

    @Override
    protected void onViewAttached() {
        getMainMessage();
    }

    @SuppressLint("CheckResult")
    private void getMainMessage() {
        runInteractor(getMainMessage.execute())
                .doOnSubscribe(disposable -> view.showLoading())
                .doFinally(() -> view.hideLoading())
                .subscribe(message -> view.renderMessage(message),
                        throwable -> view.showError(throwable, this::getMainMessage));
    }
}
