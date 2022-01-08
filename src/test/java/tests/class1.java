package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class class1 {
  @Test
  public void f() throws InterruptedException, IOException {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--headless");
	  WebDriver driver = new ChromeDriver(options);
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
      driver.get("https://www.google.com");
      
      Thread.sleep(5000);
      
      File srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      File destPath = new File("snap.png");
      FileHandler.copy(srcPath, destPath);
      
      driver.quit();
   }
}
