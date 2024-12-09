package com.example.doodleapp_ia09;

import android.graphics.Path;

public class PathStroke {
    public int color;        // Color of the stroke
    public float size;       // Thickness of the stroke
    public Path path;        // Path representing the stroke

    public PathStroke(int color, float size) {
        this.color = color;
        this.size = size;
        this.path = new Path();  // Initialize a new Path
    }
}
