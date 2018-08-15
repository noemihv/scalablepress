import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
import org.junit.Test;

public class TaylorSwift {

	@Test
	public void test() {
			//Indicating where the webdriver is located
			String exePath = "/Users/noemi/Documents/workspace/SPtestingAutomation/libs/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			//Creating a new instance of the webdriver
		    WebDriver browser = new ChromeDriver();
		    
		    //FIRST ACTION: Navigate to wikipedia.org
		    browser.get("http://wikipedia.org");
		    assertEquals("Wikipedia",browser.getTitle() );
		    
		    //SECOND ACTION: Search for ‘Taylor Swift’
		    //Finding box 
		    WebElement header = browser.findElement(By.id("searchInput"));
		    //Writing "Taylor Swift" and enter
		    header.sendKeys("Taylor Swift");
		    header.sendKeys(Keys.RETURN);
		    assertEquals("Taylor Swift - Wikipedia",browser.getTitle() );
		    
		    //THIRD ACTION: Validate the ‘Studio albums’ contents and the bottom of the page under ‘ExternalLinks’.
		    //Checking if there is the bottom menu with the desired text
		    assertTrue(browser.findElement(By.className("navbox-group")).getText().equalsIgnoreCase("Studio Albums"));
		    //Checking the albums under that category
		    assertTrue(browser.findElement(By.cssSelector(".navbox-list.navbox-odd")).getText().equalsIgnoreCase("Taylor Swift Fearless Speak Now Red 1989 Reputation"));
		    
		    //FOURTH ACTION: Validate a hover message is displayed when the ‘Reputation’ link in the ‘Studioalbums’ section is moused over.
		    //Creating a simulation of mouse in order to pop-up the hover message and check its existence
		    WebElement reputationlink = browser.findElement(By.cssSelector(".navbox-list.navbox-odd")).findElement(By.linkText("Reputation"));
		    Actions action = new Actions(browser);
	        action.moveToElement(reputationlink).build().perform();
	        // Extract text from hover message and check that the text corresponds to the link
	        String hoverMsg = reputationlink.getText();
	        assertEquals("Reputation",hoverMsg);
        
	}
}



