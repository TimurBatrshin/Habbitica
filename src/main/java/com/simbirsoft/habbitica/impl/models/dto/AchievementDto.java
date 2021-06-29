package com.simbirsoft.habbitica.impl.models.dto;

import com.simbirsoft.habbitica.impl.models.data.Achievement;
import com.simbirsoft.habbitica.impl.models.data.Task;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class AchievementDto {

    private Long id;
    private String title;
    private String description;
    private Long taskId;
    private int count;

    public static AchievementDto from(Achievement achievement) {
        return AchievementDto.builder()
                .id(achievement.getId())
                .title(achievement.getTitle())
                .description(achievement.getDescription())
                .taskId(achievement.getTaskId())
                .count(achievement.getCount())
                .build();
    }

    public static List<AchievementDto> from(List<Achievement> achievements) {
        return achievements.stream().map(AchievementDto::from).collect(Collectors.toList());
    }
}
