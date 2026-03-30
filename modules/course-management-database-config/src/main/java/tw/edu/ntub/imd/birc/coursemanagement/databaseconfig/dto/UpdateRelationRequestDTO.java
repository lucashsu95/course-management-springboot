package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateRelationRequestDTO {
    @NotNull(message = "")
    private Integer grade;
    @NotBlank(message = "")
    private String remark;
}