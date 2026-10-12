package tw.edu.ntub.imd.birc.coursemanagement.bean;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseBean {
    @NotBlank(message = "缺少必要欄位：id")
    private String id;

    @NotBlank(message = "缺少必要欄位：name")
    private String name;

    @NotNull(message = "缺少必要欄位：credit")
    @Min(value = 0, message = "credit 不可為負數")
    private Integer credit;
}
