package com.example.arturbaboskin.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private Button btnAdd;
    private List<Student> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = DBHelper.getInstance(getApplicationContext()).getStudents();

        list = findViewById(R.id.list);

        final ArrayAdapter<Student> adapter =
                new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        data);

        list.setAdapter(adapter);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student("NoName",
                        (int) (Math.random() * 85 + 15));

                DBHelper.getInstance(getApplicationContext())
                        .addStudent(student);

                data.add(student);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
