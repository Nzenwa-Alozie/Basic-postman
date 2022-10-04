import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignUpTest {
  //import the Selenium WebDriver
  private WebDriver driver;
@BeforeTest
  public void setup() throws InterruptedException {
       //locate where the chromedriver is
      System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

       //1.Open your ChromeBrowser
    driver = new ChromeDriver();

       //2.input your Selenium Demo Page URL(https://selenium-blog.herokuapp.com)
    driver.get("https://selenium-blog.herokuapp.com");

       //Test.1 verify the user input the right url and his on the right webpage
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
       //pass
    System.out.println("Correct Webpage");
    else
       //fail
    System.out.println("Wrong Webpage");

    Thread.sleep(5000);

      //3.Maximize the Browser
    driver.manage().window().maximize();

     //4.click on SignUp button to open signup page
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

     Thread.sleep(5000);

}

@Test (priority = 0)
  public void PositiveSignUp() throws InterruptedException {
     //Test.7 verify user is successfully signup when valid details are inputted

     //5.input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("Ann89");

    //6.input your email on the email field
    driver.findElement(By.id("user_email")).sendKeys("jhggktde@gmail.com");

    //7.input password on the password field
    driver.findElement(By.id("user_password")).sendKeys("4444");

    //8.click on the signup button
     driver.findElement(By.id("submit")).click();

     Thread.sleep(5000);

}

@Test (priority = 1)
  public void clickUser1Item() throws InterruptedException {
    //9.click user1 item on the list page
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

    //Test.2 verify user when user clicks on the signup button the user is directed to the signup page
    String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl))
    //pass
    System.out.println("Correct Webpage");
       else
    //fail
    System.out.println("Wrong Webpage");

    Thread.sleep(5000);

}

@Test (priority = 2)
  public void VerifyItem() throws InterruptedException {
    //10.search for an item (using python with selenium)
    // Test.9 verify the item searched for is present
    driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();

    String expectedPageUrl = "/users/1";
    String actualPageUrl = driver.getCurrentUrl();
    if (actualPageUrl.contains(expectedPageUrl))
        //pass
        System.out.println("Correct User1Page");
    else
        //fail
        System.out.println("Wrong User1Page");

    Thread.sleep(5000);
}

@Test (priority = 3)
     public void LogoutSuccessfully() throws InterruptedException {
    //11.click on logout
      driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

      //Test.10 verify when user logout He/She is directed to the home page
      String expectedTitle = "AlphaBlog";
      String actualTitle = driver.getTitle();
      if (expectedTitle.contains(actualTitle))
          //pass
       System.out.println("Correct Webpage");
      else
        System.out.println("Wrong Webpage");
      Thread.sleep(5000);
}

@Test (priority = 4)
    public void NegativeSignUp() throws InterruptedException {
     //click on the signup button on the signup page
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);

    //Test.3 Verify user cannot sign up with username less than 3 characters

    //input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("Ne");

    //input your email on the email field
    driver.findElement(By.id("user_email")).sendKeys("nkbcgg@gmail.com");

    //input password on the password field
    driver.findElement(By.id("user_password")).sendKeys("44");

    //click on the signup button
    driver.findElement(By.id("submit")).click();

    Thread.sleep(5000);

}
@Test (priority = 5)
 public void invalidEmail() throws InterruptedException {

    //Test.4 Verify user cannot sign up an invalid email

    //input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("Nee");

    //input your email on the email field
    driver.findElement(By.id("user_email")).sendKeys("####");

    //input password on the password field
    driver.findElement(By.id("user_password")).sendKeys("4ttt4");

    //click on the signup button
    driver.findElement(By.id("submit")).click();

    Thread.sleep(5000);
}

@Test (priority =6)
  public void InvalidPassword() throws InterruptedException {
    //Test.5 Verify user cannot log in with password less than one character
    //input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("Nee");

    //input your email on the email field
    driver.findElement(By.id("user_email")).sendKeys("kevin@gmail.com");

    //input password on the password field
    driver.findElement(By.id("user_password")).sendKeys("1");

    //click on the signup button
    driver.findElement(By.id("submit")).click();

    Thread.sleep(5000);
}

@Test (priority =7)
 public void EmptyField() throws InterruptedException {
    //Test.6 Verify User cannot log in with an empty field
    //input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("");

    //input your email on the email field
    driver.findElement(By.id("user_email")).sendKeys("");

    //input password on the password field
    driver.findElement(By.id("user_password")).sendKeys("");

    //click on the signup button
    driver.findElement(By.id("submit")).click();

    Thread.sleep(5000);

}

@AfterTest
    public void closeBrowser(){
    //12.Quit browser
    driver.quit();
}

}