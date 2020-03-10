package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Dicom_Base;

public class CustomListner extends Dicom_Base implements ITestListener 
{
	public CustomListner() throws IOException {
		//super();
		
	}
	
public void onFinish(ITestContext arg0) {
		
		
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failed Test");
		try {
			failed(result.getMethod().getMethodName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	public void onTestStart(ITestResult arg0) {
		
		
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Pass Test Cases");
		try {
			pass(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
