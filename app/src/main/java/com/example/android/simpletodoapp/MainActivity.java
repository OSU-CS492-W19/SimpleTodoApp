package com.example.android.simpletodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private TextView mTodoListTV;
    private EditText mTodoEntryET;

    private ArrayDeque<String> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoList = new ArrayDeque<String>();

        mTodoListTV = findViewById(R.id.tv_todo_list);
        mTodoEntryET = findViewById(R.id.et_todo_entry);

        Button addTodoButton = findViewById(R.id.btn_add_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoText = mTodoEntryET.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoList.push(todoText);
                    mTodoListTV.setText("");
                    for (String todo : mTodoList) {
                        mTodoListTV.append(todo + "\n\n");
                    }
                    mTodoEntryET.setText("");
                }
            }
        });
    }
}
