package com.example.doodleapp_ia09;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingCanvas drawingCanvas;
    private Button btnResetCanvas, btnBrushThickness,btnChooseColor, btnZoomIn, btnZoomOut, btnAnimateDoodle;
    private Button btnBrushTypeRound, btnBrushTypeSquare;
    private LinearLayout brushSettingsPanel, canvasSettingsPanel, colorSettingsPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI components
        drawingCanvas = findViewById(R.id.drawingCanvas);
        colorSettingsPanel = findViewById(R.id.colorSettingsPanel);
        brushSettingsPanel = findViewById(R.id.brushSettingsPanel);
        canvasSettingsPanel = findViewById(R.id.canvasSettingsPanel);
        // Reset Canvas Button
        btnResetCanvas = findViewById(R.id.btnResetCanvas);
        btnResetCanvas.setBackgroundColor(Color.parseColor("#FF5722")); // Orange color
        btnResetCanvas.setOnClickListener(view -> drawingCanvas.clearCanvas());

        // Brush Thickness Button
        btnBrushThickness = findViewById(R.id.btnBrushThickness);
        btnBrushThickness.setBackgroundColor(Color.parseColor("#4CAF50")); // Green color
        btnBrushThickness.setOnClickListener(view -> drawingCanvas.setBrushSize(30));

        // Choose Color Button
        btnChooseColor = findViewById(R.id.btnChooseColor);
        btnChooseColor.setBackgroundColor(Color.parseColor("#2196F3")); // Blue color
        btnChooseColor.setOnClickListener(view -> drawingCanvas.setBrushColor(Color.RED));

        // Zoom In Button
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomIn.setBackgroundColor(Color.parseColor("#8BC34A")); // Lime color
        btnZoomIn.setOnClickListener(view -> drawingCanvas.zoomCanvas(1.2f)); // Zoom in by 20%

        // Zoom Out Button
        btnZoomOut = findViewById(R.id.btnZoomOut);
        btnZoomOut.setBackgroundColor(Color.parseColor("#FFC107")); // Amber color
        btnZoomOut.setOnClickListener(view -> drawingCanvas.zoomCanvas(0.8f)); // Zoom out by 20%

        // Brush Type: Round Button
        btnBrushTypeRound = findViewById(R.id.btnBrushTypeRound);
        btnBrushTypeRound.setBackgroundColor(Color.parseColor("#9C27B0")); // Purple color
        btnBrushTypeRound.setOnClickListener(view -> drawingCanvas.setBrushType(DrawingCanvas.BRUSH_ROUND));

        // Brush Type: Square Button
        btnBrushTypeSquare = findViewById(R.id.btnBrushTypeSquare);
        btnBrushTypeSquare.setBackgroundColor(Color.parseColor("#FF9800")); // Orange color
        btnBrushTypeSquare.setOnClickListener(view -> drawingCanvas.setBrushType(DrawingCanvas.BRUSH_SQUARE));
        // Animate Doodle button action
        btnAnimateDoodle = findViewById(R.id.btnAnimateDoodle);
        btnAnimateDoodle.setOnClickListener(view -> drawingCanvas.animateDoodles("Bounce", 2000));
    }
}
