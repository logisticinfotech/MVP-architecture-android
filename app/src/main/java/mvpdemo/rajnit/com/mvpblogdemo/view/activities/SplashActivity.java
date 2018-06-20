package mvpdemo.rajnit.com.mvpblogdemo.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import mvpdemo.rajnit.com.mvpblogdemo.R;
import mvpdemo.rajnit.com.mvpblogdemo.presenter.Presenter;
import mvpdemo.rajnit.com.mvpblogdemo.presenter.SplashPresenter;
import mvpdemo.rajnit.com.mvpblogdemo.view.activities.views.SplashActivityView;

public class SplashActivity extends AbstractActivity implements SplashActivityView {

    SplashPresenter mPresenter = new SplashPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter.onCreate(getIntent());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.checkUserIsLogin();
            }
        },2000);
    }

    @Override
    Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showLoginActivity() {
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

    @Override
    public void showMainActivity() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

}
