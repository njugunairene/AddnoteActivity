package com.gamecodeschool.emulator_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gamecodeschool.emulator_app.database.Note;

import java.util.List;

public class Notes_Adapter extends ArrayAdapter<Note> {
    public Notes_Adapter(Context context, int resource, List<Note> notes) {
        super(context, resource, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = note.getitem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext().in)
        }
        TextView tvTitle = convertView.findViewById(tvTitle);
        TextView tvNoteText= convertView.findViewById(tvNoteText);
        tvTitle.setText(note.Title());
        tvNoteText.setText(getNoteText);
        return super.getView(position, convertView, parent);
    }
}
