package ru.palinov.My3TestAppSpringBoot.model;

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


    @NotNull(message = "Укажите тип системы: CRM, ERP, WMS")
    private Systems systemName;


    private String systemTime;

    private String source;

    @Min(value = 1, message = "communicationId должен быть не меньше 1.")
    @Max(value = 100000, message = "communicationId должен быть не больше 100000.")
    @NotNull
    private int communicationId;


    private int templateId;

    private int productCode;

    private int smsCode;


    private Long sourceTime;
    private Long service1Time;

    @Override
    public String toString()
    {
        return "{" +
                "uid=" + uid + " " +
                ", operationUid=" + operationUid + " " +
                ", systemName=" + systemName + " " +
                ", systemTime=" + systemTime + " " +
                ", source=" + source + " " +
                ", communicationId=" + communicationId + " " +
                ", templateId=" + templateId + " " +
                ", productCode=" + productCode + " " +
                ", smsCode=" + smsCode + " }";
    }
}