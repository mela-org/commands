package io.github.mela.command.provided.interceptors;

import io.github.mela.command.bind.map.MappingInterceptorAdapter;
import io.github.mela.command.bind.map.MappingProcess;
import io.github.mela.command.core.CommandArguments;
import io.github.mela.command.core.CommandContext;
import javax.annotation.Nonnull;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class RemainingInterceptor extends MappingInterceptorAdapter<Remaining> {

  @Override
  public void preprocess(
      @Nonnull Remaining annotation,
      @Nonnull MappingProcess process,
      @Nonnull CommandContext context
  ) {
    CommandArguments arguments = process.getArguments();
    StringBuilder builder = new StringBuilder();
    while (arguments.hasNext()) {
      if (arguments.isNextUnescaped('"')) {
        builder.append('\\');
      }
      builder.append(arguments.next());
    }
    process.requestMapping(CommandArguments.of("\"" + builder.toString().trim() + "\""));
  }

}