package br.com.leonardomiyagi.baseapplication.presentation.core.graph;

import javax.inject.Named;
import javax.inject.Singleton;

import br.com.leonardomiyagi.baseapplication.BuildConfig;
import br.com.leonardomiyagi.baseapplication.data.api.ApiClient;
import br.com.leonardomiyagi.baseapplication.data.api.ApiService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static br.com.leonardomiyagi.baseapplication.presentation.core.AppConstants.API_BASE_STAGING_URL;
import static br.com.leonardomiyagi.baseapplication.presentation.core.AppConstants.API_BASE_URL;
import static br.com.leonardomiyagi.baseapplication.presentation.core.AppConstants.DEBUG;
import static br.com.leonardomiyagi.baseapplication.presentation.core.AppConstants.D_API_BASE_URL;
import static br.com.leonardomiyagi.baseapplication.presentation.core.AppConstants.STAGING;

/**
 * Created by lmiyagi on 09/11/18.
 */
@Module
public abstract class ApiModule {

    @Provides
    @Singleton
    @Named(D_API_BASE_URL)
    static String provideBaseUrl() {
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase(DEBUG) ||
                BuildConfig.BUILD_TYPE.equalsIgnoreCase(STAGING)) {
            return API_BASE_STAGING_URL;
        } else {
            return API_BASE_URL;
        }
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(@Named(D_API_BASE_URL) String baseUrl,
                                    OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    static ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    static ApiClient provideApiClient(ApiService apiService) {
        return new ApiClient(apiService);
    }
}
