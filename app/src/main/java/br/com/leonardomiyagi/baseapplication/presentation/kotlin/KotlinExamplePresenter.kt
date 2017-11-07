package br.com.leonardomiyagi.baseapplication.presentation.kotlin

import javax.inject.Inject

/**
 * Created by SES\leonardom on 07/11/17.
 */
class KotlinExamplePresenter @Inject constructor() : KotlinExampleContract.Presenter {

    private var view: KotlinExampleContract.View? = null

    override fun attachView(view: KotlinExampleContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}