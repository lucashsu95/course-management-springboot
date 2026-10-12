package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.Config;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.id.StudentCourseRelationId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"save", "student", "course"})
@ToString(exclude = {"student", "course"})
@IdClass(StudentCourseRelationId.class)
@Table(name = "student_course_relation", schema = Config.DATABASE_NAME)
public class StudentCourseRelation implements Persistable<StudentCourseRelationId> {
    @Transient
    private Boolean save;

    @Id
    @Column(name = "student_id", length = 20, nullable = false)
    private String studentId;

    @Id
    @Column(name = "course_id", length = 20, nullable = false)
    private String courseId;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "remark", length = 255)
    private String remark;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    @Override
    public StudentCourseRelationId getId() {
        if (studentId == null || courseId == null) {
            return null;
        }
        return new StudentCourseRelationId(studentId, courseId);
    }
}
