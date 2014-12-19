package net.pingworks.example.musicDB.ui;


import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UITest {
	@Test
    public void main() {
        WebDriver driver = new FirefoxDriver();

        driver.get(System.getProperty("UITESTURL"));
        
        WebElement title = driver.findElement(By.xpath("/html/body/div[1]/div/span"));
        Assert.assertEquals("Simple PrimeFaces Music DB", title.getText());
        
        WebElement artist = driver.findElement(By.cssSelector("tr.ui-widget-content:nth-child(5) > td:nth-child(1)"));
        Assert.assertTrue(artist.getText().indexOf("Moloko") >= 0);
        
        WebElement deleteLink = driver.findElement(By.cssSelector("tr.ui-widget-content:nth-child(5) > td:nth-child(3) > a"));
        deleteLink.click();
        
        long end = System.currentTimeMillis() + 5000;
        WebElement message = null;
        while (System.currentTimeMillis() < end) {
        	try {
                message = driver.findElement(By.className("ui-messages-info-summary"));
                if (message.isDisplayed()) {
                    break;
                  }
			} catch (Exception e) {
			}
        }
        
        Assert.assertNotNull(message);
        Assert.assertEquals("Album deleted: Artist: Moloko, Title: Things to make and do", message.getText());

        driver.quit();
    }
}