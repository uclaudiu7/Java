package com.example.week6;

import java.io.Serializable;

public class SerializableLine implements Serializable {
    private SerializablePoint start;
    private SerializablePoint end;

    public SerializableLine(SerializablePoint start, SerializablePoint end){
        this.start = start;
        this.end = end;
    }

    public SerializablePoint getStart() {
        return start;
    }
    public SerializablePoint getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
