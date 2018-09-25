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

import java.security.cert.CertPathBuilderSpi;

import static com.adefemikolawole.currencyconverter.R.id.spFrom;
import static com.adefemikolawole.currencyconverter.R.id.txtMoneyValue;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
SpinnerActivity spinnerActivity;
    int itemIndexFrom;
    int itemIndexTo;
    String itemFrom;
    String itemTo;
    int switchValue=0;
    String text;
    Spinner spFrom;
    Spinner spTo;
    String user_input  ="";
   Button btConvert;
   Button btAbout;
   TextView tvResult;
    double userDouble;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    System.out.println("TAG = " + TAG);
        Log.d(TAG, "checking...");
        //Log.d(TAG, user_input);
//set values for spinnerFrom
      spFrom = (Spinner) findViewById(R.id.spFrom); //get THe spFrom form the activity_main layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerFrom, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spFrom.setAdapter(adapter);
        spFrom.setOnItemSelectedListener(MainActivity.this);


//set values for spinnerTo
         spTo = findViewById(R.id.spTo);
        ArrayAdapter<CharSequence> adapterB = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerTo, android.R.layout.simple_spinner_item);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spTo.setAdapter(adapterB);
    spTo.setOnItemSelectedListener(MainActivity.this);


    // set activity for button Convert

      //  convertValue();
btConvert = (Button) findViewById(R.id.btConvert);
btConvert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getUserInput();
        //convertValue();
        setTvResult();
        if (tvResult.getText().equals(tvResult)){
            btConvert.setEnabled(false);
        }
        else{
            btConvert.setEnabled(true);
        }


    }
});


//textview Result
        tvResult =  (TextView) findViewById(R.id.tvResult);

btAbout = (Button) findViewById(R.id.btAbout);
showAboutMessage();

    }
    public void showAboutMessage(){
        btAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Author: Adefemi Kolawole\n  ITEC 4550 :: Fall 2018",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;
        getUserInput();

        if(spin.getId() == R.id.spFrom)
        {
            itemIndexFrom = (int) id;
            itemFrom = parent.getItemAtPosition(position).toString();

            //Toast.makeText(MainActivity.this, "Base Curr:"+ "parent:"+parent+ "Position:"+parent+ "id:"+id + "view:"+view,Toast.LENGTH_SHORT).show();
           // Log.d(TAG, "Base Curr||Plain: "+ "parent: "+parent+ "Position: "+position+ "id:"+id + "view:"+view);
            //Log.d(TAG, "Base; Curr||Formatted:"+ "parent:"+parent.toString()+ "Position:"+String.valueOf(position)+ "id:"+String.valueOf(id) + "view:"+view.toString());
            //Log.d(TAG, "spFrom || id/itemIndexFrom : "+ itemIndexFrom  + " item: " + itemFrom + ", spFrom.getId(): "+ spFrom.getId());


        }

        if(spin2.getId() == R.id.spTo)
        {
            itemIndexTo = (int) id;
            itemTo = parent.getItemAtPosition(position).toString();

            //Toast.makeText(this, "Target Curr:" ,Toast.LENGTH_SHORT).show();
           // Log.d(TAG, "spTo || id/itemIndexTo: "+ itemIndexTo  + " item: " + itemTo + ", spTo.getId(): "+ spTo.getId());
           // Log.d(TAG, "spTo.getId(): "+spTo.getId() );
            //Log.d(parent.getContext().toString(), String.valueOf(position));
        }
        Log.d(TAG, "user_input:"+ user_input +" spFrom || id/itemIndexFrom : "+ itemIndexFrom  + " item: " + itemFrom + ", spFrom.getId(): "+ spFrom.getId() + "::spTo || id/itemIndexTo : "+ itemIndexTo  + " item: " + itemTo + ", spTo.getId(): "+ spTo.getId());



        setSwitchChecker();

   Log.d(TAG, "switchValue:" + switchValue);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){


        Toast.makeText(MainActivity.this, "Choose [Base] & [Target] currency", Toast.LENGTH_SHORT).show();

    }

