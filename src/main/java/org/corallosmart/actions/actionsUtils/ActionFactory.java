package org.corallosmart.actions.actionsUtils;

/**
 *  @author team
 */
public interface ActionFactory {
  ActionStrategy create(String type);
}
