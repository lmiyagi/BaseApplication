package br.com.leonardomiyagi.baseapplication.presentation.kotlin

/**
 * Created by SES\leonardom on 07/11/17.
 */
interface KotlinExampleContract {

    interface View {

    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
    }
}