package com.oashalal.application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.oashalal.application.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public TextView label;
    public TextView title;
    public TextView timer;
    public TextView timerInfo;

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
        timer = findViewById(R.id.timer);
        timerInfo = findViewById(R.id.timer_info);

        label.setTextSize(34);
        title.setTextSize(52);
        timer.setTextSize(45);
        timerInfo.setTextSize(21);

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
        initSchedule();

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Обновление View, например, TextView с текущим временем
                updateTimer();
                // Запуск runnable через 1 секунду
                handler.postDelayed(this, 1000);
            }
        };

        // Запуск runnable
        handler.postDelayed(runnable, 1000);
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
        for (int i = 0; i < schedule.length; i++) {
            builder.append(Integer.toString(i + 1) + ". " + schedule[i] + "\n");
        }
        title.setText(titleString);
        label.setText(builder.toString());
    }

    public void updateTimer() {
        Lesson lesson = LessonService.getCurrentLesson();
        if (lesson == null) {
            if ((lesson = LessonService.getNextLesson()) != null) {
                int seconds = Math.abs((int) (lesson.start.until(LocalTime.now(), ChronoUnit.SECONDS)));
                int minutes = seconds / 60;
                timer.setText(String.format("%d:%d", minutes, seconds % 60));
                timerInfo.setText(String.format("До начала %d урока", lesson.index));

            }
            return;
        }
        int seconds = Math.abs((int) (lesson.end.until(LocalTime.now(), ChronoUnit.SECONDS)));
        int minutes = seconds / 60;
        timer.setText(String.format("%d:%d", minutes, seconds % 60));
        timerInfo.setText(String.format("До конца %d урока", lesson.index));
    }
}
