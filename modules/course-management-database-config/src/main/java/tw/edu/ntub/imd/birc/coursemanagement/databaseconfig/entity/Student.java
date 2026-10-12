package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.Config;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "save")
@Table(name = "student", schema = Config.DATABASE_NAME)
public class Student implements Persistable<String> {
    @Transient
    private Boolean save;

    @Id
    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;
}
