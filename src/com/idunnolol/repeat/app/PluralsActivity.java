package com.idunnolol.repeat.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.idunnolol.repeat.R;

/**
 * Demonstrates a few ways of getting around configuration changes
 * in an Activity.  While mVar doesn't actually change, if it did
 * this Activity would handle (in multiple ways) the restoration of
 * its value.
 */
public class PluralsActivity extends Activity {

	private static final String STATE_NUM = "STATE_NUM";

	private int mNum = 0;

	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_plurals);

		mTextView = (TextView) findViewById(android.R.id.text1);
		Button button = (Button) findViewById(android.R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mNum++;
				updateCount();
			}
		});

		if (savedInstanceState != null) {
			mNum = savedInstanceState.getInt(STATE_NUM, 0);
		}

		// Initial update
		updateCount();
	}

	private void updateCount() {
		String val = getResources().getQuantityString(R.plurals.items_pluralization, mNum, mNum);
		mTextView.setText(val);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_NUM, mNum);
	}
}
