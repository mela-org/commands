package io.github.mela.command.bind;

import io.github.mela.command.core.Arguments;
import io.github.mela.command.core.CommandContext;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;

@FunctionalInterface
public interface CommandInterceptor<T extends Annotation> {

  void intercept(@Nonnull T annotation, @Nonnull Arguments arguments, @Nonnull CommandContext context);

}
