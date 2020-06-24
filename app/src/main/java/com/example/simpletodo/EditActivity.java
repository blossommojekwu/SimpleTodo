package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    //variables
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        //get handle on data we pass in
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        //when user is done editing, button is clicked
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //create an intent that will contain results
                Intent intent = new Intent();
                //pass the data(results of editing)
                String result = etItem.getText().toString();
                int pos = getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION);
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, result);
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, pos);
                //set the result of the intent
                setResult(RESULT_OK, intent);
                //finish activity
                finish();
            }
        });
    }
}