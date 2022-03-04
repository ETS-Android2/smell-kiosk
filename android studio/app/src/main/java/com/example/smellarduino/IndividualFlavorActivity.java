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
                smellIntent.putExtra("fanControl", "A1B0C0D0E0F0");
                startService(smellIntent);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B1C0D0E0F0");
                startService(smellIntent);
            }
        });

        button3 = findViewById(R.id.button1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B0C1D0E0F0");
                startService(smellIntent);
            }
        });

        button4 = findViewById(R.id.button1);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B0C0D1E0F0");
                startService(smellIntent);
            }
        });

        button5 = findViewById(R.id.button1);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B0C0D0E1F0");
                startService(smellIntent);
            }
        });

        button6 = findViewById(R.id.button1);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                smellIntent.putExtra("fanControl", "A0B0C0D0E0F1");
                startService(smellIntent);
            }
        });
    }
}
