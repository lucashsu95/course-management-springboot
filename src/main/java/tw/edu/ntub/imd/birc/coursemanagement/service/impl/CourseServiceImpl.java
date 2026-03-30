package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CoursesDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.exception.DuplicateException;
import tw.edu.ntub.imd.birc.coursemanagement.service.CourseService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.CourseTransformer;

@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseBean, Course,String> implements CourseService {
    private final CoursesDAO dao;
    private final CourseTransformer transformer;

    public CourseServiceImpl(CoursesDAO dao , CourseTransformer transformer){
        super(dao , transformer);
        this.dao = dao;
        this.transformer = transformer;
    }
    @Override
    public CourseBean save(CourseBean courseBean){
        if(dao.existsById(courseBean.getId())){
            throw new DuplicateException("課程代碼重複");
        }

        Course course = transformer.transferToEntity(courseBean);
        dao.save(course);
        return courseBean;
    }

    @Override
    public void msgFunc(String st){}
}
