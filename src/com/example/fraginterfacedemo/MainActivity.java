package com.example.fraginterfacedemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.EditText;
// SideFragment.FragButtonListener is fragment callback.
public class MainActivity extends FragmentActivity 
		implements SideFragment.FragButtonListener {
	private static String tag = "MainActivity";
	private static int line_count = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Log.i(tag, "onCreate");
	}
	@Override
	public void fragButtonListener(String string) {
		Log.i(tag, "fragButtonListener:\"" + string + "\"");
		EditText et = (EditText)findViewById(R.id.hello_text);
		et.setText(et.getText().toString()
				+ String.format("\n%2d) %s", line_count++, string));
	}
}
