package com.gamecodeschool.emulator_app;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gamecodeschool.emulator_app.database.DatabaseHelper;
import com.gamecodeschool.emulator_app.database.Note;

import java.io.NotActiveException;

public class AddNoteActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etNote;
    Button btnAddPhoto;
    Button btnAddVoiceNote;
    Button btnSave;
//    private Object v;
    String Title;
    String Notetext;
    private String title;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etTitle = findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        btnAddPhoto = findViewById(R.id.btnAddPhoto);
        btnAddVoiceNote = findViewById(R.id.btnAddVoiceNote);
        btnSave = findViewById(R.id.btnSave);
        
        
        btnSave.setOnClickListener(new View.OnClickListener();
        @Override
                public void onClick(View)
                {
                        title = etTitle.getText().toString();
                        String Notetext = etTitle.getText().toString();
                        Note note = new Note(title,Notetext);
                        DatabaseHelper databaseHelper=new DatabaseHelper(getBaseContext(),"notes",null,1);
                       long insert= databaseHelper.insertNote(note);
                       Log.d("insertnote","note insertion value"+ insert);
        Toast.makeText(getBaseContext(), "irene", Toast.LENGTH_LONG).show();





      
                
                

        
        


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


}
