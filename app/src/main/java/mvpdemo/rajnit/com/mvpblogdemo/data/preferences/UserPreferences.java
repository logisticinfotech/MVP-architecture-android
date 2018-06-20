package mvpdemo.rajnit.com.mvpblogdemo.data.preferences;

import android.support.annotation.Keep;

import java.util.List;

import mvpdemo.rajnit.com.mvpblogdemo.data.models.Note;

@Keep
public interface UserPreferences {

    String IS_USER_LOGIN = "isUserLogin";
    String NOTES_LIST = "notes_list";

    public void setUserLogin(boolean status);

    public boolean isUserLogin();

    public void addNote(Note note);

    public List<Note> getNotes();

    public void clearUser();

    void removeNote(Note note);

}
