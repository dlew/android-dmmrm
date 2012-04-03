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
public class StringFormatActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_string_formatting);

		TextView textView = (TextView) findViewById(android.R.id.text1);

		textView.setText(getString(R.string.template_example, "First point", "Second point"));
	}
}
