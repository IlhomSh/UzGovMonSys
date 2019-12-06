package uz.com.uzgovmonsys.auth;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class ConfirmSmsFragment extends BaseFragment {

    private static final String PHONE = "PHONE_NUMBER";

    public static final String TAG = ConfirmSmsFragment.class.getName();
    private String phoneNumber;

    @BindView(R.id.sms_text_input)
    TextInputLayout smsTextInputLayout;
    @BindView(R.id.enter_sms)
    TextInputEditText enterSms;

    @BindView(R.id.smsText)
    TextView smstext;
    @BindView(R.id.back)
    ImageView backIcon;
    private ValidationUtils validationUtils;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.confirm_sms_fragment, container, false);
        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        unbinder = ButterKnife.bind(this, view);
        backIcon.setOnClickListener(v->{
            getActivity().onBackPressed();
        });
        validationUtils = new ValidationUtils(smsTextInputLayout, enterSms);
        smstext.setText(context.getResources().getString(R.string.sms_codeTxt, phoneNumber));
    }


    @OnClick(R.id.btn)
    public void onClick() {

        if (!enterSms.getText().toString().trim().equals("1111"))  {
            validationUtils.setErrorMsg("Tasdiqlash ko'di noto'g'ri");
            return;
        }
        authActivitylistener.openPasswordFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phoneNumber = getArguments().getString(PHONE);
    }

    public static ConfirmSmsFragment newInstance(String phoneNumber) {

        Bundle args = new Bundle();
        args.putString(PHONE, phoneNumber);
        ConfirmSmsFragment fragment = new ConfirmSmsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
