package com.idunnolol.repeat.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idunnolol.repeat.R;

public class RepeatedInflationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_repeated_inflation);

		ViewGroup container = (ViewGroup) findViewById(R.id.container);
		addRow(container, "First instance");
		addRow(container, "Second instance");
		addRow(container, "Third instance");
	}

	private void addRow(ViewGroup container, String text) {
		TextView view = (TextView) getLayoutInflater().inflate(R.layout.include_repeat, container, false);
		view.setText(text);
		container.addView(view);
	}
}
