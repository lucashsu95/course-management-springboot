package tw.edu.ntub.imd.birc.coursemanagement.service;

import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentCourseRelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.id.StudentCourseRelationId;

import java.util.List;

public interface StudentCourseRelationService extends BaseService<StudentCourseRelationBean, StudentCourseRelationId> {
    List<StudentCourseRelationBean> searchByStudentId(String studentId);

    StudentCourseRelationBean createRelation(String studentId, String courseId, StudentCourseRelationBean bean);

    StudentCourseRelationBean updateGradeAndRemark(String studentId, String courseId, StudentCourseRelationBean bean);
}
