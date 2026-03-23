package tw.edu.ntub.imd.birc.coursemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CoursesDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.RelationDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentsDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dto.CreateRelationRequestDTO;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.RelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.RelationService;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RelationController {
    private final RelationDAO relationDAO;
    private final RelationService relationService;
    private final StudentsDAO studentsDAO;
    private final CoursesDAO coursesDAO;

    //7️⃣ 學生選課
    @PostMapping("/courses/{courseId}/students/{studentId}")
    public ResponseEntity<String> allNewRelation(
            @PathVariable String studentId,
            @PathVariable String courseId,
            @Valid @RequestBody CreateRelationRequestDTO request
    ) {

        RelationBean bean = new RelationBean();
        bean.setStudentId(studentId);
        bean.setCourseId(courseId);
        bean.setGrade(request.getGrade());
        bean.setRemark(request.getRemark());

        RelationBean result = relationService.save(bean);

        ObjectData obj = new ObjectData();
        obj.add("studentId", result.getStudentId())
                .add("courseId", result.getCourseId())
                .add("grade", result.getGrade())
                .add("remark", result.getRemark())
                .add("createDate",
                        result.getCreateDate()
                                .atZone(ZoneId.of("Asia/Taipei"))
                                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        return ResponseEntityBuilder.success().message("新增成功").data(obj).build();

    }
}
