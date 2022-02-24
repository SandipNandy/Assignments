import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Autocomplete drop down assignment
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Uni");
		List<WebElement> Allsuggestions=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']/div"));
		boolean found=false;
		String countryName="United Kingdom (UK)";
		for(WebElement suggestion:Allsuggestions)
		{
		    if(countryName.equals(suggestion.getText()))
		    {
		        found=true;
		        break;
		    }
		}
		if(found)
		    System.out.println("Country Name : "+countryName+", exists");
		else
		    System.out.println("Country Name : "+countryName+", does notexists");
		
		SelectCountry(driver,countryName);
		driver.quit();
	}
    static void SelectCountry(WebDriver driver, String country) {
		WebElement CountryName= driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']/div[contains(text(),'"+country+"')]"));
		Actions action= new Actions(driver);
		action.moveToElement(CountryName).click().build().perform();
	}

}
