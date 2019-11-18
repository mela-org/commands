package io.github.mela.command.bind;

import io.github.mela.command.core.CommandContext;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;

public interface CommandInterceptor<T extends Annotation> {

  boolean intercept(@Nonnull T annotation, @Nonnull CommandContext context) throws Throwable;

}