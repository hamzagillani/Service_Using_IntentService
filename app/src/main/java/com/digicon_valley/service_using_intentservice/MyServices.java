package com.digicon_valley.service_using_intentservice;

import android.app.IntentService;
import android.content.Intent;

import android.widget.Toast;


public class MyServices extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyServices() {
        super("My_worker_Thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Service Started...",Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service Stopped...",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this){

            int count= 0;
            while (count<10){

                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
