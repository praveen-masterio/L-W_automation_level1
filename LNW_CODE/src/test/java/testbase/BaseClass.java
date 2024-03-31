package testbase;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public WebDriver driver;
public ResourceBundle properties;

public Logger log;

@BeforeClass
public void setUp() throws InterruptedException {
log = LogManager.getLogger(this.getClass());
properties = ResourceBundle.getBundle("config");

if (properties.getString("browser1").equalsIgnoreCase("chrome")) {

System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
driver = new ChromeDriver();
} else if (properties.getString("browser2").equalsIgnoreCase("edge")) {
System.setProperty("webdriver.edge.driver", properties.getString("edgeDriverPath"));
driver = new EdgeDriver();
}

driver.get(properties.getString("url"));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5000, TimeUnit.NANOSECONDS);

}

public void captureScreenshot(String tName) throws IOException {

TakesScreenshot screenshot = (TakesScreenshot) driver;
File source = screenshot.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir") + "/screenshots/" + tName + ".png");
FileUtils.copyFile(source, target);

}

@AfterClass
public void tearDown() {

driver.quit();
}
}
