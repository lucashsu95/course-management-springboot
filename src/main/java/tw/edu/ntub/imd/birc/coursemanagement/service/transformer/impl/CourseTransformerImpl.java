package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.CourseTransformer;

import javax.validation.constraints.NotNull;

@Component
public class CourseTransformerImpl implements CourseTransformer {
    @NotNull
    @Override
    public Course transferToEntity(@NotNull CourseBean CourseBean){
        return JavaBeanUtils.copy(CourseBean,new Course());
    }

    @NotNull
    @Override
    public CourseBean transferToBean(@NotNull Course Course){
        return JavaBeanUtils.copy(Course , new CourseBean());
    }
}
