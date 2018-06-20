package mvpdemo.rajnit.com.mvpblogdemo.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mvpdemo.rajnit.com.mvpblogdemo.R;
import mvpdemo.rajnit.com.mvpblogdemo.presenter.LoginPresenter;
import mvpdemo.rajnit.com.mvpblogdemo.presenter.Presenter;
import mvpdemo.rajnit.com.mvpblogdemo.view.activities.views.LoginActivityView;

public class LoginActivity extends AbstractActivity implements LoginActivityView {

    private EditText edtUserName, edtPassword;
    private Button btnLogin;

    private LoginPresenter mPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        initListeners();

        mPresenter.onCreate(getIntent());
    }

    private void initListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(edtUserName.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

    @Override
    Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showMainActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

    @Override
    public void showError(String errorMsg) {
        showToast(errorMsg);
    }

}
