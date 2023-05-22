package io.appium.java_client.pagefactory;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines set of chained/possible locators. Each one locator
 * should be defined with {@link io.appium.java_client.pagefactory.iOSXCUITFindAll}
 */
@Target(value = {TYPE, FIELD})
@Retention(value = RUNTIME)
public @interface iOSXCUITFindByAllSet {
    /**
     * An array of which builds a sequence of the chained searching for elements or a set of possible locators.
     *
     * @return an array of {@link io.appium.java_client.pagefactory.iOSXCUITFindAll} which builds a sequence of
     *     the chained searching for elements or a set of possible locators
     */
    iOSXCUITFindAll[] value();
}
