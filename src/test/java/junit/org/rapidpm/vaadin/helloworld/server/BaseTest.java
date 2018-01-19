package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.vaadin.helloworld.server.Main;

/**
 *
 */
public abstract class BaseTest implements HasLogger {

  @BeforeEach
  public void setUp() throws Exception {
    Main.start();
  }

  @AfterEach
  public void tearDown() throws Exception {
    Main.shutdown();
  }


}
