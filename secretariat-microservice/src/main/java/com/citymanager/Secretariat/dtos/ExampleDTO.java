package com.citymanager.Secretariat.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDTO {

    @NotNull(message = "{id.required.validation}")
    private Long id;

    @NotBlank (message = "{required.validation}")
    @Size(min = 4, max = 30, message = "{size.validation}")
    private String name;
}
