package com.github.stupremee.mela.command.compile;

import com.github.stupremee.mela.command.CommandGroup;

import javax.annotation.Nonnull;

// @ImplementedBy
public interface CommandCompiler {

  @Nonnull
  CommandGroup compile(@Nonnull UncompiledGroup root);

}
