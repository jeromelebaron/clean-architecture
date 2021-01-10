package fr.lebaronjerome.todolist.domain;

import java.time.LocalDateTime;

public class Task {
    private long uniqueIdentifier;
    private String name;
    private boolean completed = false;
    private LocalDateTime dueDate;

    public Task(final String name) {
        this.name = name;
    }

    public Task(final String name,
                final LocalDateTime dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public void completeTask() {
        completed = true;
    }

    public boolean isOverDue() {
        if (dueDate == null) {
            return true;
        }
        return dueDate.isBefore(LocalDateTime.now());
    }

    public void updateDueDate(final LocalDateTime newDueDate) {
        dueDate = newDueDate;
    }

    public void removeDueDate() {
        dueDate = null;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
