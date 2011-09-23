/**
 * 
 *  Copyright 2011 Birkett Enterprise Ltd
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */

package com.birkettenterprise.phonelocator.service;

import com.birkettenterprise.phonelocator.database.DatabaseHelper;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RegistrationService extends Service {

    private final IBinder mBinder = new RegistrationServiceBinder();
    private PreferenceSynchronizer mPreferenceSynchronizer;
    private DatabaseHelper mDatabaseHelper;
    
	public class RegistrationServiceBinder extends Binder {
        public RegistrationService getService() {
            return RegistrationService.this;
        }
    }

    @Override
    public void onCreate() {
    	super.onCreate();
    	mPreferenceSynchronizer = new PreferenceSynchronizer(this);
    	mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       return START_STICKY;
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
    	mPreferenceSynchronizer.destroy();
    	mDatabaseHelper.close();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}