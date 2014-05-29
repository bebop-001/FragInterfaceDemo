package com.example.fraginterfacedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SideFragment extends Fragment {
	private View view;
	// button callback to MainActivity.
	FragButtonListener mainButtonCallback = null;
	private static String tag = "SideFragment";
	// define the callback.
	public interface FragButtonListener {
		public void fragButtonListener(String string);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.side_layout, container, false);
		Button b = (Button)view.findViewById(R.id.submit_button);
		b.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					EditText et = (EditText)view.findViewById(R.id.editText1);
					String text = et.getText().toString();
					et.setText("");
					Log.i(tag, "onClick:\"" + text + "\"");
					mainButtonCallback.fragButtonListener(text);
				}
			}
		);
		return view;
	}
	// abort unless we have a callback.
	@Override
	public void onAttach(Activity activity) {
		try {
			mainButtonCallback = (FragButtonListener) activity;
			Log.i(tag, "onAttach: got mainButtonCallback");
		}
		catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ ":Must implement FragButtonListener"
			);
		}
		super.onAttach(activity);
	}

}
