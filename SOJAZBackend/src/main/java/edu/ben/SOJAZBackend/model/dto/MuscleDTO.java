package edu.ben.SOJAZBackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MuscleDTO {
    Long id;
    String muscleName;
    String muscleGroup;
}
