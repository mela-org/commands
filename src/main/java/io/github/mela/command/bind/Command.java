package io.github.mela.command.bind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
  String[] labels();

  String desc() default "N/A";

  String help() default "N/A";

  String usage() default "N/A";
}
