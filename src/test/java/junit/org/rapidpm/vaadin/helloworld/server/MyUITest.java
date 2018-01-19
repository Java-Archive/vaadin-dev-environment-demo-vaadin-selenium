package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class MyUITest extends BaseSeleniumTest {


  @Test
  public void test001() throws Exception {

    if (!driver.isPresent()) Assertions.fail("WebDriver not available");

    driver.ifPresent(d -> {
      d.get("http://127.0.0.1:8080/");
//      d.get("http://192.168.0.228:8080/"); // grap external IP at runtime

//      Assert.assertNotNull(button(d));
//      Assert.assertEquals("click me",
//                          button(d).getText());

      Assertions.assertEquals("", output(d).getText());

      input(d).sendKeys("Hello World");

      final WebElement button = button(d);

      Assertions.assertNotNull(button);
      String text = button.getText();
      Assertions.assertEquals("click me", text);

      button.sendKeys(Keys.ENTER);

      String outputText = output(d).getAttribute("value");
      Assertions.assertEquals("Hello World", outputText);
    });
  }
}
