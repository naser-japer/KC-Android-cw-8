package com.example.mycw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> studentArrayList = new ArrayList<>();
int current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Student student1 = new Student("naser",16,95,R.drawable.unnamed);
        Student student2 = new Student("bader",14,94,R.drawable.badr);
        Student student3 = new Student("yosf",15,93,R.drawable.yosfe);
        Student student4 = new Student("mhmaed",17,89,R.drawable.mhamed);
        Student student5 = new Student("salman",18,85,R.drawable.salman);
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);



            StudentAdapter studentsAdapter= new StudentAdapter(this,0,studentArrayList);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(studentsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student cuurentstudent = studentArrayList.get(i);
                Intent intent = new Intent(MainActivity.this,detailsActivity.class);
                intent.putExtra("student",cuurentstudent);
                startActivity(intent);


            }
        });





           }
       }



