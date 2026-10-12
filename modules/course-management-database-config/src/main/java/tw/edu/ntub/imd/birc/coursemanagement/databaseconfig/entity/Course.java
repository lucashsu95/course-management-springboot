package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.Config;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "save")
@Table(name = "course", schema = Config.DATABASE_NAME)
public class Course implements Persistable<String> {
    @Transient
    private Boolean save;

    @Id
    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "credit", nullable = false)
    private Integer credit;
}
