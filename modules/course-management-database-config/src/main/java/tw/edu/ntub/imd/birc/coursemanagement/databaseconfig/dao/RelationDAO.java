package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Relation;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationDAO extends BaseDAO<Relation,String>{
    List<Relation> findByStudent_Id(String id);
    Optional<Relation> findByStudent_IdAndCourse_Id(String studentId , String courseId);
}
