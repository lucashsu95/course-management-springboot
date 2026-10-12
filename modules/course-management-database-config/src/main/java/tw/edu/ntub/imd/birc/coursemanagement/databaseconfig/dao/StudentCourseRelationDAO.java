package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.StudentCourseRelation;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.id.StudentCourseRelationId;

import java.util.List;

@Repository
public interface StudentCourseRelationDAO extends BaseDAO<StudentCourseRelation, StudentCourseRelationId> {
    @Query("SELECT r FROM StudentCourseRelation r JOIN FETCH r.course WHERE r.studentId = :studentId ORDER BY r.createDate, r.courseId")
    List<StudentCourseRelation> findByStudentIdFetchCourse(@Param("studentId") String studentId);
}
