package com.example.lesson4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private  TaskAdapter adapter;
    FloatingActionButton bntOpenAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTask = findViewById(R.id.rv_task);
        bntOpenAddTask = findViewById(R.id.bnt_open_add_task);
          bntOpenAddTask.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                    startActivityForResult(intent, 100);
              }
          });
//         List <String> list = new ArrayList<>();
//         list.add("Mean 1");
//         list.add("Mean 2");
//         list.add("Mean 3");
//         list.add("Mean 4");
//         list.add("Mean 5");

         rvTask.setLayoutManager(new LinearLayoutManager(this));
         adapter = new TaskAdapter( this);
         rvTask.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == 100 && resultCode == RESULT_OK){
             if (data != null){

                 TaskModel model = new TaskModel(data.getStringExtra("tittle"),data.getStringExtra("description"),data.getStringExtra("date"));
                 adapter.addTask(model);
                 Toast.makeText(MainActivity.this, data.getStringExtra("title"),Toast.LENGTH_SHORT).show();
             }


         }
    }

}