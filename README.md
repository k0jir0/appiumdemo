# appiumdemo

https://github.com/k0jir0/appiumdemo/tree/master is the repo branch containing the VSC project build.

Setup: https://www.swtestacademy.com/how-to-install-appium-on-mac/
- It is recommended for one to configure their environment according to the setup guide above.

Assignment: https://github.com/TouchTunes/mobile-qa-tech-assignment

# To whom it may concern,
https://github.com/k0jir0/appiumdemo/blob/master/src/test/java/io/appium/java_client/android/AutomationTest.java

AutomationTest.java when ran in VSC, with the environment configured, after inputting the command sequence, will launch the test app and navigate to inside of a jukebox.

Note: Navigating and parsing the object model appears to be restricted due to application access errors, it seems accessibility is limited in the distributed APK, the accessibility of many objects is set to No when inspected in Android Studio. One would not be able to parse the recyclerview carousel of artists for their information on two views and contrast them. Should findBy element id function in a working environment, I have left behind commented code that could be transposed in theory if the objects can be properly acessed. The furthest navigation automated was getting into a specific Jukebox of a specific venue.

# Appium model

![346098021_6223524384398274_2251237371444926198_n (1)](https://github.com/k0jir0/appiumdemo/assets/27692767/31678007-affb-4d02-8884-e7a54ddb2f5f)

# About AutomationTest.java

The provided code is a Java program that includes various dependencies and classes for automating tests using Appium and Selenium WebDriver. The program consists of a main class called AutomationTest and several supporting functions.

The program starts with importing required packages and classes from different libraries, such as io.appium.java_client and org.openqa.selenium. These libraries provide the necessary tools and methods for interacting with Android devices and performing automated tests.

Next, the main class AutomationTest defines a main method that serves as the entry point for the program. It presents a command-line interface (CLI) menu to the user, allowing them to choose different functions to execute. The user can select options like configuring capabilities, starting and stopping the Appium server, running test functions, logging messages, and quitting the program.

The supporting functions in the AutomationTest class correspond to the menu options:

configureCapabilities(): This function sets up the desired capabilities for the Android device and the test build, such as the platform name, device name, app location, and permissions.

startAppiumServer(): This function starts the Appium server by executing the appropriate command using the provided paths to the node and appium executables. It waits for the server to start and checks if it started successfully.

executeAppiumTest(): This function demonstrates a test scenario using Appium. It configures the desired capabilities, creates an instance of the AndroidDriver, and performs a series of actions on the Android device, including touch interactions and pointer movements.

stopAppiumServer(): This function stops the Appium server by sending a POST request to the server's shutdown endpoint.

loggerMessage(): This function demonstrates logging messages using the SLF4J (Simple Logging Facade for Java) logger. It logs an info message and an error message and prints a statement indicating that the logger function was called.

The remaining functions (function2, function3, function4, function5, function6, function7, function8) are responsible for executing the respective menu options and calling the corresponding supporting functions.

Overall, this code provides a basic framework for performing automation testing on Android devices using Appium and Selenium WebDriver. The menu-based interface allows users to configure capabilities, start and stop the Appium server, run test functions, and perform logging operations.

# Run

Running requires the environment configuration:
- JDK 8 is intended for compatibility reasons. 
- $JAVA_HOME must be configured.
- $ANDROID_HOME must be configured.
- Android Studio is running with an emulated device running.
- Appium Server GUI is running and listening on default values.
- LayoutInspector can be prepared to inspect the Android application.
- All Terminal configurations listed in https://www.swtestacademy.com/how-to-install-appium-on-mac/ are configured.

Steps:
1. Clone the build off the repo to your drive
2. Have configured your environment according to the project as described within this project.
3. Inside of VSC, navigate to src/test/java/io/appium/java_client/android/AutomationTest.java and select it to be ran.
4. Read the two notes below before proceeding to Step 5.
5. Press F5 (MacOS) to run.
6. When the Java application runs in the embedded Terminal with a lightweight CLI, input 1 to load your device and build paths. 
7. Input 2 to start the Appium server.
8. Input 3 to run the automation script.

Note: The path of the build inside of function configureCapabilities() in src/main/test/java/android/AutomationTest.java must be re-configured to point to the new path of your environment after downloading. the build is contained in the project in a folder called build.

Note: The name of the device inside of function configureCapabilities() in src/main/test/java/android/AutomationTest.java must be re-configured to point to the unique identifier of your emulated Android Device. 

# Project Specifications:
- MacOS 12.6.2 Monterey
- Java JDK 8
- Android Studio Flamingo
- Homebrew 4.0.18
- Node.js v20.2.0
- npm 9.6.6
- appium 1.22.3
- carthage 0.39.0
- Appium Server GUI 1.20.2
- maven 3.9.2
- Xcode 14.2
- GPS coordinates: 45.5017, -73.5673

# Visual Studio Code Details
- Version: 1.78.2 (Universal)
- OS: Darwin x64 21.6.0

# appium-doctor
- ryanwatkins@Ryans-MBP build % appium-doctor
- info AppiumDoctor Appium Doctor v.1.16.2
- info AppiumDoctor ### Diagnostic for necessary dependencies starting ###
- info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
- info AppiumDoctor  ✔ Node version is 20.2.0
- info AppiumDoctor  ✔ Xcode is installed at: /Applications/Xcode.app/Contents/Developer
- info AppiumDoctor  ✔ Xcode Command Line Tools are installed in: /Applications/Xcode.app/Contents/Developer
- info AppiumDoctor  ✔ DevToolsSecurity is enabled.
- info AppiumDoctor  ✔ The Authorization DB is set up properly.
- info AppiumDoctor  ✔ Carthage was found at: /usr/local/bin/carthage. Installed version is: 0.39.0
- info AppiumDoctor  ✔ HOME is set to: /Users/ryanwatkins
- info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/ryanwatkins/Library/Android/sdk
- info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home
- info AppiumDoctor    Checking adb, android, emulator, apkanalyzer
- info AppiumDoctor      'adb' is in /Users/ryanwatkins/Library/Android/sdk/platform-tools/adb
- info AppiumDoctor      'android' is in /Users/ryanwatkins/Library/Android/sdk/tools/android
- info AppiumDoctor      'emulator' is in /Users/ryanwatkins/Library/Android/sdk/emulator/emulator
- info AppiumDoctor      'apkanalyzer' is in /Users/ryanwatkins/Library/Android/sdk/tools/bin/apkanalyzer
- info AppiumDoctor  ✔ adb, android, emulator, apkanalyzer exist: /Users/ryanwatkins/Library/Android/sdk
- info AppiumDoctor  ✔ 'bin' subfolder exists under '/Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home'
