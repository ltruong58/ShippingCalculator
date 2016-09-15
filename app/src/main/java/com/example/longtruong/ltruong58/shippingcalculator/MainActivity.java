package com.example.longtruong.ltruong58.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.NumberFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Main control of the app, get data from views then create ShipItem object to store and calculate data(in ShipItem).
 * @author Long Truong
 */
public class MainActivity extends AppCompatActivity {

    //Associate the controller with the needed views
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalShippingCostTextView;

    // Associate the controller with the needed model
    ShipItem currentShipping = new ShipItem();

    NumberFormat myCurrency = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widgets in our app
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalShippingCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        // Define a listener for the weightEditText
        weightEditText.addTextChangedListener(weightTextChangedListener);
    }

    // TextWatcher to update data when user inputs to the weightEditText
    private TextWatcher weightTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if(s.length() == 0){
                    currentShipping.setWeight(0);
                }
                else {
                    int weight = Integer.parseInt(s.toString());
                    currentShipping.setWeight(weight);
                }

                baseCostTextView.setText(myCurrency.format(currentShipping.getBaseCost()));
                addedCostTextView.setText(myCurrency.format(currentShipping.getAddedCost()));
                totalShippingCostTextView.setText(myCurrency.format(currentShipping.getTotalCost()));
            } catch (NumberFormatException e) {
                weightEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
