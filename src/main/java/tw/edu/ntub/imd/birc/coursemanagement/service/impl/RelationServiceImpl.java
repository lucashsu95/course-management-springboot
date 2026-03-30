package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CoursesDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.RelationDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentsDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Relation;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.RelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.exception.DuplicateException;
import tw.edu.ntub.imd.birc.coursemanagement.exception.NotFoundException;
import tw.edu.ntub.imd.birc.coursemanagement.service.RelationService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.RelationTransformer;

@Service
public class RelationServiceImpl extends BaseServiceImpl<RelationBean , Relation , String> implements RelationService {
    private final RelationDAO dao;
    private final RelationTransformer transformer;
    private final StudentsDAO studentsDAO;
    private final CoursesDAO coursesDAO;

    public RelationServiceImpl(RelationDAO dao , RelationTransformer transformer, StudentsDAO studentsDAO, CoursesDAO coursesDAO){
        super(dao , transformer);
        this.dao = dao;
        this.transformer = transformer;
        this.studentsDAO = studentsDAO;
        this.coursesDAO = coursesDAO;
    }

    @Override
    public RelationBean save(RelationBean relationBean){
        String studentId = relationBean.getStudentId();
        String courseId = relationBean.getCourseId();
        Student student = studentsDAO.findById(studentId).orElseThrow(() -> new NotFoundException("找不到學生"));
        Course course = coursesDAO.findById(courseId).orElseThrow(() -> new NotFoundException("找不到課程"));

        if (dao.findByStudent_IdAndCourse_Id(studentId, courseId).isPresent()) {
            throw new DuplicateException("學生已選修該課程，請勿重複選課");
        }
        Relation relation = new Relation();
        relation.setStudent(student);
        relation.setCourse(course);
        relation.setGrade(relationBean.getGrade());
        relation.setRemark(relationBean.getRemark());

        return transformer.transferToBean(dao.save(relation));
    }

    @Override
    public void msgFunc(String st){}
}
