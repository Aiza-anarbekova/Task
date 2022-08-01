package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
            //, generator = "player_generator")
   // @SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    private String name;
    @Column(name = "video_Link")
    private String videoLink;

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn
    private Course course;

    @OneToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "lesson")
    private List<Task> task= new ArrayList<>();

    public void addTask(Task task1){
        this.task.add(task1);
    }


    public  void  setTask(Task task1){
//        if (task==null){
//            task= new ArrayList<>();
//        }
        task.add(task1);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}
