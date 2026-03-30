package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students" ,schema = "coursemanagement")
@Data
public class Student {
    @Id
    @Column(name = "id",nullable = false)
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
}
