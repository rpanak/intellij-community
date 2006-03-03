package com.intellij.codeInspection.ui;

import com.intellij.openapi.vcs.FileStatus;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Enumeration;

/**
 * @author max
 */
public abstract class InspectionTreeNode extends DefaultMutableTreeNode {
  protected InspectionTreeNode(Object userObject) {
    super(userObject);
  }

  public abstract Icon getIcon(boolean expanded);

  public int getProblemCount() {
    int sum = 0;
    Enumeration children = children();
    while (children.hasMoreElements()) {
      InspectionTreeNode child = (InspectionTreeNode)children.nextElement();
      sum += child.getProblemCount();
    }
    return sum;
  }

  public boolean isValid() {
    return true;
  }

  public boolean isResolved(){
    return false;
  }

  public boolean appearsBold() {
    return false;
  }

  public boolean isWritable() {
    return true;
  }

  public FileStatus getNodeStatus(){
    return FileStatus.NOT_CHANGED;
  }
}
