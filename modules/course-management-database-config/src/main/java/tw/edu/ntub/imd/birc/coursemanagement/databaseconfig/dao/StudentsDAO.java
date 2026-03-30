package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;

import javax.annotation.Nonnull;
import java.util.Optional;

@Repository
public interface StudentsDAO extends BaseDAO<Student, String>{
}
