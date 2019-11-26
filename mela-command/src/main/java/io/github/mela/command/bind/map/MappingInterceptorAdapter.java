package io.github.mela.command.bind.map;

import io.github.mela.command.core.CommandContext;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public abstract class MappingInterceptorAdapter<T extends Annotation> implements MappingInterceptor<T> {

  @Override
  public void preprocess(@Nonnull T annotation, @Nonnull MappingProcess process, @Nonnull CommandContext context) {

  }

  @Override
  public void postprocess(@Nonnull T annotation, @Nonnull MappingProcess process, @Nonnull CommandContext context) {

  }
}
