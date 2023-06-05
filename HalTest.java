import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HalTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://forms.gle/eiiqRfHiRAiCXgPX7");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        String hdr_HomePage = "//div[text()='Ki Mock Platform — Take Home Exercise']";
        String rdio_MypendingQuotes = "//div[@data-value='See my pending quotes']";
        String rdio_CreateNewQuote = "//div[@data-value='Create a new quote']";
        String btn_Next = "//span[text()='Next']";
        String lst_MyPendingQuotes = "//form[contains(@data-response,'See my pending quotes')]//div[@role='listitem']//div[@jscontroller='RGrRJf']//div";
        
        String drpdwn_ChooseCountry ="//span[text()='Primary Country']//ancestor::div[@role='listitem']//span[text()='Choose']";
        String drpdwn_PrimaryInsured = "//span[text()='Primary Insured']//ancestor::div[@role='listitem']//span[text()='Choose']";
        String rdio_ClsOfBusiness = "//div[@data-value='Cyber']";
        String txt_DOB = "//input[@type='date']";
        String txt_AUMValue = "//span[text()='AUM Value ($)']/ancestor::div[@role='listitem']//input";
        String txt_Premium = "//span[text()='Premium ($)']//ancestor::div[@role='listitem']//input";
        
        
        
        //Pending Quote view
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hdr_HomePage)));
        System.out.println("User landed in Home page of Ki Mock Platform");
        
        if(!driver.findElement(By.xpath(rdio_MypendingQuotes)).isSelected()) {
        	System.out.println("User checked MyPendingQuotes checkbox is not checked");
        	driver.findElement(By.xpath(rdio_MypendingQuotes)).click();
        	
        } else {
        	System.out.println("By default MyPendingQuote check is checked");
        }
        
        driver.findElement(By.xpath(btn_Next)).click();
        List<WebElement> lst_PendingQuotes = driver.findElements(By.xpath(lst_MyPendingQuotes));
        System.out.println("Pending items are : ");
        for(int i = 0; i<lst_PendingQuotes.size(); i++) {
        	System.out.println(lst_PendingQuotes.get(i).getText());
        }
        
        
        //New Quote creation
        if(!driver.findElement(By.xpath(rdio_CreateNewQuote)).isSelected()) {
        	System.out.println("User checked CreateNewQuote checkbox is not checked");
        	driver.findElement(By.xpath(rdio_CreateNewQuote)).click();
        	
        } else {
        	System.out.println("By default CreateNewQuote check is checked");
        }
        
        Select sel_Country = new Select(driver.findElement(By.xpath(drpdwn_ChooseCountry)));
        sel_Country.selectByVisibleText("China");
        System.out.println("User selected the country as China");
        
        Select sel_PrimaryInsured = new Select(driver.findElement(By.xpath(drpdwn_PrimaryInsured)));
        sel_PrimaryInsured.selectByVisibleText("Service Tech Ltd");
        System.out.println("User selected the PrimaryInsured as Service Tech Ltd");
        
        if(!driver.findElement(By.xpath(rdio_ClsOfBusiness)).isSelected()) {
        	System.out.println("User checked ClsOfBusiness checkbox is not checked");
        	driver.findElement(By.xpath(rdio_ClsOfBusiness)).click();
        	
        } else {
        	System.out.println("User already selected the Class of Business");
        }
        
        driver.findElement(By.xpath(txt_DOB)).sendKeys("10/06/2023");
        driver.findElement(By.xpath(txt_AUMValue)).sendKeys("1234");
        driver.findElement(By.xpath(txt_Premium)).sendKeys("123");
        driver.findElement(By.xpath(btn_Next)).click();
        
        // Close the browser
        driver.quit();
    }
}
