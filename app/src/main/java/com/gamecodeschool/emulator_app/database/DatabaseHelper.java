package com.gamecodeschool.emulator_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_db";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE notes(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT, noteText TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public long insertNote(Note note) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("notetext", note.getNotetext());
        long insert = sqLiteDatabase.insert("notes", null, contentValues);
        sqLiteDatabase.close();
        return insert;


    }
    public List<Note> getNotes(){
        List<Note> notesList = new ArrayList<Note>();
        String query = "SELECT * FROM notes";
        SQLiteDatabase SQLiteDatabase = this.getReadableDatabase();
        Cursor cursor= SQLiteDatabase.rawQuery(query,null);
        if (cursor.moveToFirst());{
            do{
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex("id")));
                note.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                note.setNotetext(cursor.getString(cursor.getColumnIndex("notetext")));
                notesList.add(note);

            }
            while (cursor.moveToNext());
            SQLiteDatabase.close();
        }
        return notesList;
    }
    public Note getNoteByid(int id){
     Note note=new Note();
SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
String query="SELECT*FROM notes WHERE id=?";
Cursor cursor = sqLiteDatabase.rawQuery(query,new String[](String.valueOf(id)));
if (cursor.moveToFirst()){
note.setId(cursor.getInt(cursor.getColumnIndex("id")));
note.setTitle(cursor.getString(cursor.getColumnIndex("title")));
note.setNotetext(cursor.getString(cursor.getColumnIndex("noteText")));

}
sqLiteDatabase.close();
return note;
}
    public void deleteNote(int id){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String tableName="notes";
        String whereClause="id=?";
        String[]whereArgs=new String[]{String.valueOf(id)};
        sqLiteDatabase.delete(tableName,whereClause,whereArgs);


    }
    public int updateNote(Note note){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("title",note.getTitle());
        contentValues.put("noteText",note.getNoteText());
        String tableName="notes";
        String whereClause="id=?";

        return sqLiteDatabase.update(tableName, contentValues, whereClause,
                new String[]{String.valueOf(note.getId())});

    }

    public Note getNoteById(int noteId) {
    }
}