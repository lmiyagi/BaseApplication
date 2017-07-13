package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.databinding.ActivityMainBinding;
import br.com.leonardomiyagi.baseapplication.presentation.base.BaseActivity;
import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(presenter);
    }
}
