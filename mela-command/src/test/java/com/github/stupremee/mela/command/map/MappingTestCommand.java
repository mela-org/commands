package com.github.stupremee.mela.command.map;

import com.github.stupremee.mela.command.Command;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
final class MappingTestCommand {

  private ObjectWrapping simpleResult;
  private GenericWrapping<String> genericResult;

  @Command(aliases = "simple")
  public void executeSimple(ObjectWrapping wrapping) {
    this.simpleResult = wrapping;
  }

  public ObjectWrapping getSimpleResult() {
    return simpleResult;
  }

  @Command(aliases = "generic")
  public void executeGeneric(GenericWrapping<String> wrapping) {
    this.genericResult = wrapping;
  }

  public GenericWrapping<String> getGenericResult() {
    return genericResult;
  }
}