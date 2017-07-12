package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.presentation.base.BaseActivity;
import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
