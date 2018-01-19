package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.rapidpm.vaadin.helloworld.server.MyUI;

import java.net.URI;
import java.util.Optional;

/**
 *
 */
public class BaseSeleniumTest extends BaseTest {

  protected Optional<WebDriver> driver;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    DesiredCapabilities browser = new DesiredCapabilities();
    browser.setBrowserName("chrome");
    browser.setVersion("60.0");

    driver = Optional.of(new RemoteWebDriver(
        URI.create("http://selenoid-server:4444/wd/hub").toURL(),
        browser
    ));
  }


  @Override
  @After
  public void tearDown() throws Exception {
    // kill webdriver / Browser here
    driver.ifPresent(d -> {
      d.close();
      d.quit();
    });
    driver = Optional.empty();
    super.tearDown();
  }

  protected WebElement button(WebDriver driver) {
    return driver.findElement(By.id(MyUI.BUTTON_ID));
  }

  protected WebElement output(WebDriver driver) {
    return driver.findElement(By.id(MyUI.OUTPUT_ID));
  }

  protected WebElement input(WebDriver driver) {
    return driver.findElement(By.id(MyUI.INPUT_ID));
  }

}
