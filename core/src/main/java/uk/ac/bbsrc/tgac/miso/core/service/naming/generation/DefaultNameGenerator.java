package uk.ac.bbsrc.tgac.miso.core.service.naming.generation;

import uk.ac.bbsrc.tgac.miso.core.data.Nameable;
import uk.ac.bbsrc.tgac.miso.core.exception.MisoNamingException;
import uk.ac.bbsrc.tgac.miso.core.service.naming.DefaultMisoEntityPrefix;

public class DefaultNameGenerator implements NameGenerator<Nameable> {

  @Override
  public String generate(Nameable nameable) throws MisoNamingException {
    for (DefaultMisoEntityPrefix prefix : DefaultMisoEntityPrefix.values()) {
      if (prefix.getClass().isAssignableFrom(nameable.getClass())) {
        return prefix.name() + nameable.getId();
      }
    }
    throw new MisoNamingException("Cannot generate a MISO name from an object of type: " + nameable.getClass().getSimpleName());
  }
}
