package tw.edu.ntub.imd.birc.coursemanagement.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.transformer.StudentTransformer;

@Component
public class StudentTransformerImpl implements StudentTransformer {
    // 記得import spring的
    @NonNull
    @Override
    public Student transferToEntity(@NonNull StudentBean StudentBean) {
        // 複製左邊的給右邊的，null不複製、名字要相同
        return JavaBeanUtils.copy(StudentBean, new Student());
    }

    @NonNull
    @Override
    public StudentBean transferToBean(@NonNull Student Student) {
        return JavaBeanUtils.copy(Student, new StudentBean());
    }
}
