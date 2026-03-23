package tw.edu.ntub.imd.birc.coursemanagement.dto.bean;

import lombok.Data;
import org.apache.commons.math3.stat.inference.BinomialTest;

import java.time.LocalDateTime;

@Data
public class RelationBean {
    private String studentId;
    private String courseId;
    private Integer grade;
    private String remark;
    private LocalDateTime createDate;
}
