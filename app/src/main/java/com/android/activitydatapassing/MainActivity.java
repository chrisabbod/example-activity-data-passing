package com.android.activitydatapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_STRING_KEY = "com.android.passdatabetweenactivities.mainactivity";
    private static final int REQUEST_CODE_STRING = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        Button mButton = findViewById(R.id.main_activity_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIntent();

            }
        });
    }

    private void newIntent(){
        EditText mEditText = findViewById(R.id.main_activity_edit_text);
        String message = mEditText.getText().toString();

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(EXTRA_STRING_KEY, message);
        startActivityForResult(intent, REQUEST_CODE_STRING);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE_STRING){
            if(resultCode == RESULT_OK){
                String returnedMessage = data.getStringExtra(EXTRA_STRING_KEY);
                TextView mTextView = findViewById(R.id.main_activity_text);
                mTextView.setText(returnedMessage);
            }
        }
    }
}
