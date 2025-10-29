package ru.arkhipov.My2TestAppSpringBoot.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank(message = "Поле uid обязательно.")
    @Size(max = 32, message = "Длина uid не должна превышать 32 символа.")
    private String uid;

    @NotBlank(message = "Поле operationUid обязательно.")
    @Size(max = 32, message = "Длина operationUid не должна превышать 32 символа.")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "Поле systemTime обязательно.")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "communicationId должен быть не меньше 1.")
    @Max(value = 100000, message = "communicationId должен быть не больше 100000.")
    private Integer communicationId;

    private String tempelateId;

    private String productCode;

    private String smsCode;
}
