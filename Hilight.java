package utility;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.Dicom_Base;

public class Hilight extends Dicom_Base
  {

	public Hilight() throws IOException 
	{
		
	}
	
	public static void Hilight_element(WebElement HiglightParmaeter) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", HiglightParmaeter);

	}

  }
