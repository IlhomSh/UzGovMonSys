package uz.com.uzgovmonsys.di;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import uz.com.uzgovmonsys.App;
import uz.com.uzgovmonsys.auth.AuthPresenter;
import uz.com.uzgovmonsys.di.module.AppModule;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);
    void inject(AuthPresenter authPresenter);



    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder app(App app);

        AppComponent build();
    }
}
