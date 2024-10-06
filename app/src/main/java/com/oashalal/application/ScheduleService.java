package com.oashalal.application;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * ScheduleService
 */
public class ScheduleService {
    
    private static List<String[]> list;

    private static void init() {
        list = new ArrayList<String[]>();
        list.add(new String[] {
            "разг. о важном",
            "литература",
            "ф - ра",
            "алгебра",
            "ОБЗР",
            "история",
            "обществознание"
        });
        list.add(new String[] {
            "химия",
            "ф - ра",
            "алгебра",
            "биология",
            "геометрия",
            "рус. яз.",
            "литература"
        });
        list.add(new String[] {
            "физика",
            "рус. яз.",
            "геометрия",
            "информатика",
            "англ. яз.",
            "алгебра",
            "инд. проект"
        });
        list.add(new String[] {
            "горизонты",
            "литература",
            "алгебра",
            "биология",
            "вероятность",
            "обществознание",
            "англ. яз."
        });
        list.add(new String[] {
            "физика",
            "биология",
            "англ. яз.",
            "геометрия",
            "ф - ра",
            "география",
            "история"
        });

    }

    public static int getDay() {
        LocalDateTime time = LocalDateTime.now();
        DayOfWeek dayOfWeek = time.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    public static String[] getSchedule(int day) {
        if (list == null) init();
        try {
            return list.get(day - 1);
        } catch (Exception ec) {
            return new String[] {"Ничего"};
        }
    }

    public static String getDayName(int day) {
        return DayOfWeek.of(day).getDisplayName(TextStyle.FULL, new Locale("ru"));
    }
}
