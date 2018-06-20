package mvpdemo.rajnit.com.mvpblogdemo.presenter;

import android.content.Intent;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import mvpdemo.rajnit.com.mvpblogdemo.data.models.Note;
import mvpdemo.rajnit.com.mvpblogdemo.data.preferences.UserPreferences;
import mvpdemo.rajnit.com.mvpblogdemo.data.preferences.UserPreferencesImpl;
import mvpdemo.rajnit.com.mvpblogdemo.presenter.Adapters.NotesAdapter;
import mvpdemo.rajnit.com.mvpblogdemo.view.activities.views.MainActivityView;

/**
 * Created by MVPBlogDemo on 05/06/18.
 */

public class MainPresenter extends AbstractPresenter implements NotesAdapter.NoteDeleteListener {

    private MainActivityView mView;
    UserPreferences mDatabase = new UserPreferencesImpl();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy hh:mm a");

    public MainPresenter(MainActivityView mView) {
        this.mView = mView;
    }

    /**
     * parse your data which you sent with intent...
     */
    public void onCreate(Intent intent) {
        mView.setAdapter(mDatabase.getNotes());
    }

    public void addNote(String note) {
        if (TextUtils.isEmpty(note)) {
            mView.showError("Please add few words for note.");
        } else {
            mDatabase.addNote(new Note(System.currentTimeMillis(),note, simpleDateFormat.format(new Date())));
            mView.setAdapter(mDatabase.getNotes());
            mView.clearEdittext();
        }
    }

    @Override
    public void onNoteDeleteClicked(Note note) {
        mDatabase.removeNote(note);
//        mView.setAdapter(mDatabase.getNotes());
    }

    public void logoutApp() {
        mDatabase.clearUser();
        mView.showLoginActivity();
    }
}
