package com.example.solution;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.solution.database.DatabaseHelper;
import com.example.solution.database.Note;

import javax.annotation.Nullable;

public class editNote extends AppCompatActivity {

    EditText etTitle;
    EditText etNote;
    Button btnUpdate;
    String noteText;
    String title;
    int noteId;
    ImageView imgView;

    private static final int CAPTURE_IMAGE_REQUEST_CODE=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_activitty);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        getNoteId();
        etTitle = findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        btnUpdate = findViewById(R.id.btnSave);

        imgView =findViewById(R.id.imgView);
        displayNote();





        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = etTitle.getText().toString();
                noteText = etNote.getText().toString();
                Note note = new Note(noteId, title,noteText);
                DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(),"notes",null,1);
                long rows = databaseHelper.updateNote(note);

            }
        });





    }

    public void getNoteId(){
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            noteId=bundle.getInt("NOTE_ID",0);
        }
    }
    public void displayNote(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(),"notes",null,1);
        Note note=databaseHelper.getNoteById(noteId);
        etTitle.setText(note.getTitle());
        etNote.setText(note.getNoteText());
    }
