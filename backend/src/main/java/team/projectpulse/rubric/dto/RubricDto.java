package team.projectpulse.rubric.dto;

import java.util.LinkedHashSet;

import java.util.Collections;

import java.util.Set;

public record RubricDto(
        Integer rubricId,
        String rubricName,
        Set<CriterionDto> criteria,
        Integer courseId) {
    public RubricDto {
        // DTO collections are snapshots; preserve null for existing validation behavior.
        criteria = criteria == null ? null : Collections.unmodifiableSet(new LinkedHashSet<>(criteria));
    }

}
