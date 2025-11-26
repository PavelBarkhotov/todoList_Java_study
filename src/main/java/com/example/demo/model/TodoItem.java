package com.example.demo.model;

public class TodoItem {
    private Long id;
    private String title;
    private boolean completed;

    //Пустой конструктор необходим для сериализации/десериализации (например, Jackson, Spring).
    //Default constructor required for frameworks (Jackson, Spring).
    public TodoItem() {} // Конструктор по умолчанию

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
