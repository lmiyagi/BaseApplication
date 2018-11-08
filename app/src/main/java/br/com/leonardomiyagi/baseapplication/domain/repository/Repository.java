package br.com.leonardomiyagi.baseapplication.domain.repository;

import io.reactivex.Single;

/**
 * Created by lmiyagi on 08/11/18.
 */
public interface Repository {

    Single<String> getMessage();
}
