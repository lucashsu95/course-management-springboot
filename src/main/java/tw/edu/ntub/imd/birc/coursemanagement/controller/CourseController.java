package tw.edu.ntub.imd.birc.coursemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.coursemanagement.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.bean.StudentCourseRelationBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.CourseService;
import tw.edu.ntub.imd.birc.coursemanagement.service.StudentCourseRelationService;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.object.ObjectData;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    private final StudentCourseRelationService studentCourseRelationService;

    @GetMapping
    public ResponseEntity<String> searchAll() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(courseService.searchAll(), (data, course) -> {
                    data.add("id", course.getId());
                    data.add("name", course.getName());
                    data.add("credit", course.getCredit());
                })
                .build();
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        CourseBean course = courseService.save(courseBean);
        ObjectData data = new ObjectData()
                .add("id", course.getId())
                .add("name", course.getName())
                .add("credit", course.getCredit());
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .data(data)
                .build();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<String> enroll(@PathVariable("courseId") String courseId,
                                         @PathVariable("studentId") String studentId,
                                         @Valid @RequestBody(required = false) StudentCourseRelationBean bean,
                                         BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        StudentCourseRelationBean result = studentCourseRelationService.createRelation(studentId, courseId, bean);
        ObjectData data = new ObjectData()
                .add("studentId", result.getStudentId())
                .add("courseId", result.getCourseId())
                .add("grade", result.getGrade())
                .add("remark", result.getRemark())
                .add("createDate", result.getCreateDate().format(StudentController.ISO_DATE_TIME));
        return ResponseEntityBuilder.success()
                .message("選課成功")
                .data(data)
                .build();
    }
}
