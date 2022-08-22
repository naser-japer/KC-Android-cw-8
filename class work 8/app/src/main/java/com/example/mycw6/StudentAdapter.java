package com.example.mycw6;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter {
    List<Student> Studentlist;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        Studentlist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        Student currentstudent = Studentlist.get(position);

        TextView studentname = view.findViewById(R.id.textView4);
        TextView studentage = view.findViewById(R.id.textView);
        TextView studentgrade = view.findViewById(R.id.textView2);
        ImageView studentimge = view.findViewById(R.id.imageView);

        studentname.setText(currentstudent.getStudentname());
        studentage.setText(String.valueOf(currentstudent.getStudentage()));
        studentgrade.setText(String.valueOf(currentstudent.getStudentgrade()));
        studentimge.setImageResource(currentstudent.getStudentimge());

        ImageView deltebutton = view.findViewById(R.id.delet);
         deltebutton.setOnClickListener(new View.OnClickListener() {

             Student removebutton = Studentlist.get(position);
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setMessage("Are you sure you want to delete that ?????")
                         .setTitle("confirmation").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                             Studentlist.remove(removebutton);
                             notifyDataSetChanged();
                             }
                         }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 dialogInterface.dismiss();
                             }
                         });
                 builder.show();
             }
         });




        return view;
    }
}
