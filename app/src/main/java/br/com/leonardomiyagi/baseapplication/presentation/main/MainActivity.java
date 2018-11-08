package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.databinding.ActivityMainBinding;
import br.com.leonardomiyagi.baseapplication.presentation.core.base.BaseActivity;
import br.com.leonardomiyagi.baseapplication.presentation.core.databinding.PlaceholderData;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(presenter);
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public void renderMessage(String message) {
        binding.textView.setText(message);
    }

    @Override
    public void showError(Throwable throwable, Runnable tryAgainAction) {
        showErrorDialog(throwable, tryAgainAction);
    }

    @Override
    public void showLoading() {
        binding.placeholders.setData(PlaceholderData.loadingData(this));
    }

    @Override
    public void hideLoading() {
        binding.placeholders.setData(PlaceholderData.hideAll());
    }
}
