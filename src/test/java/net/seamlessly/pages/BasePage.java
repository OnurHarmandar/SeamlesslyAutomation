package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){PageFactory.initElements(Driver.get(),this);}


}
