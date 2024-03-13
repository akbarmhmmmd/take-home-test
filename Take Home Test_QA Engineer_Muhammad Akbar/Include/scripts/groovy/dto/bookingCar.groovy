package dto
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType
import java.time.LocalDateTime
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

public class bookingCar {

	public void rentCar() {

		WebDriver driver = DriverFactory.getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebUI.openBrowser('carRent.com');
		WebUI.maximizeWindow();
		boolean verifyHomePage = WebUI.verifyTextPresent('Car Rent', false);

		if (verifyHomePage) {
			WebElement carsProductButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Cars Product')]")));
			carsProductButton.click();
			System.out.println("Select Cars Product - PASSED");
		} else {
			System.out.println("Select Cars Product - FAILED");
		}

		boolean verifyWithoutDriverTab = WebUI.verifyTextPresent('Without Driver', false);

		if (verifyWithoutDriverTab) {
			WebElement withoutDriverButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Without Driver')]")));
			withoutDriverButton.click();
			System.out.println("Select Without Product - PASSED");
		} else {
			System.out.println("Select Without Product - FAILED");
		}

        WebElement pickupLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickupLocation")));
		Select pickupLocationDropdown = new Select(pickupLocation);
		pickupLocationDropdown.selectByVisibleText("Jakarta");
		WebElement selectedOption = pickupLocationDropdown.getFirstSelectedOption();
		String pickupLocationData = selectedOption.getText();

		if (pickupLocationData != null) {
			System.out.println("Select Pick-up Location - PASSED");
		} else {
			System.out.println("Select Pick-up Location - FAILED");
		}

        WebElement pickUpDateTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pick-up-date-time-input")));
		pickUpDateTime.clear();
		pickUpDateTime.sendKeys("2024-02-24 09:00");
		String pickupDateTimeData = pickUpDateTime.getAttribute("value");

		if (pickupDateTimeData != null) {
			System.out.println("Select Pick-up Date & Time - PASSED");
		} else {
			System.out.println("Select Pick-up Date & Time - FAILED");
		}

        WebElement dropOffDateTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drop-off-date-time-input")));
		dropOffDateTime.clear();
		dropOffDateTime.sendKeys("2024-02-28 11:00");
		String dropOffDateTimeData = dropOffDateTime.getAttribute("value");

		if (dropOffDateTimeData != null) {
			System.out.println("Select Drop-off Date & Time - PASSED");
		} else {
			System.out.println("Select Drop-off Date & Time - FAILED");
		}

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Search')]")));
		search.click();
		boolean verifySearchResult = WebUI.verifyTextPresent('result', false);

		if (verifySearchResult) {
			System.out.println("Click button Search Car - PASSED");
		} else {
			System.out.println("Click button Search Car - FAILED");
		}

        WebElement car = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'IONIQ 6')]")));
		car.click();
        WebElement carProvider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Hyundai')]")));
		carProvider.click();
		boolean verifyProductDetail = WebUI.verifyTextPresent('Product Detail', false);

		if (verifyProductDetail) {
			System.out.println("Select Car & Car Provider - PASSED");
		} else {
			System.out.println("Select Car & Car Provider - FAILED");
		}
		
		String continueXpath = "//button[contains(text(), 'Continue')]";
		
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueXpath)));
		continueButton.click();

		WebElement carPickupLocation = wait.until(ExpectedConditions.elementToBeClickable(By.id("carPickupLocation")));
		Select carPickupLocationDropdown = new Select(carPickupLocation);
		carPickupLocationDropdown.selectByVisibleText("Rental Office");
		WebElement selectedCarPickupLocation = carPickupLocationDropdown.getFirstSelectedOption();
		String carPickupLocationData = selectedCarPickupLocation.getText();

		if (carPickupLocationData != null) {
			System.out.println("Select Pick-up Location in Rental Office - PASSED");
		} else {
			System.out.println("Select Pick-up Location in Rental Office - FAILED");
		}

		WebElement carDropoffLocation = wait.until(ExpectedConditions.elementToBeClickable(By.id("carDropoffLocation")));
		Select carDropoffLocationDropdown = new Select(carDropoffLocation);
		carDropoffLocationDropdown.selectByVisibleText("Other Location");
		WebElement selectedCarDropoffLocation = carDropoffLocationDropdown.getFirstSelectedOption();
		String carDropoffLocationData = selectedCarDropoffLocation.getText();

		if (carDropoffLocationData != null) {
			System.out.println("Select Drop-off Location in Other Location - PASSED");
		} else {
			System.out.println("Select Drop-off Location in Other Location - FAILED");
		}

		WebElement notes = driver.findElement(By.xpath("//input[contains(@placeholder, 'Pick-up/Drop-off notes')]"));
		notes.sendKeys("Thank you");

		WebElement bookNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Book Now')]")));
		bookNowButton.click();
		boolean verifyBook = WebUI.verifyTextPresent('Booking Details', false);

		if (verifyBook) {
			System.out.println("Click button Book Now - PASSED");
		} else {
			System.out.println("Click button Book Now - FAILED");
		}

		WebElement contactDetails = driver.findElement(By.xpath("//input[contains(@placeholder, 'Contact Details')]"));
		contactDetails.sendKeys("081010101010");
		WebElement driverDetails = driver.findElement(By.xpath("//input[contains(@placeholder, 'Driver Details')]"));
		driverDetails.sendKeys("Muhammad Akbar");

		boolean continueButtonPresent = WebUI.verifyElementPresent(continueXpath, 3);

		if (continueButtonPresent) {
			WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueXpath)));
			continueBtn.click();
			System.out.println("Continue Button - PASSED");
		} else {
			System.out.println("Continue Button - FAILED");
		}

		WebElement specialRequest = driver.findElement(By.xpath("//input[contains(@placeholder, 'Special Request')]"));
		specialRequest.sendKeys("I want extra guarantee for my rental car");

		WebElement rentalRequirements = driver.findElement(By.id("rental-requirements"));

		if (rentalRequirements.isDisplayed()) {
			List<WebElement> requirementCheckboxes = rentalRequirements.findElements(By.cssSelector("input[type='checkbox']"));

			for (WebElement checkbox : requirementCheckboxes) {
				if (!checkbox.isSelected()) {
					checkbox.click();
				}
			}

			System.out.println("Rental requirements checked - PASSED");
		} else {
			System.out.println("Rental requirements checked - FAILED");
		}

		continueButtonPresent = WebUI.verifyElementPresent(continueXpath, 3);

		if (continueButtonPresent) {
			WebElement continueBtn = driver.findElement(By.xpath(continueXpath));
			continueBtn.click();
			System.out.println("Continue Button - PASSED");
		} else {
			System.out.println("Continue Button - FAILED");
		}

		WebElement bcaPaymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'BCA')]")));
		bcaPaymentMethod.click();
		WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Proceed')]")));
		proceedButton.click();
		
		boolean verifySuccessRent = WebUI.verifyTextPresent('Success Rent', false);
		
		if (verifySuccessRent) {
			System.out.println("Rent a Car - PASSED");
		} else {
			System.out.println("Rent a Car - FAILED");
		}
		
		WebUI.closeBrowser();
	}
}
