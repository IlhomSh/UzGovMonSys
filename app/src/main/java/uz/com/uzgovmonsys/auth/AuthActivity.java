package uz.com.uzgovmonsys.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.R;

public class AuthActivity extends MvpAppCompatActivity implements AuthCallback,AuthActivityListener {

    @BindView(R.id.container)
    FrameLayout container;

    @InjectPresenter
    AuthPresenter presenter;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        presenter.create();
        openPhoneNumberFragment();
    }


    public void openPhoneNumberFragment() {
        fragmentManager.beginTransaction().replace(R.id.container, new PhoneNumberFragment()).addToBackStack(PhoneNumberFragment.TAG)
                .commit();
    }

    @Override
    public void openConfirmSmsFragment(String phoneNumber) {
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out).replace(R.id.container, ConfirmSmsFragment.newInstance(phoneNumber)).addToBackStack(ConfirmSmsFragment.TAG)
                .commit();
    }

    @Override
    public void openPasswordFragment() {
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out).replace(R.id.container, new PasswordFragment()).addToBackStack(PasswordFragment.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();

        } else if (count == 1) {
            finish();
        } else if (count == 3) {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().popBackStack();
        } else{
            Log.d("back", "onBackPressed");
        getSupportFragmentManager().popBackStack();
    }

}
}
