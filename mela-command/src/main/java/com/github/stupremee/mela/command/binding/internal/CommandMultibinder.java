package com.github.stupremee.mela.command.binding.internal;

import com.github.stupremee.mela.command.ExceptionHandler;
import com.github.stupremee.mela.command.Interceptor;
import com.github.stupremee.mela.command.inject.annotation.Commands;
import com.github.stupremee.mela.command.inject.annotation.Handlers;
import com.github.stupremee.mela.command.inject.annotation.Interceptors;
import com.github.stupremee.mela.command.inject.annotation.Mappers;
import com.github.stupremee.mela.command.mapping.ArgumentMapper;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
final class CommandMultibinder {

  private static final TypeLiteral<ArgumentMapper<?>> MAPPER_LITERAL = new TypeLiteral<>() {};
  private static final TypeLiteral<Interceptor<?>> INTERCEPTOR_LITERAL = new TypeLiteral<>() {};
  private static final TypeLiteral<ExceptionHandler<?>> HANDLER_LITERAL = new TypeLiteral<>() {};

  private final Binder binder;

  private Multibinder<ArgumentMapper<?>> mapperBinder;
  private Multibinder<Object> commandObjectBinder;
  private Multibinder<Interceptor<?>> interceptorBinder;
  private Multibinder<ExceptionHandler<?>> handlerBinder;

  CommandMultibinder(Binder binder) {
    this.binder = binder;
    commandObjectBinder = Multibinder.newSetBinder(binder, Object.class, Commands.class);
    mapperBinder = Multibinder.newSetBinder(binder, MAPPER_LITERAL, Mappers.class);
    interceptorBinder = Multibinder.newSetBinder(binder, INTERCEPTOR_LITERAL, Interceptors.class);
    handlerBinder = Multibinder.newSetBinder(binder, HANDLER_LITERAL, Handlers.class);
  }

  Multibinder<Object> commandObjectBinder() {
    return commandObjectBinder;
  }

  Multibinder<ArgumentMapper<?>> mapperBinder() {
    return mapperBinder;
  }

  Multibinder<Interceptor<?>> interceptorBinder() {
    return interceptorBinder;
  }

  Multibinder<ExceptionHandler<?>> handlerBinder() {
    return handlerBinder;
  }

  Binder binder() {
    return binder;
  }

}