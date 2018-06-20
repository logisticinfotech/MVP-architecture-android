package mvpdemo.rajnit.com.mvpblogdemo.presenter;

import android.content.Intent;

import mvpdemo.rajnit.com.mvpblogdemo.data.preferences.UserPreferences;
import mvpdemo.rajnit.com.mvpblogdemo.data.preferences.UserPreferencesImpl;
import mvpdemo.rajnit.com.mvpblogdemo.view.activities.views.SplashActivityView;

/**
 * Created by MVPBlogDemo on 05/06/18.
 */

public class SplashPresenter extends AbstractPresenter {

    private SplashActivityView mView;
    UserPreferences mDatabase = new UserPreferencesImpl();

    public SplashPresenter(SplashActivityView mView) {
        this.mView = mView;
    }


    public void onCreate(Intent intent) {
        // Handle intent data here...
    }

    public void checkUserIsLogin() {
        if(mDatabase.isUserLogin()){
            mView.showMainActivity();
        }   else {
            mView.showLoginActivity();
        }
    }

}
