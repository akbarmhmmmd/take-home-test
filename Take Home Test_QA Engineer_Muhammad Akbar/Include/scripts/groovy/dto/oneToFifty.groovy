package dto
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable
import java.time.LocalDateTime
import com.kms.katalon.core.configuration.RunConfiguration
import java.util.Random
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

public class oneToFifty {

	public void playGame() {
		WebUI.openBrowser("https://zzzscore.com/1to50/en/");
		WebUI.maximizeWindow();
		WebDriver driver = DriverFactory.getWebDriver();

		for (int i = 99; i >= 50; i--) {
			WebElement numberElement = driver.findElement(By.xpath("//span[@style='z-index:${i}']"));
			numberElement.click();
		}

		boolean TestCompleted = WebUI.verifyTextPresent('Test Completed', false);

		if (TestCompleted) {
			System.out.println("1 to 50 - PASSED");
		} else {
			System.out.println("1 to 50 - FAILED");
		}

		WebUI.closeBrowser();
	}
}
