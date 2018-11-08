package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.message.GetMainMessage;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by SES\leonardom on 11/07/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private CompositeDisposable disposables;

    private final GetMainMessage getMainMessage;

    @Inject
    MainPresenter(GetMainMessage getMainMessage) {
        this.getMainMessage = getMainMessage;
        disposables = new CompositeDisposable();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
        getMainMessage();
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @SuppressLint("CheckResult")
    private void getMainMessage() {
        getMainMessage.execute()
                .doOnSubscribe(disposable -> {
                    disposables.add(disposable);
                    view.showLoading();
                })
                .doFinally(() -> view.hideLoading())
                .subscribe(message -> view.renderMessage(message),
                        throwable -> view.showError(throwable, this::getMainMessage));
    }
}
