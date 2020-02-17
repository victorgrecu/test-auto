package com.worldpay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleSearchPage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath ="//*[@id=\"rso\"]/div/div/div/div/div/div[1]/a/h3")
    private List<WebElement> results;

    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public List<String> searchAfterKeyword(String keyword){
        searchBox.sendKeys(keyword);
        searchBox.submit();
        List<String> titles = new ArrayList<>();
        results.forEach(element-> titles.add(element.getText()));
        titles.forEach(System.out::println);
        return titles;
    }

}
