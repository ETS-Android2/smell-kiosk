package com.example.smellarduino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IndividualFlavorActivity extends AppCompatActivity {
    private Button menuButton;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private boolean fanAOn = false;
    private boolean fanBOn = false;
    private boolean fanCOn = false;
    private boolean fanDOn = false;
    private boolean fanEOn = false;
    private boolean fanFOn = false;

    //A Mango
    //B Orange
    //C Pineapple
    //D Strawberry
    //E Peach
    //F Banana
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_flavor_activity);

        menuButton = findViewById(R.id.button7);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B0C0D0E0F0");
                startService(smellIntent);
                Intent intent = new Intent(IndividualFlavorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanAOn) {
                    smellIntent.putExtra("fanControl", "A1");
                    button1.setText("Remove Mango");
                    fanAOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "A0");
                    button1.setText("Add Mango");
                    fanAOn = false;
                }
                startService(smellIntent);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanBOn) {
                    smellIntent.putExtra("fanControl", "B1");
                    button2.setText("Remove Orange");
                    fanBOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "B0");
                    button2.setText("Add Orange");
                    fanBOn = false;
                }
                startService(smellIntent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanCOn) {
                    smellIntent.putExtra("fanControl", "C1");
                    button3.setText("Remove Pineapple");
                    fanCOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "C0");
                    button3.setText("Add Pineapple");
                    fanCOn = false;
                }
                startService(smellIntent);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanDOn) {
                    smellIntent.putExtra("fanControl", "D1");
                    button4.setText("Remove Strawberry");
                    fanDOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "D0");
                    button4.setText("Add Strawberry");
                    fanDOn = false;
                }
                startService(smellIntent);
            }
        });

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanEOn) {
                    smellIntent.putExtra("fanControl", "E1");
                    button5.setText("Remove Peach");
                    fanEOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "E0");
                    button5.setText("Add Peach");
                    fanEOn = false;
                }
                startService(smellIntent);
            }
        });

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (!fanFOn) {
                    smellIntent.putExtra("fanControl", "F1");
                    button6.setText("Remove Banana");
                    fanFOn = true;
                } else {
                    smellIntent.putExtra("fanControl", "F0");
                    button6.setText("Add Banana");
                    fanFOn = false;
                }
                startService(smellIntent);
            }
        });
    }
}
