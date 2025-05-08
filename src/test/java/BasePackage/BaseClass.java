package BasePackage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  //Import class of Logger

public class BaseClass {

	public Logger logger;   //This is logger Log4j2 & it is predefined class of Logger created logger variable
	public WebDriver driver;
	public Properties p;
	public DesiredCapabilities capabilities;
//(groups= {"Sanity","Regression","Master"})
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{	
		//Loading Config.properties file.
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		//log4j configuration
		logger = LogManager.getLogger(this.getClass());  
		
		
		//remote execution
//		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			// os
//
//			if (os.equalsIgnoreCase("windows")) {
//				capabilities.setPlatform(Platform.WIN11);
//
//			} else if (os.equalsIgnoreCase("mac")) {
//				capabilities.setPlatform(Platform.MAC);
//			} else {
//				System.out.println("No Matchning operating system");
//				return;
//			}

			// browser
//
//			switch (br.toLowerCase()) {
//			case "chrome":
//				capabilities.setBrowserName("chrome");
//				break;
//			case "edge":
//				capabilities.setBrowserName("MicrosoftEdge");
//				break;
//			default:
//				System.out.println("No matching browser");
//				return;
//
//			}

			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		
		
		//Local browser
		//predefined class dynamic class add. this represent always class
		//By this logger variable we can generate the logs.
		
		
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Inavlid browser");
				return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		// Reading URL From the Property files

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
//(groups = { "Sanity", "Regression", "Master" })
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() // For Random Email generation
	{
		String generateString = RandomStringUtils.randomAlphabetic(4);
		return generateString;
	}

	public String randomNumber() // For Random Mobile number generation
	{
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomAlphaNumeric() // For random Password Creation
	{
		String generateString = RandomStringUtils.randomAlphabetic(3);
		String generateNumber = RandomStringUtils.randomNumeric(4);
		return (generateString + "@" + generateNumber);
	}

}
