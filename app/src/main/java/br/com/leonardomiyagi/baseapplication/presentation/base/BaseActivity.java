package br.com.leonardomiyagi.baseapplication.presentation.base;

import android.support.v7.app.AppCompatActivity;

import br.com.leonardomiyagi.baseapplication.presentation.graph.ApplicationComponent;
import br.com.leonardomiyagi.baseapplication.presentation.graph.DaggerApplicationComponent;

/**
 * Created by SES\leonardom on 11/07/17.
 */

public class BaseActivity extends AppCompatActivity {

    public ApplicationComponent getAppComponent() {
        return DaggerApplicationComponent.create();
    }
}
