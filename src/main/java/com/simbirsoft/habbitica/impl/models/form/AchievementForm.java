package com.simbirsoft.habbitica.impl.models.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AchievementForm {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private Long taskId;
    @NotBlank
    private int count;
}
