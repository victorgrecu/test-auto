package com.worldpay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.worldpay")
public class TestContext {

    @Bean(destroyMethod="quit")
    public WebDriver initWebDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}
