package io.github.mela.command.bind;

import io.github.mela.command.TestAnnotation;
import io.github.mela.command.TestException;
import io.github.mela.command.TestModule;
import io.github.mela.command.bind.map.ArgumentMapper;
import io.github.mela.command.guice.CommandBinder;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
final class OverrideTestModule extends TestModule {

  static final Object ADDITIONAL_COMMAND = new NoOpCommand() {};

  private static final ArgumentMapper<Object> MAPPER_OVERRIDE = (o, c) -> null;
  private static final CommandInterceptor<TestAnnotation> INTERCEPTOR_OVERRIDE = (c) -> true;
  private static final ExceptionHandler<TestException> HANDLER_OVERRIDE = (t, c) -> {};

  OverrideTestModule() {
    super(ADDITIONAL_COMMAND);
  }

  @Override
  protected void configureCommandBindings(CommandBinder binder) {
    binder.root()
        .group("override")
        .bindParameter(Object.class).toMapper(MAPPER_OVERRIDE)
        .interceptAt(TestAnnotation.class).with(INTERCEPTOR_OVERRIDE)
        .handle(TestException.class).with(HANDLER_OVERRIDE);
  }
}