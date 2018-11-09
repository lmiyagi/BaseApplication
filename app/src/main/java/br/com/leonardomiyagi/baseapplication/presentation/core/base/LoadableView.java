package br.com.leonardomiyagi.baseapplication.presentation.core.base;

/**
 * Created by lmiyagi on 08/11/18.
 */
public interface LoadableView extends BaseContract.View {

    void showLoading();

    void hideLoading();
}
