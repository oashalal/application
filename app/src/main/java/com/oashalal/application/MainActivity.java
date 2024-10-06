package com.oashalal.application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.oashalal.application.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private ActivityMainBinding binding;
    
    public TextView label;
    public TextView title;

    public int currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());

        label = findViewById(R.id.label);
        title = findViewById(R.id.title);

        label.setTextSize(17);
        title.setTextSize(25);

        Button nextButton = findViewById(R.id.button_next);
        Button backButton = findViewById(R.id.button_back);
        
        nextButton.setText(">");
        backButton.setText("<");

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currentDay == 7) {
                    currentDay = 1;
                    updateSchedule();
                    return;
                }
                currentDay += 1;  
                updateSchedule();
            }                   
        });
        
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currentDay == 1) {
                    currentDay = 7;
                    updateSchedule();
                    return;
                }
                currentDay -= 1;  
                updateSchedule();
            }                   
        });

    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    private void initSchedule() {
        currentDay = ScheduleService.getDay();
        updateSchedule(); 
    }

    public void updateSchedule() {
        String[] schedule = ScheduleService.getSchedule(currentDay);
        String titleString = ScheduleService.getDayName(currentDay);
        
        StringBuilder builder = new StringBuilder();
        for (String string : schedule) {
            builder.append(string + "\n"); 
        }
        title.setText(titleString);
        label.setText(builder.toString());
    }
}
