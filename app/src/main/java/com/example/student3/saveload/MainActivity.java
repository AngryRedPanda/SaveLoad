package com.example.student3.saveload;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;
    private Button saveBtn;
    private Button loadBtn;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);


        editText = (EditText) findViewById(R.id.text_text);
        editText1 = (EditText) findViewById(R.id.key_text);

        saveBtn = (Button) findViewById(R.id.save_btn);
        loadBtn = (Button) findViewById(R.id.load_btn);

        list = new ArrayList<>();


        saveBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                list.add(editText1.getText().toString());
                editor.putString(editText1.getText().toString(), editText.getText().toString());


                editor.commit();

            }

        });

        loadBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                for (String e : list
                        ) {
                    if (e.equals(editText1.getText().toString())) {
                        editText.setText(sharedPreferences.getString(e, ""));
                        break;
                    }


                }
            }

        });

    }
}
