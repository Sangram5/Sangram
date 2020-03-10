package dicom_Modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.Dicom_Base;
import utility.Hilight;


public class Share extends Dicom_Base
  {
	@FindBy(xpath="//div[@class='slide-heading divShareTab']")
	WebElement share;
	
	@FindBy(xpath="//div/div/div/div/div/div[contains(text(),'Share')]")
	WebElement share_Title;
	
	@FindBy(xpath="//div/a[@id=\"addNewFolder\"]")
	WebElement new_share;
	
	@FindBy(xpath="//form[@id='dropzone']")
	WebElement Drag_Drop_Btn;
	
	@FindBy(xpath="//div/input[@id=\"uploadFolderName\"]")
	WebElement folder_name;
	
	@FindBy(xpath="//div/a[@id='btnUploadFiles']")
	WebElement upload_files;
	
	@FindBy(xpath="//span[@id=\"fileCount\"]")
	WebElement file_count;
	
	@FindBy(xpath="//div[@class=\"dz-success-mark\"]")
	WebElement success_count;
	
	@FindBy(xpath="//a[@id=\"backToFolder\"]")
	WebElement back;
	
	@FindBy(xpath="//div[@class='slide-heading divShareTab']//following::input[position()=1]")
	WebElement filter_folder;
	
	@FindBy(xpath="//input[@id=\"uploadFolderName\"]")
	WebElement get_folder;
	
	@FindBy(xpath="//div/div[@class=\"studyDesc\"]")
	WebElement click_on_folder;
	
	//Tool bar operation (Perform operation on image)
	
	@FindBy(xpath="//div[@id=\"thumbItem_0\"]")
	WebElement image;
	
	@FindBy(xpath="//button[@title=\"Next\"]")
	WebElement next;
	
	@FindBy(xpath="//button[@title=\"Previous\"]")
	WebElement previous;
	
	@FindBy(xpath="//button[@title=\"Show/Hide Image Information\"]")
	WebElement hide_img_info;
	
	@FindBy(xpath="//button[@title=\"Refresh Viewer\"]")
	WebElement refresh_viewer;
	
	@FindBy(xpath="//canvas[@id=\"imageLayer\"]")
	WebElement click_image;
	
	@FindBy(xpath="//select[@id=\"ddlAction\"]")
	WebElement select;
	
	//Adding Doctor
	
	@FindBy(xpath="//div[@class=\"col-sm-3  mt-10\"]/button")
	WebElement add_doctor;
	
	//Add Edit Doctor list
	
	@FindBy(xpath="//div/div/input[@name=\"name\"]")
	WebElement dr_name;
	
	@FindBy(xpath="//div/input[@name=\"email\"]")
	WebElement dr_email_ID;
	
	@FindBy(xpath="//div/div/select[@class=\"form-control validate[required,custom[dropdown]] drpCountry updatestatus\"]")
	WebElement country;
	
	@FindBy(xpath="//div/input[@name=\"mobile\"]")
	WebElement mobile_number;
	
	@FindBy(xpath="//textarea[@name=\"information\"]")
	WebElement information;
	
	@FindBy(xpath="//div/select[@id=\"drpValidFor\"]")
	WebElement link_valid_for;
	
	@FindBy(xpath="//div/div/label/input[@id=\"chkAnonymise\"]")
	WebElement anonymise_image;
	
	@FindBy(xpath="//div/div/label/input[@id=\"chkAllowdownload\"]")
	WebElement allow_img_download;
	
	@FindBy(xpath="//button[@class=\"btn left add-sup \"]")
	WebElement add_dr;
	
	@FindBy(xpath="//button[@id=\"saveDocList1\"]")
	WebElement share_folder_click;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary\"]")
	WebElement data_shared_success_fully;
	
	public Share() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Share() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(share));
		Hilight.Hilight_element(share);
		share.click();
	}
	
	public void Title() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(share_Title));
		Hilight.Hilight_element(share_Title);
		String title=share_Title.getText();
		System.out.println("Title fetching ======="+title);
		Boolean result=title.equalsIgnoreCase(title);
		System.out.println("Comparing the title ===="+result);
		
	}
	
	
	public void Click_New_Share() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(new_share));
		Hilight.Hilight_element(new_share);
		
		new_share.click();
	}
	public void Drag_Drop() throws InterruptedException, IOException 
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(Drag_Drop_Btn));
		
		Hilight.Hilight_element(Drag_Drop_Btn);
		Drag_Drop_Btn.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\sangram.patil\\Desktop\\AutoIT\\Upload.exe");
		
	}
	public void Alert() throws InterruptedException, AWTException 
	{
		Thread.sleep(4000);
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	public void File_Count() throws InterruptedException 
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(file_count));
		
		Hilight.Hilight_element(file_count);
		String total_count=file_count.getText();
		System.out.println("Total file Count is ====="+total_count);
	}
	public void Uoload() throws InterruptedException 
	{
		Hilight.Hilight_element(folder_name);
		folder_name.sendKeys(prop.getProperty("F_Name"));
		
		
		wait.until(ExpectedConditions.elementToBeClickable(upload_files));
		
		Hilight.Hilight_element(upload_files);
		upload_files.click();
		
	}
	
	public void click_image() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(image));
		Hilight.Hilight_element(image);
		image.click();
	}
	
	public void Click_Next_Img() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(next));
		Hilight.Hilight_element(next);
		next.click();
	}
	
	public void Click_Previous_Img() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(previous));
		Hilight.Hilight_element(previous);
		previous.click();
	}
	
	public void Click_Hide_Image_Info() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(hide_img_info));
		Hilight.Hilight_element(hide_img_info);
		hide_img_info.click();
	}
	
	public void Click_Refresh_Viewer() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(refresh_viewer));
		Hilight.Hilight_element(refresh_viewer);
		refresh_viewer.click();
	}
	
	public void Scroll_Image() throws AWTException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(click_image));
		Hilight.Hilight_element(click_image);
		click_image.click();
		
		 Robot r = new Robot();
		 r.mouseWheel(2);
		
		
	}
	
	public void Zoom_Image() throws AWTException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(select));
		Hilight.Hilight_element(select);
		Select sel=new Select(select);
		sel.selectByValue("zoom");
		
		wait.until(ExpectedConditions.elementToBeClickable(click_image));
		click_image.click();
		
		
		 Robot r = new Robot();
		 r.mouseWheel(2);
	}
	
	public void Zoom_Out() throws AWTException 
	{
		
		 Robot r = new Robot();
		 r.mouseWheel(-2);
	}
	public void Add_Edit_Doctor() throws InterruptedException 
	{
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(add_doctor));
		Hilight.Hilight_element(add_doctor);
		Thread.sleep(4000);
		add_doctor.click();
	}
	
	//Add/Edit Doctor List
	
	
	
	public void Add_Doctor_list(String name,String email_ID,String country_name,String mobile,String refral_information,String link_valid) throws InterruptedException 
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(dr_name)).sendKeys(name);
		
		wait.until(ExpectedConditions.elementToBeClickable(dr_email_ID)).sendKeys(email_ID);
		
		wait.until(ExpectedConditions.elementToBeClickable(country)).sendKeys(country_name);
		
		wait.until(ExpectedConditions.elementToBeClickable(mobile_number)).sendKeys(mobile);
					
		wait.until(ExpectedConditions.elementToBeClickable(information)).sendKeys(refral_information);
		
		//wait.until(ExpectedConditions.elementToBeClickable(add_dr)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(link_valid_for)).sendKeys(link_valid);
		
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(anonymise_image)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(allow_img_download)).click();
					
	}
	
	public void Click_Share_Folder() throws InterruptedException 
	{
		
		Thread.sleep(4000);
		Hilight.Hilight_element(share_folder_click);
		wait.until(ExpectedConditions.elementToBeClickable(share_folder_click)).click();
		
		
		
	}
	
	public void click_ok() throws InterruptedException 
	{
		Thread.sleep(3000);
		Hilight.Hilight_element(data_shared_success_fully);
		wait.until(ExpectedConditions.elementToBeClickable(data_shared_success_fully)).click();
	}
	
	
	public void Folder_Select() throws InterruptedException 
	
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(back));
		Thread.sleep(2000);
		Hilight.Hilight_element(back);
		
		back.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(filter_folder));
		Thread.sleep(2000);
		filter_folder.sendKeys(prop.getProperty("F_Name"));
		
		
		
	}
	
	public void click_folder() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(click_on_folder));
		Hilight.Hilight_element(click_on_folder);
		click_on_folder.click();
		
	}
	
	//Add Dr.List After the Selecting the Folder.
	
	/*public void Add_Dr_List() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(add_doctor)).click();
	}*/
	
	
	
	
	
	
  }
