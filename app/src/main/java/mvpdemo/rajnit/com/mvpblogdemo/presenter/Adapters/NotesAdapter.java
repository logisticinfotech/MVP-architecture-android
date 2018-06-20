package mvpdemo.rajnit.com.mvpblogdemo.presenter.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import mvpdemo.rajnit.com.mvpblogdemo.R;
import mvpdemo.rajnit.com.mvpblogdemo.data.models.Note;

/**
 * Created by MVPDemoGithub on 15/06/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteHolder> {

    private List<Note> noteList;
    private NoteDeleteListener noteDeleteListener;

    public NotesAdapter(List<Note> noteList, NoteDeleteListener noteDeleteListener) {
        this.noteList = noteList;
        this.noteDeleteListener = noteDeleteListener;
    }

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notes, parent, false));
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {
        Note item = noteList.get(position);

        holder.tvNote.setText(item.getNote());
        holder.tvDate.setText(item.getDate());

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.viewIndicator.setBackgroundColor(color);

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void updateAdapter(List<Note> notesList) {
        noteList.clear();
        noteList.addAll(notesList);
        notifyDataSetChanged();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {

        View viewIndicator;
        TextView tvNote, tvDate;
        ImageView imgDelete;

        public NoteHolder(View itemView) {
            super(itemView);
            setIsRecyclable(false);
            viewIndicator = itemView.findViewById(R.id.viewIndicator);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvDate = itemView.findViewById(R.id.tvDate);
            imgDelete = itemView.findViewById(R.id.imgDelete);

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noteDeleteListener.onNoteDeleteClicked(noteList.get(getAdapterPosition()));
                    noteList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }

    }

    public interface NoteDeleteListener{
        void onNoteDeleteClicked(Note note);
    }

}
