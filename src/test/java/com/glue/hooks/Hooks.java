package com.glue.hooks;

import org.apache.log4j.BasicConfigurator;
import utils.browserUtils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.fileUtils.Props;

public class Hooks {

    protected WebDriverWait wait;

    @Before
    public void startTest() {
        BasicConfigurator.configure();
        DriverFactory.setDriver(Props.getConfig("browser"));
        wait = new WebDriverWait(DriverFactory.getDriver(), 15);
    }

    @After
    public void finishTest() {
        //ToDo: screenshot on fail
        DriverFactory.getDriver().quit();
    }


}
