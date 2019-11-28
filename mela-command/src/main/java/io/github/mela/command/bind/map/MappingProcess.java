package io.github.mela.command.bind.map;

import io.github.mela.command.bind.parameter.CommandParameter;
import io.github.mela.command.core.CommandContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public final class MappingProcess {

  private final CommandParameter parameter;
  private final ArgumentMapper<?> mapper;
  private final ArgumentChain chain;
  private final CommandContext context;

  private boolean isSet;

  private Throwable error;
  private Object value;
  private Supplier<String> argumentToMap;

  public MappingProcess(@Nonnull CommandParameter parameter,
                        @Nonnull ArgumentMapper<?> mapper,
                        @Nonnull ArgumentChain chain,
                        @Nonnull CommandContext context) {
    this.mapper = mapper;
    this.chain = checkNotNull(chain);
    this.parameter = checkNotNull(parameter);
    this.context = checkNotNull(context);
    this.isSet = false;
    this.value = null;
    this.error = null;
    this.argumentToMap = () -> mapper.prepare(chain);
  }

  public void fail(@Nonnull Throwable error) {
    checkNotNull(error);
    if (this.error == null) {
      this.error = error;
    }
  }

  // TODO: 26.11.2019 maybe reset argument chain as side effect
  public void fixError() {
    this.error = null;
  }

  public void setValue(@Nullable Object value) {
    checkState(!isErroneous(), "You may not set a value before resolving existing errors");
    this.value = value;
    this.isSet = true;
  }

  public void unset() {
    this.isSet = false;
  }

  public boolean isSet() {
    return isSet;
  }

  @Nullable
  public Object getValue() {
    checkState(isSet, "No value set!");
    return value;
  }

  public boolean isErroneous() {
    return error != null;
  }

  @Nonnull
  public Throwable getError() {
    checkState(isErroneous(), "This process is not erroneous");
    return error;
  }

  @Nonnull
  public String getArgumentToMap() {
    return argumentToMap.get();
  }

  public void setArgumentToMap(@Nonnull Supplier<String> argumentToMap) {
    this.argumentToMap = checkNotNull(argumentToMap);
  }

  @Nonnull
  public ArgumentMapper<?> getMapper() {
    return mapper;
  }

  @Nonnull
  public ArgumentChain getArguments() {
    return chain;
  }

  @Nonnull
  public CommandContext getContext() {
    return context;
  }

  @Nonnull
  public CommandParameter getParameter() {
    return parameter;
  }
}
