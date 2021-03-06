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


package com.birkettenterprise.phonelocator.settings;

public class Setting {
	
	public class StringSettings {
		public static final String UPDATE_FREQUENCY = "update_frequency";   		
		public static final String AUTHENTICATION_TOKEN = "authentication_token";
	    public static final String REGISTRATION_URL = "registration_url";
	}
    
	public class BooleanSettings {
		public static final String PERIODIC_UPDATES_ENABLED = "periodic_updates_enabled"; 
	    public static final String REGISTERED = "registered";
	}
	
	public class Integer64Settings {
		public static final String IMEI = "imei"; 
		public static final String IMSI = "imsi";
	}
	
	public class IntegerSettings {
		public static final String VERSION_MINOR = "version_minor"; 
		public static final String VERSION_MAJOR = "version_major"; 
		public static final String VERSION_REVISION = "version_revision";
	}
	
	private long mTimestamp;
	private String mName;
	private Object mValue;
	
	public Setting() {
		
	}
	
	public Setting(String name, Object value, long timestamp) {
		setName(name);
		setValue(value);
		setTimestamp(timestamp);
	}
	
	public long getTimestamp() {
		return mTimestamp;
	}
	public void setTimestamp(long timestamp) {
		this.mTimestamp = timestamp;
	}
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public Object getValue() {
		return mValue;
	}
	public void setValue(Object value) {
		this.mValue = value;
	}
}
