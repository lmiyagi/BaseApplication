package br.com.leonardomiyagi.baseapplication.presentation.kotlin

import br.com.leonardomiyagi.baseapplication.presentation.graph.ActivityScoped
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by SES\leonardom on 07/11/17.
 */
@ActivityScoped
@Subcomponent(modules = arrayOf(KotlinExampleComponent.KotlinExampleModule::class))
interface KotlinExampleComponent : AndroidInjector<KotlinExampleActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<KotlinExampleActivity>()

    @Module
    abstract class KotlinExampleModule {

        @Binds
        @ActivityScoped
        abstract fun bindPresenter(presenter: KotlinExamplePresenter): KotlinExampleContract.Presenter
    }
}