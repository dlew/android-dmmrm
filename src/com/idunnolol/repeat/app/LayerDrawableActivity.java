package com.idunnolol.repeat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.idunnolol.repeat.R;

public class LayerDrawableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_layer_drawable);

		ViewGroup container = (ViewGroup) findViewById(R.id.container);
		addCat(container, R.drawable.cat1);
		addCat(container, R.drawable.cat2);
		addCat(container, R.drawable.cat3);
	}

	private void addCat(ViewGroup container, int drawableId) {
		ImageView imageView = new ImageView(this);
		imageView.setPadding(0, 20, 0, 20);

		Drawable[] layers = new Drawable[2];
		layers[0] = getResources().getDrawable(drawableId);
		layers[1] = getResources().getDrawable(R.drawable.frame);

		LayerDrawable layerDrawable = new LayerDrawable(layers);
		imageView.setImageDrawable(layerDrawable);

		container.addView(imageView);
	}
}
