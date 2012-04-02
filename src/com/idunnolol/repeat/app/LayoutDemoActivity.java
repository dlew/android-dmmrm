package com.idunnolol.repeat.app;

import android.app.Activity;
import android.os.Bundle;

/**
 * Easy way of inflating a demo that just shows a static layout.
 */
public class LayoutDemoActivity extends Activity {

	public static final String EXTRA_LAYOUT_ID = "EXTRA_LAYOUT_ID";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(getIntent().getIntExtra(EXTRA_LAYOUT_ID, 0));
	}

}
