package org.example.nadeem.config;

public enum ID_Config {
    ID("group_id"),
    CONFIG("localhost:9092");

    private final String value;

    ID_Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
