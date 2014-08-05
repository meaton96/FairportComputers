package com.example.fairportcomputersservice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignIn extends ActionBarActivity {
	
	private FieldValue[] fieldValues;
	private final String DATA_FILE = "FairportComputersData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fieldValues = new FieldValue[5];
    }
    
    //on click listener for settings button
    public void _settingsStart(View view)
    {
    	Intent i = new Intent(this, Settings.class);
    	startActivity(i);
    }
    
    //on click listener for submit button
    public void _customerInfo_submit(View view)
    {
    	EditText t = new EditText(null);
    	//adds name and value to FieldValues
    	t = (EditText)findViewById(R.id.name_edit);
    	if (t.getText().toString() != null) 
    		fieldValues[0] = new FieldValue("name", t.getText().toString());
    	//adds phone and value to Fieldvalues
    	t = (EditText)findViewById(R.id.phone_edit);
    	if (t.getText().toString() != null)
    		fieldValues[1] = new FieldValue("phone", t.getText().toString());
    	//adds email and value to FieldValues
    	t = (EditText)findViewById(R.id.email_edit);
    	if (t.getText().toString() != null)
    		fieldValues[2] = new FieldValue("email", t.getText().toString());
    	//adds computer type and value to FieldValues
    	t = (EditText)findViewById(R.id.type_edit);
    	if (t.getText().toString() != null)
    		fieldValues[3] = new FieldValue("type", t.getText().toString());
    	//adds computer problem and value to FieldValues
    	t = (EditText)findViewById(R.id.problem_edit);
    	if (t.getText().toString() != null)
    		fieldValues[4] = new FieldValue("problem", t.getText().toString());
    	
    	/*
    	 * 
    	 * 
    	 * missing code to send to server
    	 * 
    	 */
    	//temporary code writes the data to device for storage
    	FileOutputStream f = null;
    	try { f = openFileOutput(DATA_FILE, Context.MODE_PRIVATE); } 
    	catch (FileNotFoundException e) { e.printStackTrace(); }
    	if (f != null) {
    		try { 
	    			f.write(fieldValues[0].getValue().getBytes()); 
	    			f.write(fieldValues[1].getValue().getBytes());
	    			f.write(fieldValues[2].getValue().getBytes());
	    			f.write(fieldValues[3].getValue().getBytes());
	    			f.write(fieldValues[4].getValue().getBytes());
	    			f.close();
	    			Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
    			}
    		catch (IOException e) { e.printStackTrace(); }
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_in, menu);
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
