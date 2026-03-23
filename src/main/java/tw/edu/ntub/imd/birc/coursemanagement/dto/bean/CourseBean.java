package tw.edu.ntub.imd.birc.coursemanagement.dto.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseBean {
    @NotBlank(message = "缺少必要欄位：id")
    private String id;
    @NotBlank(message = "缺少必要欄位：name")
    @JsonProperty("name")
    private String courseName;
    @NotNull(message = "缺少必要欄位：credit")
    @JsonProperty("credit")
    @Min(value = 0 , message = "credit 不可為負數")
    private Integer courseCredit;
}
