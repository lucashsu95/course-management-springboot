package tw.edu.ntub.imd.birc.coursemanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CreateCourseRecordRequest", description = "新增選課紀錄請求")
public class CreateCourseRecordRequest {
    @Schema(description = "成績，選課時尚未評分可為 null", example = "null", nullable = true)
    private Integer grade;

    @Schema(description = "選課備註", example = "一般選課", nullable = true)
    private String remark;
}
