package org.launchcode.techjobs.oo;

public class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
