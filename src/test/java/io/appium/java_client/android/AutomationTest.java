package io.appium.java_client.android;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.Pause;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsLocation;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutomationTest {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("======= CLI Functions =======");
            System.out.println("Note: Run 1, 2, 3 as intended order");
            System.out.println("1. Configure Capabilities to Target Device and Build");
            System.out.println("2. Start Appium Server");
            System.out.println("3. Run Test Function Alpha");
            System.out.println("4. Stop Appium Server");
            System.out.println("5. Run Logger Function");
            System.out.println("6. Placeholder Function Test Beta");
            System.out.println("7. Placeholder Function 7");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    function1();
                    break;
                case 2:
                    function2();
                    break;
                case 3:
                    function3();
                    break;
                case 4:
                    function4();
                    break;
                case 5:
                    function5();
                    break;
                case 6:
                    function6();
                    break;
                case 7:
                    function7();
                    break;
                case 8:
                    function8();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 8);

        scanner.close();
    }

    public static void function1() {
        System.out.println("Executing Configure Capabilities...");

        configureCapabilities();
    }

    public static void function2() {
        System.out.println("Executing Start Appium Server...");

        startAppiumServer();
    }

    public static void function3() {
        System.out.println("Executing Test Function Alpha...");
            executeAppiumTest();

    }

    public static void function4() {
        System.out.println("Executing Stop Appium Server Function...");
        stopAppiumServer();
    }
    
    public static void function5() {
        System.out.println("Executing Logger...");
        loggerMessage();
    }

    public static void function6() {
        System.out.println("Executing Appium Test Beta...");
        executeAppiumTestBeta();
    }

    public static void function7() {
        System.out.println("Executing Function 7...");
    }

    public static void function8() {
        System.out.println("Executing Quit...");
        // Add code here if needed before quitting
    }

    final static Logger logger = LoggerFactory.getLogger(AutomationTest.class);

    public static void loggerMessage() {
        logger.info("This is an info log message");
        logger.error("This is an error log message");
        System.out.println("Logger function called");
        // ... other log statements
    }

    public static DesiredCapabilities configureCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_33_x86_64");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("app", "/Users/ryanwatkins/Desktop/AppiumProject/java-client-master-delta/build/TouchTunes_ Live Bar JukeBox_3.37.2--34608_Apkpure.apk");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability("locationServicesEnabled", true);
        capabilities.setCapability("locationServicesAuthorized", true);
        
        return capabilities;
    }

    public static void startAppiumServer() {
        // Set the path to the node and appium executables
        String nodePath = "/usr/local/bin/node";
        String appiumPath = "/usr/local/bin/appium";
    
        // Set the command to start the Appium server
        String command = String.format("%s %s", nodePath, appiumPath);
    
        try {
            // Start the Appium server
            Process process = Runtime.getRuntime().exec(command);
    
            // Wait for the server to start (optional)
            Thread.sleep(5000);
    
            // Check if the server started successfully
            if (isAppiumServerRunning()) {
                System.out.println("Appium server started successfully.");
            } else {
                System.out.println("Failed to start the Appium server.");
            }
        } catch (IOException e) {
            System.out.println("Failed to execute the Appium server start command.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for the Appium server to start.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while starting the Appium server.");
            e.printStackTrace();
        }
    }

    private static boolean isAppiumServerRunning() {
        try {
        // Set the URL of the Appium server
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub/status");

        // Send a GET request to the server to check its status
        HttpURLConnection connection = (HttpURLConnection) appiumServerUrl.openConnection();
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Return true if the response code is 200 (OK)
        return responseCode == HttpURLConnection.HTTP_OK;
            } catch (MalformedURLException e) {
            System.out.println("Invalid Appium server URL. Make sure the URL is correct.");
            e.printStackTrace();
            } catch (IOException e) {
            System.out.println("Failed to connect to the Appium server. Check if the server is running.");
            e.printStackTrace();
            } catch (Exception e) {
            System.out.println("An error occurred while checking the Appium server status.");
            e.printStackTrace();
        }
    // If an exception occurs, return false
    return false;
    }

    public static void stopAppiumServer() {
    try {
        // Set the URL of the Appium server's shutdown endpoint
        URL appiumServerUrl = new URL("http://localhost:4723/shutdown");

        // Send a POST request to the server's shutdown endpoint
        HttpURLConnection connection = (HttpURLConnection) appiumServerUrl.openConnection();
        connection.setRequestMethod("POST");

        // Get the response code
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Appium server stopped successfully.");
        } else {
            System.out.println("Failed to stop the Appium server. Response Code: " + responseCode);
        }
    } catch (MalformedURLException e) {
        System.out.println("Invalid Appium server URL. Make sure the URL is correct.");
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println("Failed to connect to the Appium server. Check if the server is running.");
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("An error occurred while stopping the Appium server.");
        e.printStackTrace();
    }
    }

    public static void executeAppiumTest() {
        System.out.println("Executing Function: Appium Test...");

        // Configure desired capabilities
        DesiredCapabilities capabilities = configureCapabilities();
        
        // Create an instance of AndroidDriver
        WebDriver driver = null;

        try {
            // Create the WebDriver instance
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

            System.out.println("Waiting to let the device establish ...");
            Thread.sleep(25000);
            System.out.println("Finished waiting ...");

            try {
            // Implementing by DPI
            System.out.println("Configuring DPI ...");

            // Initialize pointer
            PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(pointer, 0);

            // Move pointer to initial position
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), 100, 100));

            // Perform click action at initial position
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(8)));
            sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(10)));

            // Coordinate next click
            int x = 305; // X coordinate in dp
            int y = 24; // Y coordinate in dp

            // Convert dp to pixels based on the device's density
            int xInPixels = (int) (x * (driver.manage().window().getSize().getWidth() / 360.0));
            int yInPixels = (int) (y * (driver.manage().window().getSize().getHeight() / 640.0));

            // Perform the click action at the specified coordinates
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), xInPixels, yInPixels));
            sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Wait for 20 seconds
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(20)));

            // Coordinate next click
            int x2 = 1; // X coordinate in dp
            int y2 = 331; // Y coordinate in dp

            // Convert dp to pixels based on the device's density
            int xInPixels2 = (int) (x2 * (driver.manage().window().getSize().getWidth() / 360.0));
            int yInPixels2 = (int) (y2 * (driver.manage().window().getSize().getHeight() / 640.0));

            // Perform the click action at the specified coordinates
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(8)));
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), xInPixels2, yInPixels2));
            sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(20)));
            
            // Wait for 10 seconds
            Thread.sleep(10000);
            
            //Section 3: after entering the Jukebox
            // Define the starting and ending points for pointer movement
            int startX = 100;
            int startY = 100;
            int endX = 1000; 
            int endY = 1800;

            // Convert pixel values to dp
            int startXInPixels = (int) (startX * (driver.manage().window().getSize().getWidth() / 360.0));
            int startYInPixels = (int) (startY * (driver.manage().window().getSize().getHeight() / 640.0));
            int endXInPixels = (int) (endX * (driver.manage().window().getSize().getWidth() / 360.0));
            int endYInPixels = (int) (endY * (driver.manage().window().getSize().getHeight() / 640.0));

            // Create a pointer move action
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startXInPixels, startYInPixels));
            sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(3))); //long press
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endXInPixels, endYInPixels));
            sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(10)));

            // Perform the click action at the specified coordinates
            sequence.addAction(pointer.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), 100, 1400));
            sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            /* Theory
            // Wait until the RecyclerView element is visible
            WebElement recyclerView = null;
            int maxAttempts = 10;
            int attempt = 0;
            while (recyclerView == null && attempt < maxAttempts) {
            try {
                recyclerView = (WebElement) driver.findElement(By.id("rv_home_widget_recyclerview"));
            } catch (Exception e) {
                // RecyclerView not found, wait and try again
                Thread.sleep(1000); // Sleep for 1 second
                attempt++;
            }
            }
            */
            
            //findElement calls throw exceptions
            //sequence.addAction(driver.findElement(By.className("androidx.appcompat.widget.AppCompatTextView")));
            //sequence.addAction(driver.findElement(By.id("rv_home_widget_recyclerview")));
            //sequence.addAction(driver.findElement(By.id("widget_item_round_title")));
            sequence.addAction(new Pause(pointer, Duration.ofSeconds(15)));

            /* Theory
            //WebElement recyclerView = driver.findElement(By.id("rv_home_widget_recyclerview"));
            List<WebElement> items = recyclerView.findElements(By.id("widget_item_round_title"));

            for (WebElement item : items) {
                // Extract information from each item
                WebElement titleElement = item.findElement(By.id("widget_item_round_title"));
                String title = titleElement.getText();
                
                // Extract information from the title widget inside the loop
                WebElement widgetItemRoundTitle = item.findElement(By.id("widget_item_round_title"));
                String widgetTitle = widgetItemRoundTitle.getText();

                System.out.println("Number of elements found: " + items.size());
            
                // Process the extracted information as needed
                System.out.println("Title: " + title);
                System.out.println("Widget Title: " + widgetTitle);
            }
            */

            System.out.println("Driver performing sequence ...");
            ((RemoteWebDriver) driver).perform(Arrays.asList(sequence));
            System.out.println("Finished performing sequence ...");

            // Wait for 5 seconds
            Thread.sleep(5000);
            System.out.println("5 second wait ...");
            
            // Find the element by its ID and print if accessed by findElement
            //WebElement textViewElement = (WebElement) driver.findElement(By.className("androidx.appcompat.widget.AppCompatTextView"));
            //String text = textViewElement.getText();
            //System.out.println("Text: " + text);

            // Wait for 5 seconds
            Thread.sleep(5000);
            System.out.println("5 second wait ...");

            } catch (Exception e) {
                System.out.println("Exception Thrown");
                e.printStackTrace();
            }

            if (driver != null) {
                System.out.println("Closing the driver");
                driver.quit();
            }

        } catch (MalformedURLException e) {
            System.out.println("Invalid Appium server URL. Make sure the URL is correct.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting.");
            e.printStackTrace();
        } finally {
            // Quit the driver and close the session
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void executeAppiumTestBeta(){
        //Function call for a new test
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}