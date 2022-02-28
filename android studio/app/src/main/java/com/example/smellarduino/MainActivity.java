package com.example.smellarduino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent dispenseIntent = new Intent(this, BluetoothService.class);
        startService(dispenseIntent);

        menuLayout = this.findViewById(R.id.MenuLayout);
        bigImage = this.findViewById(R.id.BigImage);
        bigText = this.findViewById(R.id.BigText);

        menuItems.add(new MenuItem("Banana", "banana", "A0"));
        menuItems.add(new MenuItem("Peach", "peach", "A0"));
        menuItems.add(new MenuItem("Mango", "mango", "A0"));
        menuItems.add(new MenuItem("Pineapple", "pineapple", "A0"));
        menuItems.add(new MenuItem("Strawberry", "strawberry", "A0"));
        menuItems.add(new MenuItem("Orange", "orange", "A0"));
        menuItems.add(new MenuItem("Banana Mango", "banana_mango", "A0"));
        menuItems.add(new MenuItem("Mango Peach", "mango_peach", "A0"));

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
        }
    }
}