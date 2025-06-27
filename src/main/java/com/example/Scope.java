package com.example;

import java.util.HashMap;
import java.util.Map;

public class Scope {
    private final Map<String, Value> variables;
    private final Scope parent;

    public Scope() {
        this(null);
    }

    public Scope(Scope parent) {
        this.variables = new HashMap<>();
        this.parent = parent;
    }

    public void setVariable(String name, Value value) {
        variables.put(name, value);
    }

    public Value getVariable(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        if (parent != null) {
            return parent.getVariable(name);
        }
        throw new RuntimeException("Variable '" + name + "' is not defined");
    }

    public boolean hasVariable(String name) {
        if (variables.containsKey(name)) {
            return true;
        }
        if (parent != null) {
            return parent.hasVariable(name);
        }
        return false;
    }

    public Scope getParent() {
        return parent;
    }
} 
