package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	
	WebDriver driver = null;

	@Given("user browser is open")
	public void user_browser_is_open() {
		System.out.println("Inside Step - user browser is open");
		System.out.println("Inside Step - browser is open");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("Inside Step - user enters username and password");
		driver.findElement(By.cssSelector("input#name")).sendKeys("EarlHans");
		driver.findElement(By.cssSelector("input#password")).sendKeys("12345");
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside Step - click on login button");
		driver.findElement(By.cssSelector("button#login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside Step - user is navigate to homepage");
		driver.findElement(By.cssSelector("button#logout")).isDisplayed();
		driver.close();
		driver.quit();
	}
}
