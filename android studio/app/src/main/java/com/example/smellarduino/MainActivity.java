package com.example.smellarduino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout peachButton;
    private ConstraintLayout mangoButton;
    private ConstraintLayout strawberryButton;
    private boolean peachSmellEnabled = false;
    private boolean mangoSmellEnabled = false;
    private boolean strawberrySmellEnabled = false;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.strawberry, R.drawable.orange, R.drawable.pineapple, R.drawable.mango, R.drawable.peach, R.drawable.banana, R.drawable.banana_mango};

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
            Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
            smellIntent.putExtra("fanSpeed", 0);
            smellIntent.putExtra("fanLabel", "A");
            startService(smellIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        Intent dispenseIntent = new Intent(this, BluetoothService.class);
        startService(dispenseIntent);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

/*
        // Connect to arduino via Bluetooth
//        Intent dispenseIntent = new Intent(this, BluetoothService.class);
//        startService(dispenseIntent);

        peachButton = findViewById(R.id.drink1);
        mangoButton = findViewById(R.id.drink2);
        strawberryButton = findViewById(R.id.drink3);

        peachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (peachSmellEnabled)  {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "A");
                    peachSmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed",  1);
                    smellIntent.putExtra("fanLabel", "A");
                    peachSmellEnabled = true;
                }
                startService(smellIntent);
            }
        });

        mangoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (mangoSmellEnabled) {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "B");
                    mangoSmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed", 1);
                    smellIntent.putExtra("fanLabel", "B");
                    mangoSmellEnabled = true;
                }
                startService(smellIntent);
            }
        });

        strawberryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (strawberrySmellEnabled) {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "C");
                    strawberrySmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed", 1);
                    smellIntent.putExtra("fanLabel", "C");
                    strawberrySmellEnabled = true;
                }
                startService(smellIntent);
            }
        });

 */
    }
}