package uz.com.uzgovmonsys.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.utils.ValidationUtils;

import static uz.com.uzgovmonsys.constants.Constants.COUNTRY_CODE;
import static uz.com.uzgovmonsys.constants.Constants.PHONE_NUMBER_REGEX_FULL;
import static uz.com.uzgovmonsys.utils.UtilsClass.hideKeyboard;
import static uz.com.uzgovmonsys.utils.UtilsClass.showKeyboard;

public class PhoneNumberFragment extends BaseFragment {

    public static final String TAG = PhoneNumberFragment.class.getName();

    @BindView(R.id.enter_phone)
    TextInputEditText enter_phone;
    @BindView(R.id.phone_text_input)
    TextInputLayout phoneNumberTextInput;
    @BindView(R.id.back)
    ImageView backIcon;


    Unbinder unbinder;
    private ValidationUtils phoneNumberValidate;
    private String phoneNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.phone_number_fragment, container, false);
        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        backIcon.setOnClickListener(v -> {
            hideKeyboard(enter_phone);
            getActivity().onBackPressed();
        });
        phoneNumberValidate = new ValidationUtils(phoneNumberTextInput, enter_phone);
        enter_phone.setText(COUNTRY_CODE);
        enter_phone.setSelection(COUNTRY_CODE.length());
        showKeyboard(context, enter_phone);

    }


    @OnClick(R.id.btn)
    public void onClick() {
        phoneNumber = enter_phone.getText().toString().trim();

        if (!phoneNumber.matches(PHONE_NUMBER_REGEX_FULL)) {
            phoneNumberValidate.setErrorMsg("Noto'g'ri format");
            return;
        }

        authActivitylistener.openConfirmSmsFragment(phoneNumber);
        hideKeyboard(enter_phone);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
