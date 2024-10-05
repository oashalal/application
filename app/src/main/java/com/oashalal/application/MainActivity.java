package com.oashalal.application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.oashalal.application.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TextView label;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());

        label = findViewById(R.id.label);
        Button button = findViewById(R.id.button);

        label.setText("0");
        label.setTextSize(20);
        num = 0;

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                label.setText(num++);
            }            
        });
        button.setText("add 1");
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
