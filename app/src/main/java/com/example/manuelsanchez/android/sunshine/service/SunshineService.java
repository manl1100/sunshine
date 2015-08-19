package com.example.manuelsanchez.android.sunshine.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Manuel Sanchez on 8/18/15
 */
public class SunshineService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SunshineService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
