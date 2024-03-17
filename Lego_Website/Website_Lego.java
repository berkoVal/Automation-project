package Lego_Website;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Website_Lego {

	WebDriver driver;

	Website_Lego(WebDriver driver){
		this.driver=driver;
	}

	// מציאת אלמנטים | Finding elements
	
	// Locator: name
	// לצורך בדיקה של הגעה לעמוד הנכון  - טקסט בעמוד הבית
	WebElement homeTextCheck() {
		return driver.findElement(By.name("aboutUs"));
	}

	// Locator: Xpath 
	// כפתור של מעבר לעמוד קטגוריה
	WebElement categoriesButton() {
		return driver.findElement(By.xpath("//a[@href='LazyCategories.html']"));
	}

	// Locator: Xpath
	// לצורך בדיקה של הגעה לעמוד הנכון  - טקסט בעמוד יצירת קשר
	WebElement textCheck() {
		return driver.findElement(By.xpath("//h2[@style='text-align:center']"));
	}

	// Locator: Xpath
	// כפתור של מעבר לעמוד יצירת קשר
	WebElement contactButton() {
		return driver.findElement(By.xpath("//a[@href='LazyContact.html']"));
	}

	// Locator: Name
	// השדה של שם פרטי
	WebElement firstName() {
		return driver.findElement(By.name("firstname"));
	}

	// Locator: Css Selector
	// השדה של שם משפחה
	WebElement lastName() {
		return driver.findElement(By.cssSelector("input[placeholder=\"השם משפחה שלך..\"]"));
	}

	// Locator: ID
	// השדה של איימל
	WebElement emailAddress() {
		return driver.findElement(By.id("email"));
	}

	// Locator: Class Name 
	// השדה של בחירת אזור-דרופדאון
	WebElement area() {
		return driver.findElement(By.className("area"));
	}

	// Locator: ID
	// השדה של הטקסט הפתוח להזמנה
	WebElement WriteToUs() {
		return driver.findElement(By.id("opentext"));
	}

	// Locator: ID
	// צ'ק בוקס 1
	WebElement checkBoxesOne() {
		return driver.findElement(By.id("approval1"));
	}

	// Locator: ID
	// צ'ק בוקס 2 
	WebElement checkBoxesTwo() {
		return driver.findElement(By.id("approval2"));
	}

	// Locator: ID
	// צ'ק בוקס 3
	WebElement checkBoxesThreee() {
		return driver.findElement(By.id("approval3"));
	}

	// Locator: Css Selector
	// כפתור של שליחת הטופס- כפתור שליחה
	WebElement sendButton() {
		return driver.findElement(By.cssSelector("input[value='שלח']"));
	}

	//===========================================================================
	
	// פונקציות שמחזירות את הערך שיש בשדות כמצב התחלתי

	// מחזירה מה רשום בשדה של שם פרטי
	String firstValue() {
		return firstName().getText();
	}

	// מחזירה מה רשום בשם בשדה של שם משפחה
	String lastValue() {
		return lastName().getText();
	}

	// מחזירה מה רשום בשדה של באיימל
	String emailValue() {
		return emailAddress().getText();
	}

	// מחזירה מה רשום בשדה של אזור מגורים
	String areaValue() {
		return area().getAttribute("value");
	}

	// מחזירה מה רשום בשדה של הטקסט הפתוח להזמנה
	String WriteValue() {
		return WriteToUs().getText();
	}

	// מחזירה את הטקסט : בחירת קטגוריה 
	String textValue() {
		return textCheck().getText();
	}

	// מחזירה את הטקסט : קצת עלינו 
	String homeTextValue() {
		return homeTextCheck().getText();
	}

	//==============================================
	
	// פונקציות למילוי השדות 

	// מקבל שם פרטי מהיוזר
	void typeFirstName(String firstName) {
		firstName().sendKeys(firstName);
	}

	// מקבל שם משפחה מהיוזר
	void typeLastName(String lastName) {
		lastName().sendKeys(lastName);
	}

	// מקבל איימל מהיוזר
	void typeEmailAddress(String emailAddress) {
		emailAddress().sendKeys(emailAddress);
	}

	// בחירת אזור מהיוזר
	void chooseArea(String op) {
		Select opDropDown = new Select(area());
		opDropDown.selectByVisibleText(op);
	}

	// מקבל הזמנה מהיוזר
	void typeWriteToUs(String message) {
		WriteToUs().sendKeys(message);
	}

	// מחפש בדף אלמנטים מסוג צק בו'קס
	List <WebElement> checkBoxList() {
		return driver.findElements(By.cssSelector("[type='checkbox']"));
	}

	// מחזיר תשובה של כמות מסוג צק בו'קס (מערך)
	int checkBoxSize() {
		return checkBoxList().size();
	}

	// בדיקה שאין כפתור רדיו 
	List<WebElement> radioButtonList() {
		return driver.findElements(By.cssSelector("[type='radio']"));
	}

	// מחזיר תשובה של כמות מסוג כפתור רדיו
	int radioButtonSize() {
		return radioButtonList().size();
	}
}
