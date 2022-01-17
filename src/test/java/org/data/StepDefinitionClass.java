package org.data;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class StepDefinitionClass {
	
	static WebDriver driver;
	String ParentHandle;
	
		
	@Given("User should be launch in Todo webpage")
	public void user_should_be_launch_in_Todo_webpage() throws InterruptedException  {
		 WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    driver.get("https://todo-list-login.firebaseapp.com/");
		    driver.manage().window().maximize();
		    
		  
		  }

		
	@When("Login to the web page")
	public void login_to_the_web_page() {
		
		ParentHandle = driver.getWindowHandle();
	    System.out.println("Parent Window: "+ParentHandle);
	    driver.findElement(By.xpath("//a[@class='btn btn-social btn-github']")).click();
	     Set<String> handles=driver.getWindowHandles();
	    for (String handle : handles) {
	    	System.out.println(handle);
	    	if(!handle.equals(ParentHandle)) {
	    		driver.switchTo().window(handle);
	    	    driver.findElement(By.id("login_field")).sendKeys("sumithrak11");
			    driver.findElement(By.id("password")).sendKeys("Adhvik@1234");
			    driver.findElement(By.name("commit")).click();   	    
	    	}
	    }
	    
	    //Authorize Element //only some time occurs
	    //WebElement authElem = driver.findElement(By.name("authorize"));
	    //if(authElem != null)
	    //{
	    //	authElem.click();
	    //}
	    
	  
	}
	
	@When("Naviage to home page")
	public void naviage_to_home_page() {
		
		driver.switchTo().window(ParentHandle);
		
	}
	
	@Then("check login is success")
	public void check_login_is_success() {
		
		 System.out.println("Successfully logged in");
		 String strTitlt = driver.getTitle();
		
		 boolean rtresult = strTitlt.contains("Todo App");
		 
		 Assert.assertTrue(rtresult);
		 System.out.println("Successfully logged in verified");
	}
	
	//Todo Creation
	
	@Given("Land into Todo Page")
	public void land_into_Todo_Page() {
		String strTitlt = driver.getTitle();
		
		 boolean rtresult = strTitlt.contains("Todo App");
		 
		 Assert.assertTrue(rtresult);
		 System.out.println("Am in todo App page");
	}
	
	@When("Add Ten todo list")
	public void add_Ten_todo_list() {
		
		List<String> randomstrings = Arrays.asList("Test Planning", "Test Scenario", "SIT Testing",
				"UAT Testing","SQL Testing","API Testing","Regresion Testing","Sanity Testing","Smoke Testing",
				"Unit Testing","Load Testing");
		
		for (int i = 0; i < randomstrings.size(); i++) {
			driver.findElement(By.xpath("//html/body/ng-view/div/div[2]/div[1]/input")).sendKeys("my todo item => " + randomstrings.get(i) + " ");
			driver.findElement(By.xpath("//html/body/ng-view/div/div[2]/div[2]/button")).click();
		}
		
		}
	
	@Then("log off from App")
	public void log_off_from_App() {
		
		//Verify
		WebElement parelmnt = driver.findElement(By.xpath("//html/body/ng-view/div/div[3]/div/ul"));
		List<WebElement> lstbuttons = parelmnt.findElements(By.tagName("button"));
		boolean istask = false;
		if(lstbuttons.size() > 9)
		{
			istask = true;
		}
		Assert.assertTrue(istask);
		System.out.println("Successfully created the task items");
		
		
		//Log off
		driver.findElement(By.xpath("//html/body/ng-view/div/nav/div/ul/li/div/button")).click();
		System.out.println("Successfully Signed Out");
		driver.close();
	   
	}
	
	@Given("Stay on same page")
	public void stay_on_same_page() {
		System.out.println("Successfully Landed again");
	   
	}
	
	
	@When("Delete my to do items")
	public void delete_my_to_do_items() {
		WebElement parelmnt = driver.findElement(By.xpath("//html/body/ng-view/div/div[3]/div/ul"));
		List<WebElement> lstbuttons = parelmnt.findElements(By.tagName("button"));
		
		for (int i = 0; i < lstbuttons.size(); i++) {
			if(i > 4) // to delete last 5 items
			{
			WebElement webElement = (WebElement) lstbuttons.get(i);
			webElement.click();
			}
		}
		
		
	}
	
	@Then("check my to do has five")
	public void check_my_to_do_has_five() {
		WebElement parelmnt = driver.findElement(By.xpath("//html/body/ng-view/div/div[3]/div/ul"));
		List<WebElement> lstbuttons = parelmnt.findElements(By.tagName("button"));
		boolean isNotask = false;
		if(lstbuttons.size() == 5)
		{
			isNotask = true;
		}
		Assert.assertTrue(isNotask);
		System.out.println("Successfully Deleted the 5 items");
	  
	}
	


	
	
}
