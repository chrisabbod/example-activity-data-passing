package com.android.activitydatapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_STRING_KEY = "com.android.passdatabetweenactivities.mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        String messageData = getIntent().getStringExtra(EXTRA_STRING_KEY);

        TextView mTextView = findViewById(R.id.second_activity_text_view);
        mTextView.setText(messageData);

        Button mButton = findViewById(R.id.second_activity_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return data when button is pressed
                returnData();
            }
        });
    }

    private void returnData(){
        EditText mEditText = findViewById(R.id.second_activity_edit_text);
        String message = mEditText.getText().toString();

        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_STRING_KEY, message);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            //Override parent navigation up button to return data
            case android.R.id.home:
                returnData();
        }
        return true;
    }

    //Override hardware back button to return data
    @Override
    public void onBackPressed(){
        returnData();
    }
}
