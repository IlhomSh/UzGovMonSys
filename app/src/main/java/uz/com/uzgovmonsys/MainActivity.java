package uz.com.uzgovmonsys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
