package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {

        EditText etTitle, etDescripton;
        Button bntAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle = findViewById(R.id.et_tittle);
        etDescripton = findViewById(R.id.et_description);
        bntAddTask = findViewById(R.id.btn_add_task);

        bntAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String title = etTitle.getText().toString().trim();
                  String description = etDescripton.getText().toString().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
                String date = sdf.format(new Date());
                  if (!title.isEmpty() && !description.isEmpty()){
                      Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                       intent.putExtra("tittle", title);
                       intent.putExtra("description", description);
                       intent.putExtra("date", date);
                       setResult(RESULT_OK, intent);
                       finish();
                  }
            }
        });


    }
}