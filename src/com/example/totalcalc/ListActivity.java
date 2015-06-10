package com.example.totalcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends Activity {
	protected static TextView mStudentNumber;
	protected static TextView mMid1;
	protected static TextView mMid2;
	protected static TextView mFinal;
	protected static TextView mTOTAL;
	protected static Button closeButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		closeButton = (Button) findViewById(R.id.closeButton);
		// FIND vIEW
				mStudentNumber = (TextView) findViewById(R.id.studentNumber);
				mMid1 = (TextView) findViewById(R.id.midterm1View);
				mMid2 = (TextView) findViewById(R.id.midterm2View);
				mFinal= (TextView) findViewById(R.id.finalView);
				mTOTAL= (TextView) findViewById(R.id.TotalView);
				String getNumber = getIntent().getStringExtra("StudentNumber");
				String getMidterm1 = getIntent().getStringExtra("MID1");
				String getMidterm2 = getIntent().getStringExtra("MID2");
				String getfinal = getIntent().getStringExtra("FINAL");
				String getMidterm1PER = getIntent().getStringExtra("MID1PER");
				String getMidterm2PER = getIntent().getStringExtra("MID2PER");
				String getfinalPER = getIntent().getStringExtra("FINALPER");
				
				//PARSE ALL STRING
				double mid1= Double.parseDouble(getMidterm1.toString());
				double mid2= Double.parseDouble(getMidterm2.toString());
				double finalgrade= Double.parseDouble(getfinal.toString());
				double mid1PER= Double.parseDouble(getMidterm1PER.toString());
				double mid2PER= Double.parseDouble(getMidterm2PER.toString());
				double finalgradePER= Double.parseDouble(getfinalPER.toString());
				
				double sum = (mid1*(mid1PER/100))+(mid2*(mid2PER/100))+(finalgrade*(finalgradePER/100));
				         
	
				mStudentNumber.setText(getNumber);
				mTOTAL.setText(" " +sum);
			  
			//	
			//SETvALUE
				mMid1.setText(getMidterm1PER);
				mMid2.setText(getMidterm2PER);
				mFinal.setText(getfinalPER);
				
				closeButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(ListActivity.this, MainActivity.class);
						startActivity(intent);
					}
				});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
