package tw.edu.ntub.imd.birc.coursemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.RelationDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.StudentsDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dto.UpdateRelationRequestDTO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Relation;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Student;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.exception.NotFoundException;
import tw.edu.ntub.imd.birc.coursemanagement.service.impl.StudentServiceImpl;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentsDAO studentsDAO;
    private final RelationDAO relationDAO;
    private final StudentServiceImpl studentService;

    //    1️⃣ 查詢所有學生
    @GetMapping
    public ResponseEntity<String> searchAllStudents() {
        List<Student> students = studentsDAO.findAll();
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(students, ((objectData, index, student) -> objectData
                        .add("id", student.getId())
                        .add("name", student.getName())
                        .add("email", student.getEmail())
                ))
                .build();
    }

    //    2️⃣ 新增學生
    @PostMapping
    public ResponseEntity<String> addNewStudent(@Valid @RequestBody StudentBean student) {
        studentService.save(student);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .status(HttpStatus.CREATED)
                .build();
    }

    //    3️⃣ 查詢特定學生的選課清單 (含成績)
    @GetMapping("/{id}/courses")
    public ResponseEntity<String> searchStudent(@PathVariable String id) {
        Optional<Student> student = studentsDAO.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("找不到學生");
        }
//        if (!studentsDAO.existsById(id)) --> 簡化
        List<Relation> relations = relationDAO.findByStudent_Id(id);
        if (relations.isEmpty()) {
            throw new NotFoundException("此學生無選課");
        }
        ArrayData arrayData = new ArrayData();
        for (Relation r : relations) {
            ObjectData obj = new ObjectData();
            obj.add("courseId", r.getCourse().getId())
                    .add("courseName", r.getCourse().getCourseName())
                    .add("courseCredit", r.getCourse().getCourseCredit())
                    .add("grade", r.getGrade())
                    .add("remark", r.getRemark())
                    .add("createDate",
                            r.getCreateDate()
                                    .atZone(ZoneId.of("Asia/Taipei"))
                                    .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    );
            arrayData.add(obj);
        }
        return ResponseEntityBuilder.success().message("查詢成功").data(arrayData).build();
    }

    //    4️⃣ 修改成績與備註
    @PatchMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> upDataRelation(
            @PathVariable String studentId,
            @PathVariable String courseId,
            @Valid @RequestBody UpdateRelationRequestDTO request,
            BindingResult bindingResult
    ) {
        BindingResultUtils.validate(bindingResult);
        Optional<Student> student = studentsDAO.findById(studentId);
        if (student.isEmpty()) {
            throw new NotFoundException("找不到學生");
        }
        Relation relation = relationDAO
                .findByStudent_IdAndCourse_Id(studentId, courseId)
                .orElseThrow(() -> new NotFoundException("學生未選該課"));

        relation.setGrade(request.getGrade());
        relation.setRemark(request.getRemark());
        relationDAO.save(relation);
        ObjectData data = new ObjectData();
        data.add("studentId", relation.getStudent().getId())
                .add("courseId", relation.getCourse().getId())
                .add("grade", relation.getGrade())
                .add("remark", relation.getRemark());
        return ResponseEntityBuilder.success()
                .message("修改成功")
                .data(data)
                .build();
    }


}