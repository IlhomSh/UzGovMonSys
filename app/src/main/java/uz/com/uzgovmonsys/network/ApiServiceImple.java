package uz.com.uzgovmonsys.network;

import android.content.Context;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiServiceImple implements ApiService {
    private final Context context;
    private final UzGovApi uzGovApi;

    public ApiServiceImple(Context context, UzGovApi uzGovApi) {
        this.context = context;
        this.uzGovApi = uzGovApi;
    }

    @Override
    public Single<String> getGenres(String lang) {
        return uzGovApi.getGenre("ru").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }


//    @Override
//    public Single<GetSessionTokenResponse> getSessionToken(String clientVersion, String deviceModel, String platformVersion) {
//        return myUztelecomAPI.getSessionToken(clientVersion, deviceModel, platformVersion)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

}
