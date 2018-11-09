package br.com.leonardomiyagi.baseapplication.presentation.core.base;

import javax.inject.Inject;

import br.com.leonardomiyagi.baseapplication.domain.repository.SchedulerProvider;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lmiyagi on 09/11/18.
 */
public abstract class BasePresenter<View extends BaseContract.View> {

    /**
     * The {@link View}
     * class that is attached on {@link BasePresenter#attachView(BaseContract.View)}
     *
     * @see BaseContract.View
     */
    public View view = null;

    /**
     * A disposable "bag" that gets disposed on {@link BasePresenter#detachView}
     *
     * @see Disposable
     */
    private CompositeDisposable disposables;

    /**
     * Schedulers to be used on the interactors
     *
     * @see Scheduler
     */
    @Inject
    protected SchedulerProvider schedulers;

    public BasePresenter() {
        disposables = new CompositeDisposable();
    }

    /**
     * Attaches the {@link View} and runs {@link BasePresenter#onViewAttached}
     *
     * @see BaseContract.View
     */
    public void attachView(View view) {
        this.view = view;
        onViewAttached();
    }

    /**
     * Runs {@link BasePresenter#onViewDetached()}, detaches the {@link View}, and disposes all
     * {@link Disposable}s collected from the {@link BasePresenter#runInteractor} methods
     *
     * @see BaseContract.View
     */
    public void detachView() {
        this.view = null;
        disposables.clear();
        onViewDetached();
    }

    /**
     * Runs just after the {@link View} is attached.
     *
     * @see BaseContract.View
     */
    protected void onViewAttached() {
    }

    /**
     * Runs just before the {@link View} is detached.
     *
     * @see BaseContract.View
     */
    protected void onViewDetached() {
    }

    /**
     * Runs an {@link Observable}, subscribing on {@link SchedulerProvider#io()} and observing on
     * {@link SchedulerProvider#main()} by default.
     * <p>
     * The {@link Disposable} will be added on the {@link BasePresenter}'s
     * {@link CompositeDisposable}, and will be disposed on {@link BasePresenter#onViewDetached}
     *
     * @param interactor an {@link Observable}<{@link T}> to be subscribed
     * @return The same {@link Observable} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Observable
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected <T> Observable<T> runInteractor(Observable<T> interactor) {
        return runInteractor(interactor, schedulers.io(), schedulers.main());
    }

    /**
     * Runs a {@link Single}, subscribing on {@link SchedulerProvider#io()} and observing on
     * {@link SchedulerProvider#main()} by default.
     * <p>
     * The {@link Disposable} will be added on the {@link BasePresenter}'s
     * {@link CompositeDisposable}, and will be disposed on {@link BasePresenter#onViewDetached}
     *
     * @param interactor an {@link Single}<{@link T}> to be subscribed
     * @return The same {@link Single} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Single
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected <T> Single<T> runInteractor(Single<T> interactor) {
        return runInteractor(interactor, schedulers.io(), schedulers.main());
    }

    /**
     * Runs a {@link Completable}, subscribing on {@link SchedulerProvider#io()} and observing on
     * {@link SchedulerProvider#main()} by default.
     * <p>
     * The {@link Disposable} will be added on the {@link BasePresenter}'s
     * {@link CompositeDisposable}, and will be disposed on {@link BasePresenter#onViewDetached}
     *
     * @param interactor an {@link Completable} to be subscribed
     * @return The same {@link Completable} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Completable
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected Completable runInteractor(Completable interactor) {
        return runInteractor(interactor, schedulers.io(), schedulers.main());
    }

    /**
     * Runs an {@link Observable}. The {@link Disposable} will be added on the {@link BasePresenter}'s
     * {@link CompositeDisposable}, and will be disposed on {@link BasePresenter#onViewDetached}
     *
     * @param interactor  an {@link Observable}<{@link T}> to be subscribed
     * @param subscribeOn the {@link Scheduler} to perform subscription actions on
     * @param observeOn   the {@link Scheduler} to notify Observers on
     * @return The same {@link Observable} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Observable
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected <T> Observable<T> runInteractor(Observable<T> interactor,
                                    Scheduler subscribeOn,
                                    Scheduler observeOn) {
        return interactor.doOnSubscribe(disposables::add)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    /**
     * Runs a {@link Single}. The {@link Disposable} will be added on the {@link BasePresenter}'s
     * {@link CompositeDisposable}, and will be disposed on {@link BasePresenter#onViewDetached}
     *
     * @param interactor  an {@link Single}<{@link T}> to be subscribed
     * @param subscribeOn the {@link Scheduler} to perform subscription actions on
     * @param observeOn   the {@link Scheduler} to notify Observers on
     * @return The same {@link Single} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Single
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected <T> Single<T> runInteractor(Single<T> interactor,
                                Scheduler subscribeOn,
                                Scheduler observeOn) {
        return interactor.doOnSubscribe(disposables::add)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    /**
     * Runs a {@link Completable}. The {@link Disposable} will be added on the
     * {@link BasePresenter}'s {@link CompositeDisposable}, and will be disposed on
     * {@link BasePresenter#onViewDetached}
     *
     * @param interactor  an {@link Completable} to be subscribed
     * @param subscribeOn the {@link Scheduler} to perform subscription actions on
     * @param observeOn   the {@link Scheduler} to notify Observers on
     * @return The same {@link Completable} from the params, but with {@link Scheduler}s and
     * {@link Disposable} handled
     * @see Completable
     * @see Scheduler
     * @see Disposable
     * @see CompositeDisposable
     * @see BasePresenter
     * @see SchedulerProvider
     */
    protected Completable runInteractor(Completable interactor,
                              Scheduler subscribeOn,
                              Scheduler observeOn) {
        return interactor.doOnSubscribe(disposables::add)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }
}
