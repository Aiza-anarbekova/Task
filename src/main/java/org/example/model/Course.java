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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   // @SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

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
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.PERSIST},mappedBy = "course",fetch = FetchType.EAGER)
    private List<Instructor> instructor;

    public void addInstructor(Instructor instructor1){
        this.instructor.add(instructor1);

    }


    public void  removeInstructor(Instructor instructor1){
        this.instructor.remove(instructor1);
    }

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,
            CascadeType.DETACH,CascadeType.REFRESH},mappedBy = "course",fetch = FetchType.LAZY)
    private List<Lesson> lesson;

    @Override
    public String toString() {
        return id+"  "+courseName+"  "+duration+"  "+createAt+ "  "+description+ " "+imageLink;
    }

//    public void setInstructor(Instructor instructor0){
//        instructor.add(instructor0);
//    }
    public void setLesson(Lesson lesson1){
        lesson.add(lesson1);
    }
}
