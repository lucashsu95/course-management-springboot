package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.exception.DuplicateCreateException;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl.StudentTransformer;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentBean, Student, String> implements StudentService {
    private final StudentDAO studentDAO;
    private final StudentTransformer transformer;

    public StudentServiceImpl(StudentDAO studentDAO, StudentTransformer transformer) {
        super(studentDAO, transformer);
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Transactional
    @Override
    public StudentBean save(StudentBean studentBean) {
        if (studentDAO.existsById(studentBean.getId())) {
            throw new DuplicateCreateException("學號重複");
        }
        Student student = studentDAO.save(transformer.transferToEntity(studentBean));
        return transformer.transferToBean(student);
    }
}
