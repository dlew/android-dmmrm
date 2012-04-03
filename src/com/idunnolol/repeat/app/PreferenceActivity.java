package com.idunnolol.repeat.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.idunnolol.repeat.R;

public class PreferenceActivity extends Activity implements OnSharedPreferenceChangeListener {

	private PreferenceFragment mFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_preferences);

		// Retrieve the Fragment by tag, then add preferences to it
		mFragment = (PreferenceFragment) getFragmentManager().findFragmentByTag(
				getString(R.string.tag_preference_fragment));
		mFragment.addPreferencesFromResource(R.xml.preferences);
	}

	@Override
	protected void onResume() {
		super.onResume();

		PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();

		PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		// We check to see if a particular key has changed; if it has, notify the user
		if (key.equals(getString(R.string.key_preference))) {
			Toast.makeText(PreferenceActivity.this, getString(R.string.preference_changed), Toast.LENGTH_SHORT).show();
		}
	}
}
