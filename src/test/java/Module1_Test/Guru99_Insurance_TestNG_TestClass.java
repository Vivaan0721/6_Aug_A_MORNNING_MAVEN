package Module1_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.Base_Class;
import Library_files.UtiityClass;
import Module1.Guru99_Insurance_BrokerInsuranceWebPage;
import Module1.Guru99_Insurance_Login;

public class Guru99_Insurance_TestNG_TestClass extends Base_Class
{

	//InitializeBrowser()
		//public WebDriver driver;
		
	
		Guru99_Insurance_Login  Login;
		Guru99_Insurance_BrokerInsuranceWebPage login1;
		
		int TestCaseID;

		@BeforeClass
		public void OpenBrowser()
		{
			InitializeBrowser();
			
			//Create object of POM-I
		  Login=new Guru99_Insurance_Login(driver);
		
		//Create object of POM-II
		 login1=new Guru99_Insurance_BrokerInsuranceWebPage(driver);
		
		}	
		
		@BeforeMethod
		public void Login() throws IOException, InterruptedException
		{
			Login.enterEmail(UtiityClass.getDatafromPF("EM"));  //saradeg41@gmail.com  //Login.enterEmail("saradeg41@gmail.com")

			Thread.sleep(1000);
			Login.enterPassword(UtiityClass.getDatafromPF("PSW"));  //Sai@1117  //Login.enterPassword("Sai@1117");
			
			Thread.sleep(1000);
			Login.clickLoginBtn();
		}
			
		@Test
		public void verifytEmailAddressofGuru99() throws EncryptedDocumentException, IOException                   //Test Case/Method
		{
			TestCaseID=100;
			
		    String	ActualEmail=login1.getEmail();  //saradeg41@gmail.com
		     
		   String ExpectedEmail=UtiityClass.getDatafromExcelsheet(0, 0); //saradeg41@gmail.com
		    
		    Assert.assertEquals(ActualEmail, ExpectedEmail);  //Pass
		}

		@Test
		public void getTitle() throws EncryptedDocumentException, IOException
		{
			TestCaseID=101;
			
		 String	ActualTitle=driver.getTitle();
		 
		 String ExpectedTitle=UtiityClass.getDatafromExcelsheet(1, 0); //Insurance Broker System
		 
		 Assert.assertEquals(ActualTitle, ExpectedTitle); //Insurance Broker System
		 
		}
		
		@Test
		public void CalculatePremium() throws EncryptedDocumentException, IOException, InterruptedException 
		
		{
			login1.clickRequestQuotation();
			
			Thread.sleep(1000);
			
			login1.SelectBreakdowncover();
			Thread.sleep(1000);
			
			
			login1.clickWindscreenrepair();
			Thread.sleep(1000);
			
			String A1=UtiityClass.getDatafromExcelsheet(2,0);
					login1.Enterincidents(A1);
					Thread.sleep(1000);
			String B1=UtiityClass.getDatafromExcelsheet(3,0);
			 login1.EnterRegistration(B1);
			 Thread.sleep(1000);
			 
					 String C1=UtiityClass.getDatafromExcelsheet(4,0);
					 login1.EnterAnnualmileage(C1);
					 Thread.sleep(1000);
					 
					String D1= UtiityClass.getDatafromExcelsheet(5,0);
					 login1.EnterEstimatedvalue(D1);
					 Thread.sleep(1000);
					 
					 login1.SelectParkingLocation();
					 Thread.sleep(1000);
					 
					 login1.SelectYear();
						Thread.sleep(1000);
						
						login1.SelectMonth();
						Thread.sleep(1000);
						
						login1.SelectDate();
						Thread.sleep(1000);
						
						
						login1.ClickCP();
						Thread.sleep(1000);
						
					String	ActualFinalPremiumofCar=login1.getFinalPremeium();
					
					String ExpectedFinalPremeiumofcar=UtiityClass.getDatafromExcelsheet(6,0);
					
					Assert.assertEquals(ActualFinalPremiumofCar, ExpectedFinalPremeiumofcar);
					

					
		}
		
		@AfterMethod
		public void Logout(ITestResult Result) throws IOException
		{
		 //Pass  fail                   //Fail
			if(Result.getStatus()==ITestResult.FAILURE) 
			{                                          //101
				UtiityClass.CaptureScreenshot(driver,TestCaseID);
			}
			
			
			
			login1.clickLogoutBtn();
		}
		
		@AfterClass
		public void CloseBrowser()
		{
			driver.close();
		}
		
	
		
}
