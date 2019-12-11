package uz.com.uzgovmonsys.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UzGovApi {
//
//    @POST("auth/session/migrate")
//    Single<MigrateResponse> migrate(@Header("sessionToken") String sessionToken,
//                                    @Body MigrateRequest migrateRequest);

    @GET("v2/contents/genres")
    Single<String>  getGenre(@Query("_lang") String lang);

}
