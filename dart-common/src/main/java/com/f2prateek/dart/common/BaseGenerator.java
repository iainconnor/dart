package com.f2prateek.dart.common;

import javax.lang.model.type.TypeMirror;

/**
 * Base class of code generators.
 * They generate java code.
 */
public abstract class BaseGenerator {

  /**
   * Create all Java code
   * @return
   */
  public abstract String brewJava();
  public abstract String getFqcn();

  public String getType(TypeMirror type) {
    if (type.getKind().isPrimitive()) {
      // Get wrapper for primitive types
      switch (type.getKind()) {
        case BOOLEAN:
          return "java.lang.Boolean";
        case BYTE:
          return "java.lang.Byte";
        case SHORT:
          return "java.lang.Short";
        case INT:
          return "java.lang.Integer";
        case LONG:
          return "java.lang.Long";
        case CHAR:
          return "java.lang.Character";
        case FLOAT:
          return "java.lang.Float";
        case DOUBLE:
          return "java.lang.Double";
        default:
          // Shouldn't happen
          throw new RuntimeException();
      }
    } else {
      return type.toString();
    }
  }

}
