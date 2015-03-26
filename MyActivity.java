package com.olekm.simpcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    protected TextView textView;

    private float first = 0;
    private float second = 0;
    private float solution = 0;
    private boolean operation = false;
    private boolean addition = false;
    private boolean subtraction = false;
    private boolean multiplication = false;
    private boolean division = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textView = (TextView)
                findViewById(R.id.textView);
        if (savedInstanceState != null)   {
            textView.setText(
                    savedInstanceState.getCharSequence("solution"));
        }
    }

    public void onButtonClick(View v){
        Button button = (Button) v;
        String bText = (String) button.getText();
        int value = Integer.parseInt(bText);
        if (!operation) {
            first = (first * 10) + value;
            TextView myTextView = (TextView)
                    findViewById(R.id.textView);
            myTextView.setText(Float.toString(first));
        }
        else {
            second = second * 10 + value;
            TextView myTextView = (TextView)
                    findViewById(R.id.textView);
            myTextView.setText(Float.toString(second));
        }
    }

    public void onPlusClick(View v){
        if (operation){
            return;
        }
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(Float.toString(second));
        addition = true;
        operation = true;
    }

    public void onMinusClick(View v){
        if (operation){
            return;
        }
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(Float.toString(second));
        subtraction = true;
        operation = true;
    }

    public void onMultiplyClick(View v){
        if (operation){
            return;
        }
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(Float.toString(second));
        multiplication = true;
        operation = true;
    }

    public void onDivideClick(View v){
        if (operation){
            return;
        }
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(Float.toString(second));
        division = true;
        operation = true;
    }

    public void onClear(View v){
        multiplication = false;
        division = false;
        subtraction = false;
        addition = false;
        operation = false;
        second = 0;
        first = 0;
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(Float.toString(first));
    }

    public void onEqualClick(View v){
        if (addition){
            solution = first + second;
            TextView myTextView = (TextView) findViewById(R.id.textView);
            myTextView.setText(Float.toString(solution));

        }
        else if (subtraction){
            solution = first - second;
            TextView myTextView = (TextView) findViewById(R.id.textView);
            myTextView.setText(Float.toString(solution));
        }
        else if (multiplication){
            solution = first * second;
            TextView myTextView = (TextView) findViewById(R.id.textView);
            myTextView.setText(Float.toString(solution));
        }
        else if (division){
            solution = first / second;
            TextView myTextView = (TextView) findViewById(R.id.textView);
            myTextView.setText(Float.toString(solution));
        }
        else {return;}
        multiplication = false;
        division = false;
        subtraction = false;
        addition = false;
        operation = false;
        first = 0;
        second = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
    protected void onSaveInstanceState(
            Bundle savedInstanceState){

        savedInstanceState.putCharSequence(
                "solution",textView.getText());
        super.onSaveInstanceState(savedInstanceState);
    }
}
