package com.example.mycw6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        Student viewstudent = (Student) bundle.getSerializable("student");

        TextView name = findViewById(R.id.studentname);
        TextView age = findViewById(R.id.textView10);
        ImageView imge = findViewById(R.id.imageView3);

        name.setText(viewstudent.getStudentname());
        age.setText(String.valueOf(viewstudent.getStudentage()));
        imge.setImageResource(viewstudent.getStudentimge());
    }
}