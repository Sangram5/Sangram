package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dicom_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public Dicom_Base() throws IOException 
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\sangram.patil\\Desktop\\DICOM\\Dicom.property");
			prop.load(fis);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public void Initilization() 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disabel-notifications");
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
				
		wait =new WebDriverWait(driver, 360);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(prop.getProperty("U_Name"));
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("psw"));
		
		driver.findElement(By.xpath("//span[contains(text(),'Sign In ')]")).click();
		
	}
	
	public  void failed(String testMethoName) throws InterruptedException, IOException 
	{
		Thread.sleep(2000);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file, new File("./Dicom_Fail-Test-Cases/"+"Failed Test Cases  "+testMethoName+"_"+".png"));
	}
	public void pass(String testMethoName) throws IOException, InterruptedException 
	{
		Thread.sleep(2000);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file, new File("./DICOM_Pass-Test-Cases/"+"Pass Test Cases "+testMethoName+"_"+".png"));
	}
	
	
  
}
