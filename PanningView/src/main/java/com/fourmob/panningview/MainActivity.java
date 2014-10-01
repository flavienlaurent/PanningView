package com.fourmob.panningview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.fourmob.panningview.library.PanningView;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	private static final int[] drawables = new int[] {R.drawable.bg_default_artist_art, R.drawable.bg_default_artist_art2, R.drawable.bg_default_artist_art3, R.drawable.bg_default_artist_art4};

	private int mDrawableIndex = 0;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		final PanningView panningView = (PanningView) findViewById(R.id.panningView);

		findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				panningView.startPanning();
			}
		});
		findViewById(R.id.buttonStop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				panningView.stopPanning();
			}
		});
		findViewById(R.id.buttonChange).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDrawableIndex++;
				if(mDrawableIndex >= drawables.length) {
					mDrawableIndex = 0;
				}
				panningView.setImageResource(drawables[mDrawableIndex]);
			}
		});
	}
}