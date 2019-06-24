package com.github.stupremee.mela.command.internal.empty;

import com.github.stupremee.mela.command.binding.ExceptionBindings;
import com.github.stupremee.mela.command.binding.InterceptorBindings;
import com.github.stupremee.mela.command.binding.ParameterBindings;
import com.github.stupremee.mela.command.compile.CommandTree;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
final class EmptyGroup implements CommandTree.Group {

  public static final EmptyGroup INSTANCE = new EmptyGroup();

  private EmptyGroup() {
  }

  @Override
  public CommandTree.Group getParent() {
    return null;
  }

  @Override
  public String primaryAlias() {
    return null;
  }

  @Nonnull
  @Override
  public Set<CommandTree.Group> getChildren() {
    return Collections.emptySet();
  }

  @Nonnull
  @Override
  public Set<String> getAliases() {
    return Collections.emptySet();
  }

  @Nonnull
  @Override
  public ParameterBindings getParameterBindings() {
    return EmptyBindings::noMapper;
  }

  @Nonnull
  @Override
  public InterceptorBindings getInterceptorBindings() {
    return EmptyBindings::noInterceptor;
  }

  @Nonnull
  @Override
  public ExceptionBindings getExceptionBindings() {
    return EmptyBindings::noHandler;
  }

  @Nonnull
  @Override
  public Collection<?> getCommandObjects() {
    return Collections.emptySet();
  }
}
