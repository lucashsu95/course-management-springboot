package tw.edu.ntub.imd.birc.coursemanagement.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class StudentCourseRelationBean {
    private String studentId;

    private String courseId;

    private String courseName;

    private Integer courseCredit;

    @Min(value = 0, message = "grade 不可小於 0")
    @Max(value = 100, message = "grade 不可大於 100")
    private Integer grade;

    @Size(max = 255, message = "remark 長度不可超過 255 字")
    private String remark;

    private LocalDateTime createDate;
}
