package com.example;

public class Value {
    public enum Type {
        INT, DOUBLE, STRING, BOOLEAN
    }

    private final Type type;
    private final Object value;

    public Value(int value) {
        this.type = Type.INT;
        this.value = value;
    }

    public Value(double value) {
        this.type = Type.DOUBLE;
        this.value = value;
    }

    public Value(String value) {
        this.type = Type.STRING;
        this.value = value;
    }

    public Value(boolean value) {
        this.type = Type.BOOLEAN;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public int asInt() {
        switch (type) {
            case INT:
                return (Integer) value;
            case DOUBLE:
                return ((Double) value).intValue();
            case STRING:
                try {
                    return Integer.parseInt((String) value);
                } catch (NumberFormatException e) {
                    return 0;
                }
            case BOOLEAN:
                return (Boolean) value ? 1 : 0;
            default:
                return 0;
        }
    }

    public double asDouble() {
        switch (type) {
            case INT:
                return (Integer) value;
            case DOUBLE:
                return (Double) value;
            case STRING:
                try {
                    return Double.parseDouble((String) value);
                } catch (NumberFormatException e) {
                    return 0.0;
                }
            case BOOLEAN:
                return (Boolean) value ? 1.0 : 0.0;
            default:
                return 0.0;
        }
    }

    public String asString() {
        switch (type) {
            case INT:
            case DOUBLE:
            case BOOLEAN:
                return value.toString();
            case STRING:
                return (String) value;
            default:
                return "";
        }
    }

    public boolean asBoolean() {
        switch (type) {
            case INT:
                return (Integer) value != 0;
            case DOUBLE:
                return (Double) value != 0.0;
            case STRING:
                return !((String) value).isEmpty();
            case BOOLEAN:
                return (Boolean) value;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return asString();
    }
} 
