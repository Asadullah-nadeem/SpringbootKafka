package org.example.nadeem.config;

import lombok.Getter;

@Getter
public enum ID_Config {


    Id("group_id"),
    CONFIG("localhost:9092");

    private final String value;

    ID_Config(String value) {
        this.value = value;
    }

}
