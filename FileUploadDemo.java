package demo;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadDemo {
public static void main(String[] args)throws InvalidArgumentException
{
	 WebDriver driver = new FirefoxDriver();

	  // Maximize Window
	  driver.manage().window().maximize();

	  // Open URL 
	  driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

	  // Click on Browse button
	  driver.findElement(By.name("photo")).sendKeys("D:\\\\important docs\\\\23 it.jpeg");

	  // Wait for 3 seconds
	  try { Thread.sleep(3000);}
	  catch (InterruptedException e){ e.printStackTrace();}

	  // Get Location of the file to be uploaded 
	  String fileLocation = "D:\\important docs\\23 it.jpeg";
	  
	  StringSelection filepath = new StringSelection(fileLocation);

	  // Copy the file path
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

	  // Try block
	  try {
	   // Create object of Robot class
	   Robot robot = new Robot();

	   // Press Ctrl key
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   // Press Ctrl + V key - It will paste the file path in windows dialog  
	   robot.keyPress(KeyEvent.VK_V);

	   // Now release V + Ctrl key
	   robot.keyRelease(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_CONTROL);

	   // Click Enter Key 
	   robot.keyPress(KeyEvent.VK_ENTER);

	   // Release Enter Key
	   robot.keyRelease(KeyEvent.VK_ENTER);

	  } catch (AWTException e) {e.printStackTrace();}
	 }
}
	






