package tw.edu.ntub.imd.birc.coursemanagement.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentsDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.exception.DuplicateException;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentService;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.StudentTransformer;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentBean, Student, String> implements StudentService {
    private final StudentsDAO dao;
    private final StudentTransformer transformer;

    public StudentServiceImpl(StudentsDAO dao, StudentTransformer transformer) {
        super(dao,transformer);
        this.dao = dao;
        this.transformer = transformer;
    }

    @Override
    public StudentBean save(StudentBean studentBean) {
        if(dao.existsById(studentBean.getId())){
            throw new DuplicateException("學號重複");
        }

        Student student = transformer.transferToEntity(studentBean);
        Student savedStudent = dao.save(student);
        return transformer.transferToBean(savedStudent);
    }

    @Override
    public void msgFunc(String st){}
}
