package com.oashalal.application;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView text = findViewById(R.id.label);
        text.setText("Hello, World");
        text.setTextSize(20);

        setContentView(R.layout.activity_main);
    }
}
