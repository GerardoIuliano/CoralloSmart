package org.corallosmart.actions.actionsUtils;

/**
 *  @author theboys
 */
public interface ActionFactory {
  ActionStrategy create(String type);
}
