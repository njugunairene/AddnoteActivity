package com.gamecodeschool.emulator_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gamecodeschool.emulator_app.adapters.Notes_Adapter;
import com.gamecodeschool.emulator_app.database.DatabaseHelper;
import com.gamecodeschool.emulator_app.database.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView Sauce;
    ListView listNames;
    List<Note> noteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AddNoteActivity.class));
                //startActivity(new Intent(getBaseContext(),TrialActivity.class));
            }
        });

        displayNote();
        listNames= findViewById(R.id.listNames);
        displayNames();
    }

//    private void displayNames() {
//    }


    private void displayNote(){
            DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(),"note",null,1);
            noteList = new ArrayList<Note>();
            noteList = databaseHelper.getNotes();
            Log.d("note","my notelist has "+ noteList.size()+"notes");
        Object resource;
        NotesAdapter notesAdapter =new NotesAdapter(getBaseContext(),resource 0,noteList);


        listNames.setAdapter(notesAdapter);
        listNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = noteList.get(position);
                Intent intent =new Intent(getBaseContext(),AddNoteActivity.class);
                intent.putExtra("NOTE_ID",note.getId());
                startActivity(intent);
            }
        });
        }
        private void displayNotes(){
        List<String> nameList = new ArrayList<>();
            nameList.add("irene njoki");
            nameList.add("irene nyambura");
            nameList.add("Rose wanjiku");
            nameList.add("Sharon Akoth");
            nameList.add("Cate Wanjiku");
            nameList.add("Naima Hassan");
            nameList.add("Bilha Wanjiku");
            nameList.add("Clare Wangare");
            nameList.add("Diana morrah");
            nameList.add("Beatrice Kasembi");



        }


    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);
    ListNames.setAdapter(arrayAdapter);



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
