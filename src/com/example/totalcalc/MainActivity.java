package com.example.totalcalc;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		android.view.View.OnClickListener {
	protected static EditText mStudentNumber;
	protected static EditText mMid1;
	protected static EditText mMid2;
	protected static EditText mFinal;
	protected static Button caLButton;
	protected static Button newButton;
	protected static Button listButton;
	protected static ListView viewList;
	protected static int counter;
	protected ArrayAdapter<String> adapterList;
	protected static EditText mMid1View;
	protected static EditText mMid2View;
	protected static EditText mFinalView;
	 ArrayList<String> list = new ArrayList<String>();
	static String[] grabList = {};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// GetList
		viewList = (ListView) findViewById(R.id.listView1);
		// FIND vIEW
		mStudentNumber = (EditText) findViewById(R.id.studentNumber);
		mMid1 = (EditText) findViewById(R.id.MID1);
		mMid2 = (EditText) findViewById(R.id.MID2);
		mFinal = (EditText) findViewById(R.id.FINAL);
		mMid1View = (EditText) findViewById(R.id.MID1VIEW);
		mMid2View = (EditText) findViewById(R.id.MID2VIEW);
		mFinalView = (EditText) findViewById(R.id.FINALVIEW);
		// BUTTON
		caLButton = (Button) findViewById(R.id.CalButton);
		newButton = (Button) findViewById(R.id.newButton);
		listButton = (Button) findViewById(R.id.listButton);
		// gET bUTTON
		caLButton.setOnClickListener(this);
		newButton.setOnClickListener(this);
		listButton.setOnClickListener(this);
		
		viewList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {
                Toast.makeText(v.getContext(), ""+pos, Toast.LENGTH_SHORT).show();
                
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.CalButton:
			int Total = 0;
			int midterm1 = Integer.parseInt(mMid1.getText().toString());
			int midterm2 = Integer.parseInt(mMid1.getText().toString());
			int finalGrade = Integer.parseInt(mFinal.getText().toString());
			int midterm1per = Integer.parseInt(mMid1View.getText().toString());
			int midterm2per = Integer.parseInt(mMid2View.getText().toString());
			int finalGradeper = Integer.parseInt(mFinalView.getText()
					.toString());

			String stdNumber = mStudentNumber.getText().toString();
			Total = (int) ((midterm1 * midterm1per / 100)
					+ (midterm2 * midterm2per / 100) + (finalGrade
					* finalGradeper / 100));
			list.add(stdNumber + " Total " + "=" + Total);
			Toast.makeText(this, "Student " + stdNumber + " Added in the List",
					Toast.LENGTH_LONG).show();

			break;
		case R.id.newButton:
			Intent intent = new Intent(MainActivity.this, ListActivity.class);
			String midterm01 = mMid1.getText().toString();
			String midterm02 = mMid1.getText().toString();
			String finalGrade0 = mFinal.getText().toString();
			String stdNumber0 = mStudentNumber.getText().toString();

			// PARSE PERCENTAGES TO THE NEW ACTIVITY
			String midterm1per0 = mMid1View.getText().toString();
			String midterm2per0 = mMid2View.getText().toString();
			String finalGradeper0 = mFinalView.getText().toString();
			// Pass grade
			intent.putExtra("MID1", midterm01);
			intent.putExtra("MID2", midterm02);
			intent.putExtra("FINAL", finalGrade0);
			intent.putExtra("MID1PER", midterm01);
			intent.putExtra("MID2PER", midterm02);
			intent.putExtra("FINALPER", finalGrade0);
			intent.putExtra("StudentNumber", stdNumber0);

			startActivity(intent);

			break;

		case R.id.listButton:
			adapterList = new ArrayAdapter<String>(MainActivity.this,
					android.R.layout.simple_list_item_1,list);
			viewList.setAdapter(adapterList);
			break;

		default:
			break;
		}

	}

}
