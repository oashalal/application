package com.oashalal.application;

import java.time.LocalTime;

/**
 * Lesson
 */
public class Lesson {

    public final LocalTime start;
    public final LocalTime end;
    public final int index;

    public Lesson(int index, LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
