package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private int mCount = 0;
    private TextView mShowCount;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);
        resetButton = (Button) findViewById(R.id.button_reset);
        Log.d(LOG_TAG, "Hello World!");

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count_state", 0);
        }
        displayMCount();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_state", mCount);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        displayMCount();
        if (resetButton != null) {
            resetButton.setBackgroundColor(Color.GREEN);
        }
    }

    public void resetCount(View view) {
        mCount = 0;
        view.setBackgroundColor(Color.GRAY);
        displayMCount();
    }

    public void displayMCount() {
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

}