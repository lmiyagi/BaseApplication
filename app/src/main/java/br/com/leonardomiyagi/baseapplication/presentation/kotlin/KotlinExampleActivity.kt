package br.com.leonardomiyagi.baseapplication.presentation.kotlin

import android.os.Bundle
import br.com.leonardomiyagi.baseapplication.R
import br.com.leonardomiyagi.baseapplication.presentation.base.BaseActivity
import javax.inject.Inject

class KotlinExampleActivity : BaseActivity(), KotlinExampleContract.View {

    @Inject
    private lateinit var presenter: KotlinExampleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_example)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }
}
