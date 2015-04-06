package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {
	
	EditText e3;
	EditText e4;
	Button bok;
	Button bcancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		e3 = (EditText) findViewById(R.id.e3);
		e4 = (EditText) findViewById(R.id.e4);
		
		bok = (Button) findViewById(R.id.bok);
		bcancel = (Button) findViewById(R.id.bcancel);
		
		Intent i = getIntent();
		
		if (i != null) {
			String nume = i.getStringExtra("nume");
			String grupa = i.getStringExtra("grupa");
			
			if (nume != null) {
				e3.setText(nume);
			}
			if (grupa != null) {
				e4.setText(grupa);
			}
		}
		
		bok.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK, new Intent());
				finish();
			}
		});
		
		bcancel.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED, new Intent());
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
