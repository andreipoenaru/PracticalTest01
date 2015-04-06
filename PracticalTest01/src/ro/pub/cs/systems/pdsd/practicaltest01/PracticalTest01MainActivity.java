package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;


public class PracticalTest01MainActivity extends Activity {
	
	CheckBox c1;
	CheckBox c2;
	EditText e1;
	EditText e2;
	Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b = (Button) findViewById(R.id.b);
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        
        c1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				e1.setEnabled(isChecked);
			}
		});
        
        c2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				e2.setEnabled(isChecked);
			}
		});
        
        b.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				i.putExtra("nume", e1.getText().toString());
				i.putExtra("grupa", e2.getText().toString());
				
				startActivityForResult(i, 2015);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	super.onSaveInstanceState(savedInstanceState);
    	
    	savedInstanceState.putString("e1", e1.getText().toString());
    	savedInstanceState.putString("e2", e2.getText().toString());
    	savedInstanceState.putBoolean("c1", c1.isChecked());
    	savedInstanceState.putBoolean("c2", c2.isChecked());
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle b) {
    	super.onRestoreInstanceState(b);
    	
    	e1.setText(b.getString("e1"));
    	e2.setText(b.getString("e2"));
    	c1.setChecked(b.getBoolean("c1"));
    	c2.setChecked(b.getBoolean("c2"));
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	Toast.makeText(this, resultCode + "", Toast.LENGTH_SHORT).show();
    }
}
