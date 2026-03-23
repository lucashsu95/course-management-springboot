package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses",schema = "coursemanagement")
@Data
public class Course {
    @Id
    @Column(name = "id",nullable = false)
    private String id;
    @Column(name = "courseName",nullable = false)
    private String courseName;
    @Column(name = "courseCredit",nullable = false)
    private Integer courseCredit;

}
