package com.github.stupremee.mela.command.intercept;

import com.github.stupremee.mela.command.core.CommandContext;
import com.github.stupremee.mela.command.core.Dispatcher;
import com.github.stupremee.mela.command.SingleSubjectTest;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public final class CommandInterceptorTest extends SingleSubjectTest<InterceptorTestCommand> {

  @Inject
  private Dispatcher dispatcher;

  protected CommandInterceptorTest() {
    super(InterceptorTestModule::new);
  }

  @Test
  public void testInterceptedCommand() {
    dispatcher.dispatch("intercept", CommandContext.create());
    assertFalse(getSubject().isExecuted(), "Command was executed although intercepted");
  }

  @Test
  public void testNotInterceptedCommand() {
    dispatcher.dispatch("nointercept", CommandContext.create());
    assertTrue(getSubject().isExecuted(), "Command was not executed");
  }

}
