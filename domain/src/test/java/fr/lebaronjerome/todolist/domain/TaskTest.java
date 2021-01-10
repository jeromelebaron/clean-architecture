package fr.lebaronjerome.todolist.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {

    @Test
    void completeTask() {
        // Given
        final Task task = new Task("");
        assertThat(task.isCompleted()).isFalse();
        // When
        task.completeTask();
        // Then
        assertThat(task.isCompleted()).isTrue();
    }

    @Test
    void isOverdueWithPastDueDate() {
        // Given
        final LocalDateTime overdueDate = LocalDateTime.now().minusSeconds(1);
        final Task overdueTask = new Task("", overdueDate);
        // When
        final boolean overdue = overdueTask.isOverDue();
        // Then
        assertThat(overdue).isTrue();
    }

    @Test
    void isNotOverdueWithFutureDueDate() {
        // Given
        final LocalDateTime notOverdueDate = LocalDateTime.now().plusSeconds(1);
        final Task notOverdueTask = new Task("", notOverdueDate);
        // When
        final boolean overdue = notOverdueTask.isOverDue();
        // Then
        assertThat(overdue).isFalse();
    }

    @Test
    void isNotOverdueWithoutDueDate() {
        // Given
        final Task task = new Task("");
        // When
        final boolean notOverdue = task.isOverDue();
        // Then
        assertThat(notOverdue).isTrue();
    }

    @Test
    void updateDueDate() {
        // Given
        final Task task = new Task("");
        assertThat(task.getDueDate()).isNull();
        // When
        final LocalDateTime now = LocalDateTime.now();
        task.updateDueDate(now);
        // Then
        assertThat(task.getDueDate())
                .isNotNull()
                .isEqualTo(now);
    }

    @Test
    void removeDueDate() {
        // Given
        final Task task = new Task("", LocalDateTime.now());
        assertThat(task.getDueDate()).isNotNull();
        // When
        task.removeDueDate();
        // Then
        assertThat(task.getDueDate()).isNull();
    }
}
