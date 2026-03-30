package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Relation;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.RelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.RelationTransformer;

import javax.annotation.Nonnull;

@Component
public class RelationTransformerImpl implements RelationTransformer {
    @Nonnull
    @Override
    public Relation transferToEntity(@Nonnull RelationBean bean){
        Relation relation = new Relation();
        Student student = new Student();
        student.setId(bean.getStudentId());
        Course course = new Course();
        course.setId(bean.getCourseId());
        relation.setStudent(student);
        relation.setCourse(course);
        relation.setGrade(bean.getGrade());
        relation.setRemark(bean.getRemark());

        return relation;
    }
    @Nonnull
    @Override
    public RelationBean transferToBean(@Nonnull Relation relation){
        RelationBean bean = JavaBeanUtils.copy(relation , new RelationBean());
        if (relation.getStudent().getId() != null){
            bean.setStudentId(relation.getStudent().getId());
        }
        if (relation.getCourse().getId() != null){
            bean.setCourseId(relation.getCourse().getId());
        }

        return bean;
    }
}
