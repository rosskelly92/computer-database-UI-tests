package com.glue.hooks;

import cucumber.api.Scenario;
import org.apache.log4j.BasicConfigurator;
import utils.browserUtils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.fileUtils.Props;
import utils.fileUtils.Screenshots;

public class Hooks {

    protected WebDriverWait wait;

    @Before
    public void startTest() {
        BasicConfigurator.configure();
        DriverFactory.setDriver(Props.getConfig("browser"));
        wait = new WebDriverWait(DriverFactory.getDriver(), 15);
    }

    @After
    public void finishTest(Scenario scenario) {
        if (scenario.isFailed()) Screenshots.takeShot(scenario.getName());
        if (DriverFactory.getDriver()!=null) DriverFactory.getDriver().quit();
    }


}
