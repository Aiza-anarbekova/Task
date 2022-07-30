package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    private String name;
    private LocalDate deadline;
    @Column(length = 1000000)
    private String task;

    public Task(String name, LocalDate deadline, String task) {
        this.name = name;
        this.deadline = deadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", task='" + task + '\'' +
                '}';
    }
}
