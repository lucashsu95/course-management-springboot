package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntub.imd.birc.coursemanagement.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CourseDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.exception.DuplicateCreateException;
import tw.edu.ntub.imd.birc.coursemanagement.service.CourseService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl.CourseTransformer;

@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseBean, Course, String> implements CourseService {
    private final CourseDAO courseDAO;
    private final CourseTransformer transformer;

    public CourseServiceImpl(CourseDAO courseDAO, CourseTransformer transformer) {
        super(courseDAO, transformer);
        this.courseDAO = courseDAO;
        this.transformer = transformer;
    }

    @Transactional
    @Override
    public CourseBean save(CourseBean courseBean) {
        if (courseDAO.existsById(courseBean.getId())) {
            throw new DuplicateCreateException("課程代碼重複");
        }
        Course course = courseDAO.save(transformer.transferToEntity(courseBean));
        return transformer.transferToBean(course);
    }
}
