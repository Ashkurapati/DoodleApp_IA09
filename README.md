#DoodleApp
A simple and intuitive doodling application with features like brush customization, zoom controls, animation, and color selection. Perfect for creative minds to sketch, draw, and animate their doodles with ease.
Features
. Brush Settings: Customize the thickness and type of the brush (Round or Square).
. Zoom Controls: Zoom in and out on the canvas for precise drawing.
. Color Selection: Choose your preferred color for doodling.
. Canvas Reset: Quickly clear the canvas to start fresh.
. Doodle Animation: Animate your doodles with fun effects like Bounce, Spin, or Grow.
. Responsive UI: User-friendly layout optimized for various devices.
How to Run the Program
Prerequisites
. Android Studio (latest version recommended)
. Android SDK and Java Development Kit (JDK)
. An Android emulator or a physical device for testing
Steps to Run
Clone the Repository:
git clone https://github.com/AshKurapati/doodling-app.git
Open in Android Studio:
Open Android Studio and select "Open an Existing Project".
Navigate to the cloned repository and select it.
Build the Project:
Let Android Studio sync and build the project. Ensure no dependency issues exist.
Run the Application:
Connect an Android device or start an emulator.
Click the Run button in Android Studio.
Explore the Features:
Use the buttons for brush settings, zoom controls, and animations to explore the app's functionalities.
Code Structure
. activity_main.xml: Defines the UI layout with buttons for brush, zoom, animation, and color selection.
. MainActivity.java: Handles button interactions and links the UI components with the canvas logic.
. DrawingCanvas.java: Implements the canvas functionality, including brush customization, drawing, and animation.
. PathStroke.java: Represents a single stroke on the canvas with properties like color and size.
References
This app was built using the following resources:
Android Developer Documentation - https://developer.android.com/docs
Paint and Canvas in Android - https://developer.android.com/reference/android/graphics/Paint
Motion and Object Animations in Android - https://developer.android.com/guide/topics/graphics/prop-animation
XML Layouts in Android - https://developer.android.com/guide/topics/ui/declaring-layout
License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it.
