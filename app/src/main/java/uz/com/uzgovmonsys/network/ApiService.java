package uz.com.uzgovmonsys.network;

import io.reactivex.Single;

public interface ApiService {
    //serverFuncktions

    // Single<HomeResponse> homeUzonline(String authToken, String langCode, long date);

    public Single<String> getGenres(String lang);
}
