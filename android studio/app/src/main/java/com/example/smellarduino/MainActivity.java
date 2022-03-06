package com.example.smellarduino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout menuLayout;
    private ImageView bigImage;
    private TextView bigText;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Button activityButton;

    private View appView;
    private WindowInsetsController windowInsetsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            windowInsetsController = getWindow().getInsetsController();
        }

        hideActionBar();

        Intent dispenseIntent = new Intent(this, BluetoothService.class);
        startService(dispenseIntent);

        menuLayout = this.findViewById(R.id.MenuLayout);
        bigImage = this.findViewById(R.id.BigImage);
        bigText = this.findViewById(R.id.BigText);


        menuItems.add(new MenuItem("Mango", "mango", "A1B0C0D0E0F0G0"));
        menuItems.add(new MenuItem("Orange", "orange", "A0B1C0D0E0F0G0"));
        menuItems.add(new MenuItem("Pineapple", "pineapple", "A0B0C1D0E0F0G0"));
        menuItems.add(new MenuItem("Strawberry", "strawberry", "A0B0C0D1E0F0G0"));
        menuItems.add(new MenuItem("Peach", "peach", "A0B0C0D0E1F0G0"));
        menuItems.add(new MenuItem("Banana", "banana", "A0B0C0D0E0F1G0"));
        menuItems.add(new MenuItem("Banana Mango", "banana_mango", "A1B0C0D0E0F1G0"));
        menuItems.add(new MenuItem("Mango Peach", "mango_peach", "A1B0C0D0E1F0G0"));
        menuItems.add(new MenuItem("Exhaust On", "empty_cup", "G1"));
        menuItems.add(new MenuItem("Exhaust Off", "empty_cup", "G0"));

        for (MenuItem item : menuItems) {
            // Adapted from https://stackoverflow.com/questions/3195668/android-programmatically-include-layout-i-e-without-xml
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View childLayout = inflater.inflate(R.layout.item_card, null);

            TextView childName = childLayout.findViewById(R.id.ItemTitle);
            childName.setText(item.getName());

            ImageView childImage = childLayout.findViewById(R.id.ItemImage);
            childImage.setImageResource(getResources().getIdentifier(item.getDrawable(), "drawable", getPackageName()));

            childLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bigImage.setImageResource(getResources().getIdentifier(item.getDrawable(), "drawable", getPackageName()));
                    bigText.setText(item.getName());

                    Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                    smellIntent.putExtra("fanControl", item.getScentString());
                    startService(smellIntent);
                }
            });

            menuLayout.addView(childLayout);

            activityButton = findViewById(R.id.activityButton);
            activityButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                    smellIntent.putExtra("fanControl", "A0B0C0D0E0F0");
                    startService(smellIntent);
                    Intent intent = new Intent(MainActivity.this, IndividualFlavorActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    protected void hideActionBar() {
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        appView.setSystemUiVisibility(uiOptions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            windowInsetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            windowInsetsController.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        }

        ActionBar actionBar = getActionBar();

        if(actionBar != null) {
            actionBar.hide();
        }
    }
}