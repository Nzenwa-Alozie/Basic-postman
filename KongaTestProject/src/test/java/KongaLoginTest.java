import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 public class KongaLoginTest {
    //Import the Konga WebDriver
    private WebDriver driver;

@BeforeTest
     public void Setup() {
    //locate where the chromedriver is
    System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

    //1.open your ChromeBrowser
    driver = new ChromeDriver();
}
@Test()
      public void WebPage() throws InterruptedException {
    //2.input your Konga webpage url (https://www.konga.com/)
    driver.get("https://www.konga.com/");

    //Test.1 verify user input the right url and he/she is on the right webpage
    if (driver.getCurrentUrl().contains("https://www.konga.com/"))
        //pass
        System.out.println("Correct Webpage");
    else
        //fail
        System.out.println("Wrong Webpage");

    Thread.sleep(5000);


    //3.Maximize the browser
    driver.manage().window().maximize();

    //4.click on LogIn button to open SignIn page
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

    Thread.sleep(5000);

}
@Test(priority = 1)
     public void PositiveLogin(){
     //Test.2 verify user can log in with valid details

     //5.locate the email field and input a valid email
     driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("donaldalozie1@gmail.com");

     //6.locate the password field and input a valid password
      driver.findElement(By.id("password")).sendKeys("Donald6565");

    //7.click on the login button
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
}
@Test(priority = 2)
     public void PageTitle() throws InterruptedException {
    //Test.3 verify user is on the right home page after clicking on the login button
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/a/img"));

    String expectedTitle = "Konga";
    String actualTitle = driver.getTitle();
    if (actualTitle.contains(expectedTitle))
        //pass
        System.out.println("Correct Webpage");
    else
        //fail
        System.out.println("Wrong Webpage");
    Thread.sleep(5000);
}

@Test(priority = 3)
     public void LogoutSuccessfully() throws InterruptedException {
    //8.click on account
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();

    //9.Click on Logout
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

    Thread.sleep(5000);
}


@AfterTest
     public void CloseBrowser(){
         //quit browser
         driver.quit();
}


}
