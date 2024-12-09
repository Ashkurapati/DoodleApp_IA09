package com.example.doodleapp_ia09;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingCanvas extends View {
    private Paint brush;
    private ArrayList<PathStroke> strokes;
    private PathStroke currentStroke;
    private float scaleFactor = 1.0f;
    public static final int BRUSH_ROUND = 0;
    public static final int BRUSH_SQUARE = 1;
    private int currentBrushType = BRUSH_ROUND;

    public DrawingCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        brush = new Paint();
        brush.setColor(0xFF000000);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeWidth(10);
        strokes = new ArrayList<>();
    }

    public void setBrushSize(float size) {
        brush.setStrokeWidth(size);
    }

    public void setBrushColor(int color) {
        brush.setColor(color);
    }

    public void clearCanvas() {
        strokes.clear();
        invalidate();
    }

    public void zoomCanvas(float factor) {
        scaleFactor *= factor;
        invalidate();
    }

    public void setBrushType(int brushType) {
        currentBrushType = brushType;
    }

    public void animateDoodles(String animationType, long duration) {
        for (PathStroke stroke : strokes) {
            ObjectAnimator animator;
            switch (animationType) {
                case "Bounce":
                    animator = ObjectAnimator.ofFloat(this, "translationY", 0, 50, -50, 0);
                    break;
                case "Spin":
                    animator = ObjectAnimator.ofFloat(this, "rotation", 0, 360);
                    break;
                case "Grow":
                    animator = ObjectAnimator.ofFloat(this, "scaleX", 1f, 2f, 1f);
                    break;
                default:
                    return;
            }
            animator.setDuration(duration);
            animator.setRepeatCount(ObjectAnimator.INFINITE);
            animator.start();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.scale(scaleFactor, scaleFactor);

        for (PathStroke stroke : strokes) {
            brush.setColor(stroke.color);
            brush.setStrokeWidth(stroke.size);
            brush.setStrokeCap(currentBrushType == BRUSH_ROUND ? Paint.Cap.ROUND : Paint.Cap.SQUARE);
            canvas.drawPath(stroke.path, brush);
        }

        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentStroke = new PathStroke(brush.getColor(), brush.getStrokeWidth());
                currentStroke.path.moveTo(event.getX(), event.getY());
                strokes.add(currentStroke);
                return true;
            case MotionEvent.ACTION_MOVE:
                currentStroke.path.lineTo(event.getX(), event.getY());
                invalidate();
                return true;
            default:
                return false;
        }
    }
}
