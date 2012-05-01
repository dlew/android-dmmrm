package com.idunnolol.repeat.app;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.idunnolol.repeat.R;

public class LevelDrawableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_level_drawable);

		ViewGroup container = (ViewGroup) findViewById(R.id.container);

		addClipDrawable(container, 2500);
		addClipDrawable(container, 5000);
		addClipDrawable(container, 7500);
		addClipDrawable(container, 10000);
	}

	// Level goes from 0 to 10000
	private void addClipDrawable(ViewGroup container, int level) {
		ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.snippet_clip_drawable, container, false);

		ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
		drawable.setLevel(level);

		container.addView(imageView);
	}
}
