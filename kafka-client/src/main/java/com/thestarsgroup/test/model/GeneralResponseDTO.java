package com.thestarsgroup.test.model;

import lombok.Data;

@Data
public class GeneralResponseDTO {

    private String message;

    public GeneralResponseDTO(String message) {
        this.message = message;
    }

    GeneralResponseDTO() {
    }
}
