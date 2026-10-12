package tw.edu.ntub.imd.birc.coursemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentBean;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentCourseRelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentCourseRelationService;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentService;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    static final DateTimeFormatter ISO_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private final StudentService studentService;
    private final StudentCourseRelationService studentCourseRelationService;

    @GetMapping
    public ResponseEntity<String> searchAll() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(studentService.searchAll(), (data, student) -> {
                    data.add("id", student.getId());
                    data.add("name", student.getName());
                    data.add("email", student.getEmail());
                })
                .build();
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody StudentBean studentBean, BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        studentService.save(studentBean);
        return ResponseEntityBuilder.success()
                .status(HttpStatus.CREATED)
                .message("新增成功")
                .build();
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<String> searchCourses(@PathVariable("id") String id) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(studentCourseRelationService.searchByStudentId(id), (data, relation) -> {
                    data.add("courseId", relation.getCourseId());
                    data.add("courseName", relation.getCourseName());
                    data.add("courseCredit", relation.getCourseCredit());
                    data.add("grade", relation.getGrade());
                    data.add("remark", relation.getRemark());
                    data.add("createDate", relation.getCreateDate().format(ISO_DATE_TIME));
                })
                .build();
    }

    @PatchMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> updateGradeAndRemark(@PathVariable("studentId") String studentId,
                                                       @PathVariable("courseId") String courseId,
                                                       @Valid @RequestBody StudentCourseRelationBean bean,
                                                       BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        StudentCourseRelationBean result = studentCourseRelationService.updateGradeAndRemark(studentId, courseId, bean);
        ObjectData data = new ObjectData()
                .add("studentId", result.getStudentId())
                .add("courseId", result.getCourseId())
                .add("grade", result.getGrade())
                .add("remark", result.getRemark());
        return ResponseEntityBuilder.success()
                .message("修改成功")
                .data(data)
                .build();
    }
}
