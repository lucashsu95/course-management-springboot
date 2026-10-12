package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.BeanEntityTransformer;

import javax.annotation.Nonnull;

@Component
public class StudentTransformer implements BeanEntityTransformer<StudentBean, Student> {
    @Nonnull
    @Override
    public Student transferToEntity(@Nonnull StudentBean studentBean) {
        return JavaBeanUtils.copy(studentBean, new Student());
    }

    @Nonnull
    @Override
    public StudentBean transferToBean(@Nonnull Student student) {
        return JavaBeanUtils.copy(student, new StudentBean());
    }
}
