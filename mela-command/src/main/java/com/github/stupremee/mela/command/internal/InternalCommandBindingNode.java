package com.github.stupremee.mela.command.internal;

import com.github.stupremee.mela.command.binding.CommandBindingNode;
import com.github.stupremee.mela.command.binding.ExceptionBindingBuilder;
import com.github.stupremee.mela.command.binding.InterceptorBindingBuilder;
import com.github.stupremee.mela.command.binding.ParameterBindingBuilder;
import com.github.stupremee.mela.command.compile.CommandTree;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

import java.lang.annotation.Annotation;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
final class InternalCommandBindingNode implements CommandBindingNode {

  private final InternalCommandBindingNode parent;
  private final CommandMultibinder multibinder;
  private final RecursiveCommandTree tree;

  InternalCommandBindingNode(CommandMultibinder multibinder) {
    this.parent = null;
    this.multibinder = multibinder;
    this.tree = new RecursiveCommandTree();
    configureTree();
  }

  private void configureTree() {
    Binder binder = multibinder.binder();
    binder.requestInjection(tree);
    Multibinder.newSetBinder(binder, CommandTree.class).addBinding().toInstance(tree);
  }

  private InternalCommandBindingNode(InternalCommandBindingNode parent) {
    this.parent = parent;
    this.multibinder = parent.multibinder;
    this.tree = parent.tree;
  }

  @Override
  public CommandBindingNode group(String... aliases) {
    tree.stepDownOrCreate(Set.of(aliases));
    return new InternalCommandBindingNode(this);
  }

  @Override
  public CommandBindingNode parent() {
    checkState(parent != null, "Cannot go to parent, this is the highest node");
    return parent;
  }

  @Override
  public CommandBindingNode add(Class<?> commandClass) {
    tree.addCommand(commandClass);
    multibinder.commandObjectBinder().addBinding().to(commandClass);
    return this;
  }

  @Override
  public CommandBindingNode add(Object command) {
    tree.addCommand(command.getClass());
    multibinder.commandObjectBinder().addBinding().toInstance(command);
    return this;
  }

  @Override
  public <T extends Annotation> InterceptorBindingBuilder<T> interceptAt(Class<T> annotationType) {
    return new InternalInterceptorBindingBuilder<>(this, tree, multibinder.interceptorBinder(), annotationType);
  }

  @Override
  public <T extends Throwable> ExceptionBindingBuilder<T> handle(Class<T> exceptionType) {
    return new InternalExceptionBindingBuilder<>(this, tree, multibinder.handlerBinder(), exceptionType);
  }

  @Override
  public <T> ParameterBindingBuilder<T> bindParameter(Class<T> parameterType) {
    return bindParameter(TypeLiteral.get(parameterType));
  }

  @Override
  public <T> ParameterBindingBuilder<T> bindParameter(TypeLiteral<T> literal) {
    return new InternalParameterBindingBuilder<>(this, tree, multibinder.mapperBinder(), literal);
  }

}
