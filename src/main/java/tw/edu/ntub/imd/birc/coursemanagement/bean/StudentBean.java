package tw.edu.ntub.imd.birc.coursemanagement.bean;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class StudentBean {
    @NotBlank(message = "缺少必要欄位：id")
    private String id;

    @NotBlank(message = "缺少必要欄位：name")
    private String name;

    @NotBlank(message = "缺少必要欄位：email")
    @Email(message = "信箱格式錯誤")
    private String email;
}
