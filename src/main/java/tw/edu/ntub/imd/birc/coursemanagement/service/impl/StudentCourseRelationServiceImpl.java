package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentCourseRelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CourseDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentCourseRelationDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.StudentCourseRelation;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.id.StudentCourseRelationId;
import tw.edu.ntub.imd.birc.coursemanagement.exception.ConflictException;
import tw.edu.ntub.imd.birc.coursemanagement.exception.NotFoundException;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentCourseRelationService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl.StudentCourseRelationTransformer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class StudentCourseRelationServiceImpl
        extends BaseServiceImpl<StudentCourseRelationBean, StudentCourseRelation, StudentCourseRelationId>
        implements StudentCourseRelationService {
    private static final ZoneId TAIPEI = ZoneId.of("Asia/Taipei");

    private final StudentCourseRelationDAO relationDAO;
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private final StudentCourseRelationTransformer transformer;

    public StudentCourseRelationServiceImpl(StudentCourseRelationDAO relationDAO,
                                            StudentDAO studentDAO,
                                            CourseDAO courseDAO,
                                            StudentCourseRelationTransformer transformer) {
        super(relationDAO, transformer);
        this.relationDAO = relationDAO;
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.transformer = transformer;
    }

    @Override
    public List<StudentCourseRelationBean> searchByStudentId(String studentId) {
        checkStudentExists(studentId);
        return CollectionUtils.map(relationDAO.findByStudentIdFetchCourse(studentId), transformer::transferToBean);
    }

    @Transactional
    @Override
    public StudentCourseRelationBean save(StudentCourseRelationBean bean) {
        return createRelation(bean.getStudentId(), bean.getCourseId(), bean);
    }

    @Transactional
    @Override
    public StudentCourseRelationBean createRelation(String studentId, String courseId, StudentCourseRelationBean bean) {
        checkStudentExists(studentId);
        if (!courseDAO.existsById(courseId)) {
            throw new NotFoundException("找不到課程");
        }
        StudentCourseRelationId id = new StudentCourseRelationId(studentId, courseId);
        if (relationDAO.existsById(id)) {
            throw new ConflictException("學生已選修該課程，請勿重複選課");
        }
        StudentCourseRelation relation = new StudentCourseRelation();
        relation.setStudentId(studentId);
        relation.setCourseId(courseId);
        if (bean != null) {
            relation.setGrade(bean.getGrade());
            relation.setRemark(bean.getRemark());
        }
        relation.setCreateDate(LocalDateTime.now(TAIPEI).truncatedTo(ChronoUnit.SECONDS));
        return transformer.transferToBean(relationDAO.save(relation));
    }

    @Transactional
    @Override
    public StudentCourseRelationBean updateGradeAndRemark(String studentId, String courseId, StudentCourseRelationBean bean) {
        checkStudentExists(studentId);
        StudentCourseRelation relation = relationDAO.findById(new StudentCourseRelationId(studentId, courseId))
                .orElseThrow(() -> new NotFoundException("學生未選該課"));
        if (bean.getGrade() != null) {
            relation.setGrade(bean.getGrade());
        }
        if (bean.getRemark() != null) {
            relation.setRemark(bean.getRemark());
        }
        return transformer.transferToBean(relationDAO.update(relation));
    }

    private void checkStudentExists(String studentId) {
        if (!studentDAO.existsById(studentId)) {
            throw new NotFoundException("找不到學生");
        }
    }
}
