package uz.com.uzgovmonsys.auth;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.network.ApiService;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthCallback> {
    @Inject
    ApiService apiService;

    public AuthPresenter(){
        App.getAppConponent().inject(this);
    }

    @SuppressLint("CheckResult")
    public void create() {
        apiService.getGenres("ru").subscribe(s -> {
            System.out.println(s);
        },throwable -> {

        });
    }
}
