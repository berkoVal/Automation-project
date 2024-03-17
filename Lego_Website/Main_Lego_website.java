package Lego_Website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium2.Calc_Page;

public class Main_Lego_website {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\נטלי ברקו\\Desktop\\QA\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("file:///C:/Users/נטלי ברקו/Desktop/QA/HTML/פרויקט אוטומציה/Lazy LEGO People/LazyHOMEp.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		Website_Lego contactLazy = new Website_Lego(driver);

		// =====================================================================================

		// לחיצה למעבר דף קטגוריות
		contactLazy.categoriesButton().click();

		// בדיקה שנמצאים בדף קטגוריות והניווט בין העמודים עבר בהצלחה
		if (contactLazy.textValue().equals("בחירת קטגוריה"))
			System.out.println("test 1 passed - navigation is successful ");
		else
			System.out.println("test 1 failed - navigation is not successful, Actual: "+contactLazy.textValue());

		// בדיקה של כמות הצק בוקס שיש בעמוד
		contactLazy.checkBoxList();

		// הגדרה משתנה בשביל להוסיף כמות לבדיקה של הצ'ק בוקס
		int size = contactLazy.checkBoxSize();

		// בדיקה האם קיימים כפתורי רדיו באתר
		contactLazy.radioButtonList();
		if (contactLazy.radioButtonSize()==0)
			System.out.println("test 2 passed - radio button is not found");
		else
			System.out.println("test 2 failed - radio button is found, Actual: "+contactLazy.radioButtonSize());

		// =====================================================================================

		// לחיצה למעבר דף יצירת קשר 
		contactLazy.contactButton().click();

		// בדיקות למצב התחלתי של השדות (מצב ברירת מחדל) 

		// הורדה של עמוד בדף עד הסוף על מנת לראות את הביצוע של הבדיקה
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		
		// בדיקה לברירת מחדל של השדה שם פרטי
		if (contactLazy.firstValue().equals(""))
			System.out.println("test 3 passed - first name is empty");
		else
			System.out.println("test 3 failed - first name Expected: Empty, Actual: "+contactLazy.firstValue());

		// בדיקה לברירת מחדל של השדה שם משפחה
		if (contactLazy.lastValue().equals(""))
			System.out.println("test 4 passed - last name is empty");
		else
			System.out.println("test 4 failed - last name Expected: Empty, Actual: "+contactLazy.lastValue());

		// בדיקה לברירת מחדל של השדה איימל
		if (contactLazy.emailValue().equals(""))
			System.out.println("test 5 passed - email Address is empty");
		else
			System.out.println("test 5 failed - email Address Expected: Empty, Actual: "+contactLazy.emailValue());

		//  בדיקה לברירת מחדל של בחירת אזור | value="0"= מצב התחלתי  
		if (contactLazy.areaValue().equals("0"))
			System.out.println("test 6 passed - area is empty");
		else
			System.out.println("test 6 failed - area Expected: Empty, Actual: "+contactLazy.areaValue());

		// בדיקה לברירת מחדל של השדה טקסט פתוח להזמנה 
		if (contactLazy.WriteValue().equals(""))
			System.out.println("test 7 passed - Write is empty");
		else
			System.out.println("test 7 failed - Write Expected: Empty, Actual: "+contactLazy.WriteValue());

		// בדיקה לכמות הצ'ק בוקס והוספה של סה"כ הכמות שקיימת באתר
		contactLazy.checkBoxList();
		size+= contactLazy.checkBoxSize();

		// הדפסה של כמות הצק בוקס שיש באתר 
		if (size==15)
			System.out.println("test 8 passed - number of check Box is correct: "+size);
		else
			System.out.println("test 8 failed - number of check Box is incorrect, Actual: "+size);

		// מצב התחלתי  הצק בוקס  1
		if (!contactLazy.checkBoxesOne().isSelected())
			System.out.println("test 9 passed - check Boxes One is not checked");
		else
			System.out.println("test 9 failed - check Boxes One is checked");

		// מצב התחלתי  הצק בוקס  2
		if (!contactLazy.checkBoxesTwo().isSelected())
			System.out.println("test 10 passed - check Boxes Two is not checked");
		else
			System.out.println("test 10 failed - check Boxes Two is checked");

		// מצב התחלתי  הצק בוקס  3
		if (!contactLazy.checkBoxesThreee().isSelected())
			System.out.println("test 11 passed - check Boxes Threee is not checked");
		else
			System.out.println("test 11 failed - check Boxes Threee is checked");

		//	=============================================================================================
		
		// מילוי הטופס כולל לחיצה לשליחה הטופס, וחזרה לעמוד הבית

		// מילוי השדה של שם פרטי
		contactLazy.typeFirstName("Valerya");
		// מילוי השדה של שם משפחה
		contactLazy.typeLastName("Berko");
		// מילוי השדה של איימל
		contactLazy.typeEmailAddress("Berko_Kripki@gmail.com");
		// בחירה מהדאופאון של אזור צפון
		contactLazy.chooseArea("צפון");
		// מילוי השדה של הטקסט הפתוח 
		contactLazy.typeWriteToUs("hi welcome to my test");

		// פונקציה לבדיקת הכפתורים של הצק בוקס כפתוראם הכפתור1 לא מסומן אז יש ללחוץ על הצ'ק בוקס
		if (!contactLazy.checkBoxesOne().isSelected())
			contactLazy.checkBoxesOne().click();
		// פונקציה לבדיקת הכפתורים של הצק בוקס כפתוראם הכפתור2 לא מסומן אז יש ללחוץ על הצ'ק בוקס
		if (!contactLazy.checkBoxesTwo().isSelected())
			contactLazy.checkBoxesTwo().click();
		// פונקציה לבדיקת הכפתורים של הצק בוקס כפתוראם הכפתור3 לא מסומן אז יש ללחוץ על הצ'ק בוקס
		if (!contactLazy.checkBoxesThreee().isSelected())
			contactLazy.checkBoxesThreee().click();

		// לחיצה על כפתור שליחה של הטופס
		contactLazy.sendButton().click();

		// אישור ההתראה
		driver.switchTo().alert().accept();

		// בדיקה שלאחר שליחת הטופס אכן הוא מחזיר חזרה לעמוד הבית 
		if(contactLazy.homeTextValue().equals("קצת עלינו"))
			System.out.println("test 12 passed - form sent successfuly ");
		else
			System.out.println("test 12 failed - form is not sent successfuly, Actual: "+contactLazy.homeTextValue());


		driver.quit();

	}

}
