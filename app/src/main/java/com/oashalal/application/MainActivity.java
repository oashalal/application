package com.oashalal.application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.oashalal.application.databinding.ActivityMainBinding;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());
        TextView label = findViewById(R.id.label);
        label.setText("Hello, World");
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
