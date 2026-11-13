package team.projectpulse.ram.usecase.dto;

import java.util.Collections;

import java.util.ArrayList;

import java.util.List;

public record UseCaseMainStepDto(
        Long id,
        String actor,
        String actionText,
        List<UseCaseExtensionDto> extensions) {
    public UseCaseMainStepDto {
        // DTO collections are snapshots; preserve null for existing validation behavior.
        extensions = extensions == null ? null : Collections.unmodifiableList(new ArrayList<>(extensions));
    }

}
