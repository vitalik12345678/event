package com.tiva.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record ResetPasswordDTO(
        @NotBlank String token,
        @Length(min = 7, max = 25) @Pattern(regexp = "") String newPassword) { //TODO find regex
}
