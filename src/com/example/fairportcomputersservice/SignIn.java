package com.example.fairportcomputersservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	private ArrayList<Customer> customers;
	private final String DATA_FILE = "FairportComputersData";
	private int customerNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customers = new ArrayList<Customer>();
        customerNumber = 0;
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
    	if (((EditText) findViewById(R.id.name_edit)).getText().toString() != null && 
    			((EditText) findViewById(R.id.phone_edit)).getText().toString() != null &&
    			((EditText) findViewById(R.id.email_edit)).getText().toString() != null &&
    			((EditText) findViewById(R.id.phone_edit)).getText().toString() != null &&
    			((EditText) findViewById(R.id.type_edit)).getText().toString() != null &&
    			((EditText) findViewById(R.id.problem_edit)).getText().toString() != null) {
    		String a = ((EditText) findViewById(R.id.name_edit)).getText().toString();
    		String b = ((EditText) findViewById(R.id.phone_edit)).getText().toString();
    		String c = ((EditText) findViewById(R.id.email_edit)).getText().toString();
    		String d = ((EditText) findViewById(R.id.type_edit)).getText().toString();
    		String e = ((EditText) findViewById(R.id.problem_edit)).getText().toString();
    		try {
    			InputStream inputStream = openFileInput(DATA_FILE);
    			if (inputStream != null) {
    				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    				while (bufferedReader.readLine() != null)
    					customerNumber++;
    			}
    		}
    		catch (IOException e1) { Toast.makeText(getApplicationContext(), "cannot read file", Toast.LENGTH_SHORT).show(); }
    		customers.add(new Customer(a, b, c, d, e, customerNumber + 1));
    	}
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
	    			f.write((customers.get(customerNumber)).toString().getBytes());
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
