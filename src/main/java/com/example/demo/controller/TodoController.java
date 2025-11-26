package com.example.demo.controller;

import com.example.demo.model.TodoItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    // Открыто для примеров/учебных целей, доступ осуществляется напрямую из других контроллеров.
    public static final List<TodoItem> items = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @GetMapping
    public List<TodoItem> getAll() {
        return items;
    }

    @PostMapping
    public TodoItem add(@RequestBody TodoItem item) {
        item.setId(idGenerator.incrementAndGet());
        item.setCompleted(false);
        items.add(item);
        return item;
    }

    @PutMapping("/{id}")
    public TodoItem update(@PathVariable Long id, @RequestBody TodoItem updated) {
        for (TodoItem item : items) {
            if (item.getId().equals(id)) {
                item.setTitle(updated.getTitle());
                item.setCompleted(updated.isCompleted());
                return item;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}
