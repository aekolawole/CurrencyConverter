package com.adefemikolawole.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
SpinnerActivity spinnerActivity;
    String text;
    Spinner spTo;
    String user_input  ="";
   Button btConvert;
   TextView tvResult;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("TAG = " + TAG);
        Log.d(TAG, "checking...");
        Log.d(TAG, user_input);
//set values for spinnerFrom
        Spinner spFrom = (Spinner) findViewById(R.id.spFrom); //get THe spFrom form the acctivity_main layout

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerFrom, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFrom.setAdapter(adapter);
        spFrom.setOnItemSelectedListener(spinnerActivity);
//set values for spinnerTo
         spTo = findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapterB = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerTo, android.R.layout.simple_spinner_item);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spTo.setAdapter(adapterB);
    spTo.setOnItemSelectedListener(spinnerActivity);


    // set activity for button Convert

      //  convertValue();
btConvert = (Button) findViewById(R.id.btConvert);
btConvert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getUserInput();
        setTvResult();
    }
});


//textview Result
        tvResult =  (TextView) findViewById(R.id.tvResult);
    }




    class SpinnerActivity extends MainActivity implements AdapterView.OnItemSelectedListener{
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          spTo.setSelection(position);
            text = parent.getItemAtPosition(position).toString();
           Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        //System.out.println("TAG = " + TAG);

           Log.d(parent.getContext().toString(), String.valueOf(position));

       }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {

       }

   }

   public  void getUserInput(){
       EditText txtMoneyValue = (EditText) findViewById(R.id.txtMoneyValue);
       user_input += txtMoneyValue.getText().toString();
       try{
           Integer.parseInt(user_input);
           user_input += user_input.toString();

       }
       catch (Exception x){
           Log.d(TAG, "Error in conversion of user input");
           Toast.makeText(MainActivity.this, "Check your input!!!\nMake sure your input is right!!! ", Toast.LENGTH_LONG).show();
       }

   }

   public void setTvResult(){
       tvResult.setText(user_input);
   }
   public void convertValue(int position){

       btConvert = (Button) findViewById(R.id.btConvert);
        getUserInput();
        switch (position){
            case 0:

            case 1:

            case 2:

            case 3:

            case 4:

            case 5:




        }




   }
}
