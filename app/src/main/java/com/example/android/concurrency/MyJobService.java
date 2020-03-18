package com.example.android.concurrency;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyJobService extends JobService {

    public static final String TAG = "CodeRunner";

    public MyJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "onStartJob: " + params.getJobId());
        jobFinished(params, false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob: " + params.getJobId());
        return false;
    }


}
