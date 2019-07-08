package com.gamecodeschool.emulator_app.database;

public class Note<string> {
    private int id;
    private String title;
    private String notetext;

    public Note(int id, String title, String notetext) {
        this.id = id;
        this.title = title;
        this.notetext = notetext;
    }

    public Note(String title, String notetext) {
        this.title = title;
        this.notetext = notetext;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotetext() {
        return notetext;
    }

    public void setNotetext(String notetext) {
        this.notetext = notetext;
    }
}
