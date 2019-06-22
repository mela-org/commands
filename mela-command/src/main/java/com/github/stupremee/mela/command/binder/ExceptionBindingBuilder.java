package com.github.stupremee.mela.command.binder;

import com.github.stupremee.mela.command.handler.ExceptionHandler;

public interface ExceptionBindingBuilder<T extends Throwable> {

  ExceptionBindingBuilder<T> ignoringInheritance();

  CommandBindingNode with(ExceptionHandler<T> handler);

}
