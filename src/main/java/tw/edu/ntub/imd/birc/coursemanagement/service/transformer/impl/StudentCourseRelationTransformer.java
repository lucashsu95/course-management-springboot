package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentCourseRelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.StudentCourseRelation;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.BeanEntityTransformer;

import javax.annotation.Nonnull;

@Component
public class StudentCourseRelationTransformer implements BeanEntityTransformer<StudentCourseRelationBean, StudentCourseRelation> {
    @Nonnull
    @Override
    public StudentCourseRelation transferToEntity(@Nonnull StudentCourseRelationBean bean) {
        StudentCourseRelation relation = new StudentCourseRelation();
        relation.setStudentId(bean.getStudentId());
        relation.setCourseId(bean.getCourseId());
        relation.setGrade(bean.getGrade());
        relation.setRemark(bean.getRemark());
        relation.setCreateDate(bean.getCreateDate());
        return relation;
    }

    @Nonnull
    @Override
    public StudentCourseRelationBean transferToBean(@Nonnull StudentCourseRelation relation) {
        StudentCourseRelationBean bean = new StudentCourseRelationBean();
        bean.setStudentId(relation.getStudentId());
        bean.setCourseId(relation.getCourseId());
        bean.setGrade(relation.getGrade());
        bean.setRemark(relation.getRemark());
        bean.setCreateDate(relation.getCreateDate());
        Course course = relation.getCourse();
        if (course != null && Hibernate.isInitialized(course)) {
            bean.setCourseName(course.getName());
            bean.setCourseCredit(course.getCredit());
        }
        return bean;
    }
}
