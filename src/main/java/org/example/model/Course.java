package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    private int duration;
    @Column(name = "local_date", nullable = false)
    private LocalDate createAt;
    @Column(name = "image_link", nullable = false)
    private String imageLink;
    private String description;

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH},mappedBy = "course",fetch = FetchType.EAGER)
    private List<Instructor> instructor;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.REFRESH},mappedBy = "course")
    private List<Lesson> lesson;

    @Override
    public String toString() {
        return id+"  "+courseName+"  "+duration+"  "+createAt+ "  "+description+ " "+imageLink;
    }

    public void setInstructor(Instructor instructor0){
        if (instructor == null){
            instructor = new ArrayList<>();
        }
        instructor.add(instructor0);
    }
}
