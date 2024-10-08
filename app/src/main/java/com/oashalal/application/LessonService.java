package com.oashalal.application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * LessonService
 */
public class LessonService {

    private static List<Lesson> lessons;

    static {
        lessons = new ArrayList<Lesson>();
        lessons.add(new Lesson(1, LocalTime.of(8, 30), LocalTime.of(9, 10)));
        lessons.add(new Lesson(2, LocalTime.of(9, 20), LocalTime.of(10, 0)));
        lessons.add(new Lesson(3, LocalTime.of(10, 15), LocalTime.of(10, 55)));
        lessons.add(new Lesson(4, LocalTime.of(11, 15), LocalTime.of(11, 55)));
        lessons.add(new Lesson(5, LocalTime.of(12, 5), LocalTime.of(12, 45)));
        lessons.add(new Lesson(6, LocalTime.of(12, 55), LocalTime.of(13, 35)));
        lessons.add(new Lesson(7, LocalTime.of(13, 40), LocalTime.of(14, 20)));
    }

    public static Lesson getCurrentLesson() {
        LocalTime now = LocalTime.now();

        for (Lesson lesson : lessons) {
            if (now.isAfter(lesson.start) && now.isBefore(lesson.end))
                return lesson;
        }
        return null;
    }

    public static Lesson getNextLesson() {
        LocalTime now = LocalTime.now();

        if (now.isAfter(lessons.get(6).end) && now.isBefore(lessons.get(0).start)) {
            return lessons.get(0);
        }

        for (int i = 1; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            if (now.isBefore(lesson.start) && now.isAfter(lessons.get(i - 1).end)) {
                return lesson;
            }
        }
        return null;
    }
}
