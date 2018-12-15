package com.example.tech2k8.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NotesList extends AppCompatActivity {

    private RecyclerView notesListTitle;
    private SaveNotesDatas datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        notesListTitle=findViewById(R.id.notes_list);
        datas=new SaveNotesDatas(NotesList.this);
        ArrayList<String> dbContent=datas.getAllDataFromDB();

        RecyclerView.LayoutManager manager =new LinearLayoutManager(NotesList.this);
        notesListTitle.setLayoutManager(manager);

        NotesListAdapter adapter =new NotesListAdapter(NotesList.this,dbContent);
        notesListTitle.setAdapter(adapter);
    }
}
