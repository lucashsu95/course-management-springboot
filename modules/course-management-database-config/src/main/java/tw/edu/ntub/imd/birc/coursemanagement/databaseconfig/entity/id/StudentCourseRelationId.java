package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseRelationId implements Serializable {
    private String studentId;
    private String courseId;
}
