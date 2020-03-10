package dicom_Test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Dicom_Base;
import dicom_Modules.Share;
import utility.CustomListner;
import utility.Excel_Read;

@Listeners(CustomListner.class)
public class Share_Test extends Dicom_Base
  {
	Share share;
	public Share_Test() throws IOException 
	{
		super();
		
	}
	
	@BeforeTest()
	public void setup() throws IOException 
	{
		
		Initilization();
		share=new Share();
	}
	
	@Test(priority=1)
	public void Click_on_Share() throws InterruptedException 
	{
		
		
		share.Click_Share();
	}
	
	@Test(priority=2)
	public void Verify_Title() throws InterruptedException 
	{
		
		share.Title();
	}
	@Test(priority=3)
	public void Upload_Folder() throws InterruptedException 
	{
		
		share.Click_New_Share();
	}
	@Test(priority=4)
	public void Drag_Drop_Folder() throws InterruptedException, IOException 
	{
		Thread.sleep(1000);
		share.Drag_Drop();
		
	}
	@Test(priority=5)
	public void Accept_Alert() throws InterruptedException, AWTException 
	{
		Thread.sleep(1000);
		share.Alert();
	}
	@Test(priority=6)
	public void Folder_File_Count() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.File_Count();
	}
	@Test(priority=7)
	public void Upload_Files() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Uoload();
		
	}
	@Test(priority=8)
	public void Click_on_Image() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.click_image();
	}
	
	@Test(priority=9,invocationCount=6)
	public void Click_on_Next_Image() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Next_Img();
	}
	
	@Test(priority=10,invocationCount=3)
	public void Click_on_Previos_Image() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Previous_Img();
	}
	
	@Test(priority=11)
	public void Click_on_Hide_Img_Information() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Hide_Image_Info();
	}
	
	@Test(priority=12)
	public void Click_on_Refresh_Viewer() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Refresh_Viewer();
	}
	
	@Test(priority=13,invocationCount=4)
	public void Click_Scroll_Image() throws InterruptedException, AWTException 
	{
		Thread.sleep(2000);
		share.Scroll_Image();
	}
	
	@Test(priority=14,invocationCount=4)
	public void Click_Zoom_Image() throws AWTException, InterruptedException 
	{
		Thread.sleep(2000);
		share.Zoom_Image();
	}
	
	@Test(priority=15,invocationCount=3)
	public void Click_Zoom_Out() throws AWTException, InterruptedException 
	{
		Thread.sleep(2000);
		share.Zoom_Out();
	}
	
	@Test(priority=16)
	public void Add_Doctor() throws InterruptedException 
	{
		Thread.sleep(1000);
		share.Add_Edit_Doctor();
	}
	
	@DataProvider(name = "get_Dr_1_Data")
	public Object[][] getDr_1_Data() throws Exception {
		Object[][]dr_1_Data=Excel_Read.getTestData("Sheet1");
		return dr_1_Data;
		
	}
	
	@Test(priority=17,dataProvider="get_Dr_1_Data")
	public void Add_Doctors_Info(String Dr_Name,String Dr_Email_ID,String Dr_Country_Name,String Dr_Mobile_Number,String Ref_Information,String Link_Valid) throws InterruptedException 
	{
		
		share.Add_Doctor_list(Dr_Name, Dr_Email_ID, Dr_Country_Name, Dr_Mobile_Number, Ref_Information,Link_Valid);
		
	}
	@Test(priority=18)
	public void Share_Folder() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Share_Folder();
	}
	
	@Test(priority=19)
	public void Data_Shared_Success() throws InterruptedException 
	{
		Thread.sleep(3000);
		share.click_ok();
	}
	
	
	@Test(priority=20)
	public void Folder_Share() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Folder_Select();
	}
	
	@Test(priority=21)
	public void Click_Select_Folder() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.click_folder();
	}
	
	@Test(priority=22)
	public void serch_folder_send() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Add_Edit_Doctor();
	}
	
	@DataProvider(name = "get_Dr_2_Data")
	public Object[][] getDr_2_Data() throws Exception {
		Object[][]dr_2_Data=Excel_Read.getTestData("Sheet2");
		return dr_2_Data;
		
	}
	
	@Test(priority=23,dataProvider="get_Dr_2_Data")
	public void Add_Doctors_2_Info(String Dr_2_Name,String Dr_2_Email_ID,String Dr_2_Country_Name,String Dr_2_Mobile_Number,String Ref_2_Information,String Link_2_Valid) throws InterruptedException 
	{
		
		share.Add_Doctor_list(Dr_2_Name, Dr_2_Email_ID, Dr_2_Country_Name, Dr_2_Mobile_Number, Ref_2_Information,Link_2_Valid);
		
	}
	
	@Test(priority=24)
	public void Share_Folder_2() throws InterruptedException 
	{
		Thread.sleep(2000);
		share.Click_Share_Folder();
	}
	
	@Test(priority=25)
	
	public void Data_Shared_Success_2() throws InterruptedException 
	{
		Thread.sleep(3000);
		share.click_ok();
	}
	@AfterTest()
	public void Quite() throws InterruptedException 
	{
		
		driver.close();
	}
	
	
  }
