package mvpdemo.rajnit.com.mvpblogdemo.view.activities.views;

import java.util.List;

import mvpdemo.rajnit.com.mvpblogdemo.data.models.Note;

/**
 * Created by MVPBlogDemo on 05/06/18.
 */

public interface MainActivityView {

    void showLoginActivity();

    void showError(String msg);

    void setAdapter(List<Note> notes);

    void clearEdittext();

}
