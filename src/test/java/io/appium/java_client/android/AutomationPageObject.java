package io.appium.java_client.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;

public class AutomationPageObject {

    @FindBy(id = "rv_home_widget_recyclerview")
    private WebElement xmlObject;

    public AutomationPageObject(WebDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public Interaction clickXMLObject() {
        xmlObject.click();
        return null;
    }
}