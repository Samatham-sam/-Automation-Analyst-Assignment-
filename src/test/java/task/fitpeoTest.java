package task;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class fitpeoTest {

	@Test
	public void taskTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Navigate to FitPeo Homepage
		driver.get("https://fitpeo.com");

		// identifying to the Revenue Calculator Page
		driver.findElement(By.linkText("Revenue Calculator")).click();

		//JavascriptExecutor used for scrolling purpose
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		// identifying the slider text box
		WebElement sliderTextBox = driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input')]"));

		// sliding the range to 820
		String setSliderValue = "arguments[0].value='820'; arguments[0].dispatchEvent(new Event('input'));";
		jse.executeScript(setSliderValue, sliderTextBox);
		Thread.sleep(2000);

		//changing the slider range to 560
		String setSlider = "arguments[0].value='560'; arguments[0].dispatchEvent(new Event('input'));";
		jse.executeScript(setSlider, sliderTextBox);

		//identifying the check box CPT99091
		WebElement CPT99091 = driver.findElement(By.xpath("//span[text()='57']"));
		CPT99091.click();
		
		//identifying the check box CPT99091
		WebElement CPT99453 = driver.findElement(By.xpath("//span[text()='19.19']"));
		CPT99453.click();
		
		//identifying the check box CPT99091
		WebElement CPT99454 = driver.findElement(By.xpath("//span[text()='63']"));
		CPT99454.click();

		//identifying the check box CPT99091
		WebElement CPT99474 = driver.findElement(By.xpath("//span[text()='15']"));
		CPT99474.click();

		//identifying the totalReimbursementHeader
		String total = driver.findElement(By.xpath(
				"//div[@class=\"MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao\"]//descendant::p[@class=\"MuiTypography-root MuiTypography-body1 inter css-1bl0tdj\" and position()=8]"))
				.getText();
		System.out.println(total);
		
		// Validate the Total Recurring Reimbursement value
		Assert.assertEquals(total, "$27000");

		System.out.println("Test Passed Sucessfully");

	}
}
