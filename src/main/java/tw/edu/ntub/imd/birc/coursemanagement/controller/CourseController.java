package tw.edu.ntub.imd.birc.coursemanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.CoursesDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao.RelationDAO;
import tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity.Course;
import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.CourseBean;
import tw.edu.ntub.imd.birc.coursemanagement.service.CourseService;
import tw.edu.ntub.imd.birc.coursemanagement.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.coursemanagement.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CoursesDAO coursesDAO;
    private final RelationDAO relationDAO;
    private final CourseService courseService;

    //    5️⃣ 查詢所有課程
    @GetMapping
    public ResponseEntity<String> searchAllCourses() {
        List<Course> courses = coursesDAO.findAll();
        ArrayData data = new ArrayData();
        for (Course c : courses) {
            ObjectData obj = new ObjectData();
            obj.add("id", c.getId())
                    .add("name", c.getCourseName())
                    .add("credit", c.getCourseCredit());
            data.add(obj);
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(data)
                .build();
    }

    //    6️⃣ 新增課程
    @PostMapping
    public ResponseEntity<String> addNewCourse(@Valid @RequestBody CourseBean course) {
        CourseBean save = courseService.save(course);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .status(HttpStatus.CREATED)
                .build();
    }

}
