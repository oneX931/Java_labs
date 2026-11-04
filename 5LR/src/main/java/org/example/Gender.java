package org.example;

enum Gender {
    MALE("мужской"),
    FEMALE("женский");

    private final String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
