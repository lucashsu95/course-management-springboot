package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.coursemanagement.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.BeanEntityTransformer;

import javax.annotation.Nonnull;

@Component
public class CourseTransformer implements BeanEntityTransformer<CourseBean, Course> {
    @Nonnull
    @Override
    public Course transferToEntity(@Nonnull CourseBean courseBean) {
        return JavaBeanUtils.copy(courseBean, new Course());
    }

    @Nonnull
    @Override
    public CourseBean transferToBean(@Nonnull Course course) {
        return JavaBeanUtils.copy(course, new CourseBean());
    }
}