public void setSwitchChecker(){

    //check for From Euro toTheOtherFIveCurrencies
        if ((itemIndexFrom == 1) && (itemIndexTo == 1)){
            switchValue = 1;
        }
        if ((itemIndexFrom == 1) && (itemIndexTo == 2)){
            switchValue = 2;
        }
        if ((itemIndexFrom == 1) && (itemIndexTo == 3)){
            switchValue = 3;
        }
        if ((itemIndexFrom == 1) && (itemIndexTo == 4)){
            switchValue = 4;
        }
        if ((itemIndexFrom == 1) && (itemIndexTo == 5)){
            switchValue = 5;
        }
            //check for From usd toTheOtherFIveCurrencies
            if ((itemIndexFrom == 2) && (itemIndexTo == 1)){
                switchValue = 6;
            }
            if ((itemIndexFrom == 2) && (itemIndexTo == 2)){
                switchValue = 7;
            }
            if ((itemIndexFrom == 2) && (itemIndexTo == 3)){
                switchValue = 8;
            }
            if ((itemIndexFrom == 2) && (itemIndexTo == 4)){
                switchValue = 9;
            }
            if ((itemIndexFrom == 2) && (itemIndexTo == 5)){
                switchValue = 10;
            }

                //check for From Gbp toTheOtherFIveCurrencies
                if ((itemIndexFrom == 3) && (itemIndexTo == 1)){
                    switchValue = 11;
                }
                if ((itemIndexFrom == 3) && (itemIndexTo == 2)){
                    switchValue = 12;
                }
                if ((itemIndexFrom == 3) && (itemIndexTo == 3)){
                    switchValue = 13;
                }
                if ((itemIndexFrom == 3) && (itemIndexTo == 4)){
                    switchValue = 14;
                }
                if ((itemIndexFrom == 3) && (itemIndexTo == 5)){
                    switchValue = 15;
                }

                        //check for From Cad toTheOtherFIveCurrencies
                        if ((itemIndexFrom == 4) && (itemIndexTo == 1)){
                            switchValue = 16;
                        }
                        if ((itemIndexFrom == 4) && (itemIndexTo == 2)){
                            switchValue = 17;
                        }
                        if ((itemIndexFrom == 4) && (itemIndexTo == 3)){
                            switchValue = 18;
                        }
                        if ((itemIndexFrom == 4) && (itemIndexTo == 4)){
                            switchValue = 19;
                        }
                        if ((itemIndexFrom == 4) && (itemIndexTo == 5)){
                            switchValue = 20;
                        }

                                //check for From Zar toTheOtherFIveCurrencies
                                if ((itemIndexFrom == 5) && (itemIndexTo == 1)){
                                    switchValue = 21;
                                }
                                if ((itemIndexFrom == 5) && (itemIndexTo == 2)){
                                    switchValue = 22;
                                }
                                if ((itemIndexFrom == 5) && (itemIndexTo == 3)){
                                    switchValue = 23;
                                }
                                if ((itemIndexFrom == 5) && (itemIndexTo == 4)){
                                    switchValue = 24;
                                }
                                if ((itemIndexFrom == 5) && (itemIndexTo == 5)){
                                    switchValue = 25;
                                }
}
    class SpinnerActivity extends MainActivity implements AdapterView.OnItemSelectedListener{


   /*    @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           Spinner spin = (Spinner)parent;
           Spinner spin2 = (Spinner)parent;
          //spTo.setSelection(position);
            //text = parent.getItemAtPosition(position).toString();
           Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        //System.out.println("TAG = " + TAG);

           Log.d(parent.getContext().toString(), String.valueOf(position));
       }

       @Override
       public void onNothingSelected(AdapterView<?> parent){
           Toast.makeText(MainActivity.this, "Please select  your base currency and target currency", Toast.LENGTH_SHORT).show();

       }*/

   }

   public  void getUserInput(){
       EditText txtMoneyValue = (EditText) findViewById(R.id.txtMoneyValue);
       user_input = txtMoneyValue.getText().toString();
       try{
           Double.parseDouble(user_input);
           user_input = user_input.toString();
           userDouble = Double.parseDouble(user_input);

       }
       catch (Exception x){
           Log.d(TAG, "Empty input :: Check your input!!!\nMake sure your input is right!!! ");
           Toast.makeText(MainActivity.this, "Empty input :: Check your input!!!\nMake sure your input is right!!! ", Toast.LENGTH_LONG).show();
       }

   }

    public void setTvResult(){
       double usdToGbp = usdToGbp(userDouble); //usdToGbp;

        tvResult.setText(String.valueOf(usdToGbp));

       //tvResult.setText(user_input);
       String checker = tvResult.getText().toString();

       if (tvResult.getText().toString().equals( "") &&!tvResult.getText().toString().equals( String.valueOf(0)) ){

           //tvResult.setText(user_input);
           tvResult.setText(String.valueOf(String.valueOf(0)));
           Toast.makeText(MainActivity.this, "Please enter a value greater than 0 for conversion", Toast.LENGTH_LONG);
       }

       else{

           tvResult.setText(String.valueOf(usdToGbp));
           Toast.makeText(MainActivity.this, "Done : Enter another value.", Toast.LENGTH_LONG);


       }

   }
   public void convertValue(){

       btConvert = (Button) findViewById(R.id.btConvert);
        getUserInput();
        switch (switchValue){

//check for From Euro toTheOtherFIveCurrencies
            case 1:
                Log.d(TAG,  "case1||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 2:
                Log.d(TAG, "case2||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 3:
                Log.d(TAG, "case3||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 4:
                Log.d(TAG, "case4||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 5:
                Log.d(TAG, "case5||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 6:
                Log.d(TAG,  "case1||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 7:
                Log.d(TAG, "case2||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 8:
                Log.d(TAG, "case3||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 9:
                Log.d(TAG, "case4||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 10:
                Log.d(TAG, "case5||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 11:
                Log.d(TAG,  "case1||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 12:
                Log.d(TAG, "case2||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 13:
                Log.d(TAG, "case3||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 14:
                Log.d(TAG, "case4||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 15:
                Log.d(TAG, "case5||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 16:
                Log.d(TAG,  "case1||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 17:
                Log.d(TAG, "case2||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 18:
                Log.d(TAG, "case3||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 19:
                Log.d(TAG, "case4||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 20:
                Log.d(TAG, "case5||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 21:
                Log.d(TAG,  "case1||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 22:
                Log.d(TAG, "case2||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 23:
                Log.d(TAG, "case3||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 24:
                Log.d(TAG, "case4||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;
            case 25:
                Log.d(TAG, "case5||switchValue: " +switchValue + ", ItemFrom: "+ itemFrom + ", itemTo:" + itemTo);
                break;


        }




   }

   public  double usdToGbp(double user_input){
        double answer = 0.0;
     final double oneDolToPds = 0.76;
     return 1 / user_input * oneDolToPds;

   }

    public  double gbpToUsd(double user_input){
        double answer = 0.0;
        final double gbpToUsd = 1.31;
        return user_input * gbpToUsd;

    }
}


