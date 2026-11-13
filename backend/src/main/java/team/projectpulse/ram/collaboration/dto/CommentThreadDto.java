package team.projectpulse.ram.collaboration.dto;

import java.util.Collections;

import java.util.ArrayList;

import team.projectpulse.ram.collaboration.CommentThreadStatus;
import team.projectpulse.user.dto.PeerEvaluationUserDto;

import java.time.Instant;
import java.util.List;

public record CommentThreadDto(Long id,
                               CommentThreadStatus status,
                               Instant createdAt,
                               PeerEvaluationUserDto createdBy,
                               List<CommentDto> comments) {
    public CommentThreadDto {
        // DTO collections are snapshots; preserve null for existing validation behavior.
        comments = comments == null ? null : Collections.unmodifiableList(new ArrayList<>(comments));
    }

}
