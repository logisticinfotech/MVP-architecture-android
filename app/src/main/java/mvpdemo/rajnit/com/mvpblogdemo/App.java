package mvpdemo.rajnit.com.mvpblogdemo;

import android.app.Application;

import mvpdemo.rajnit.com.mvpblogdemo.data.preferences.PreferencesProvider;

/**
 * Created by MVPBlogDemo on 09/06/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PreferencesProvider.init(this);
    }
}
