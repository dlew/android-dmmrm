package com.idunnolol.repeat.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Demonstrates a few ways of getting around configuration changes
 * in an Activity.  While mVar doesn't actually change, if it did
 * this Activity would handle (in multiple ways) the restoration of
 * its value.
 */
public class ConfigChangeActivity extends Activity {

	private static final String INSTANCE_KEY = "key";

	private boolean mVar = false;

	private State mInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Restore mVar from onSaveInstanceState()
		if (savedInstanceState != null) {
			mVar = savedInstanceState.getBoolean(INSTANCE_KEY);
		}

		// Restore mVar from onRetainNonConfigurationInstance()
		mVar = (Boolean) getLastNonConfigurationInstance();

		// Use a Fragment to hold mVar instead; access mInstance.mVar
		// instead of using mVar directly. 
		FragmentManager fm = getFragmentManager();
		mInstance = (State) fm.findFragmentByTag(State.TAG);
		if (mInstance == null) {
			mInstance = new State();
			mInstance.setRetainInstance(true);
			fm.beginTransaction().add(mInstance, State.TAG).commit();
		}
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return mVar;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(INSTANCE_KEY, mVar);
	}

	public static final class State extends Fragment {
		public static final String TAG = State.class.getName();

		public boolean mVar = false;
	}
}
