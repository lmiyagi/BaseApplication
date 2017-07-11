package br.com.leonardomiyagi.baseapplication.presentation.main;

import android.os.Bundle;

import br.com.leonardomiyagi.baseapplication.R;
import br.com.leonardomiyagi.baseapplication.presentation.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
