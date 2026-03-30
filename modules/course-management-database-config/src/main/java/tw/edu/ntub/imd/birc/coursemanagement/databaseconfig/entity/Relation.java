package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_course_relation",schema = "coursemanagement")
@Data
public class Relation {
    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

    @Column(name = "grade",nullable = true)
    private Integer grade;
    @Column(name = "remark",nullable = true)
    private String remark;

    @Column(name = "createDate" ,nullable = true)
    private LocalDateTime createDate;

    @PrePersist
    public void prePersist(){
        this.createDate = LocalDateTime.now();
    }
}
