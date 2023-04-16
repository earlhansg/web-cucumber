package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Before
	public void browserSetup() {
		System.out.println("I'm inside browserSetup");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		System.out.println("I'm inside teardown");
		driver.close();
		driver.quit();
	}
	
	@Given("user browser is open")
	public void user_browser_is_open() {
		System.out.println("Inside Step - user browser is open");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		System.out.println("Console" + username + password);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input#name")).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("Inside Step - click on login button");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button#login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is navigate to homepage");
		Thread.sleep(5000);
		Boolean logoutElement = driver.findElement(By.cssSelector("button#logout")).isDisplayed();
		assertEquals(true, logoutElement);
	}
}
