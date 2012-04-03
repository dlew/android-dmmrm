package com.idunnolol.repeat.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.idunnolol.repeat.R;

/**
 * Demonstrates a few ways of getting around configuration changes
 * in an Activity.  While mVar doesn't actually change, if it did
 * this Activity would handle (in multiple ways) the restoration of
 * its value.
 */
public class DetectConfigActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_bools);

		TextView textView = (TextView) findViewById(android.R.id.text1);

		// Use the boolean to detect orientation
		if (getResources().getBoolean(R.bool.is_landscape)) {
			textView.setText(R.string.landscape_detected);
		}
		else {
			textView.setText(R.string.landscape_not_detected);
		}
	}
}
