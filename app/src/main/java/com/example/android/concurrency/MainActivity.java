package com.example.android.concurrency;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CodeRunner";

    // View object references
    private ScrollView mScroll;
    private TextView mLog;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the logging components
        mScroll = (ScrollView) findViewById(R.id.scrollLog);
        mLog = (TextView) findViewById(R.id.tvLog);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mLog.setText(R.string.lorem_ipsum);
    }

    //  Run some code, called from the onClick event in the layout file
    public void runCode(View v) {

        log("Running code");
        displayProgressBar(true);

        //TODO: Runnable interface. Here is an anonymous Runnable implementation
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                Log.i(TAG, "run: runnable complete");
//                displayProgressBar(false);
//                //TODO: blocking call running on the main thread, UI will be unresponsive as a result
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };

        //TODO: Handler class instance to speed up UI response
        Handler handler = new Handler();
        //postDelayed() releases the MainThread for the stated amount of time
        handler.postDelayed(runnable, 3000);



    }

    //  Clear the output, called from the onClick event in the layout file
    public void clearOutput(View v) {
        mLog.setText("");
        scrollTextToEnd();
    }

    //  Log output to logcat and the screen
    private void log(String message) {
        Log.i(TAG, message);
        mLog.append(message + "\n");
        scrollTextToEnd();
    }

    private void scrollTextToEnd() {
        mScroll.post(new Runnable() {
            @Override
            public void run() {
                mScroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void displayProgressBar(boolean display) {
        if (display) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}