package com.idunnolol.repeat.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.idunnolol.repeat.R;

public class RepeatedIncludeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_repeated_include);

		configureInclude(R.id.repeat_1, "First instance");
		configureInclude(R.id.repeat_2, "Second instance");
		configureInclude(R.id.repeat_3, "Third instance");
	}

	private void configureInclude(int id, String text) {
		TextView tv = (TextView) findViewById(id);
		tv.setText(text);
	}
}
