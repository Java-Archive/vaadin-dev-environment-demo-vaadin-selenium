package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
  @BeforeEach
  public void setUp() throws Exception {
    super.setUp();
    DesiredCapabilities browser = new DesiredCapabilities();
    browser.setBrowserName("chrome");
    browser.setVersion("60.0");

    driver = Optional.of(new RemoteWebDriver(
        URI.create("http://192.168.0.100:4444/wd/hub").toURL(),
        browser
    ));
  }


  @Override
  @AfterEach
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
