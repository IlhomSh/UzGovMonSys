package uz.com.uzgovmonsys.auth;

public interface AuthActivityListener {

    void openConfirmSmsFragment(String phoneNumber);

    void openPasswordFragment();
}
