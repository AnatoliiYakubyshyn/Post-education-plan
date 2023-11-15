package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import com.solvd.gui.utils.ExtendedWebElement;

public class GoodPage extends AbstractMagentoPage {

    @FindBy(xpath = "//div[contains(@id,'color')]")
    private List<ExtendedWebElement> colors;

    @FindBy(xpath = "//div[contains(@id,'size')]")
    private List<ExtendedWebElement> sizes;

    @FindBy(xpath = "//button[contains(@id,'addtocart')]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "(//span[@class='swatch-attribute-selected-option'])[2]")
    private ExtendedWebElement titleColor;

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public String getSizeByIndex(int index) {
        return sizes.get(index).getText();
    }

    public String getCurrentColor() {
        return titleColor.getText();
    }

    public void chooseColor(int index) {
        colors.get(index).click();
    }

    public void chooseSize(int index) {
        sizes.get(index).click();
    }

    public void submit() {
        submitButton.click();
    }
}
