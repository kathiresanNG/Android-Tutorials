package com.example.tech2k8.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText titleContent,descContent;
    private Button saveContent;
    private  String titleData,descData;
    private SaveNotesDatas notesDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveContent=findViewById(R.id.save_data);
        titleContent=findViewById(R.id.title_edt);
        descContent=findViewById(R.id.desc_edt);
        notesDatas=new SaveNotesDatas(MainActivity.this);

        final Intent listActIntent =new Intent(MainActivity.this,NotesList.class);
        saveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleData=titleContent.getText().toString();
                descData=descContent.getText().toString();
                notesDatas.addNewDataToDB(titleData,descData);
                Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                titleContent.setText(null);
                descContent.setText(null);
                startActivity(listActIntent);
                //ArrayList sqlData =notesDatas.getAllDataFromDB();
               // Log.i("MainActivity","data "+sqlData.get(0));
            }
        });
    }
}
