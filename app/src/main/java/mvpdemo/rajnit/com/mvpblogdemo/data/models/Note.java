package mvpdemo.rajnit.com.mvpblogdemo.data.models;

/**
 * Created by MVPDemoGithub on 12/06/18.
 */

public class Note {

    private long id;
    private String note;
    private String date;

    public Note(long id, String note, String date) {
        this.id = id;
        this.note = note;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
