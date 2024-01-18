package com.example.model.clientmodel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {
    @NotNull(message = "le nom est obligatoire")
    @Size(min = 5,max = 50,message = "le nom entre 5 et 20")
    @NotBlank
    private String nom;
     @NotNull(message = "le nom est obligatoire")
    @Size(min = 5,max = 50,message = "le nom entre 5 et 20")
    private String prenom;
    @NotNull
    private String tele;
}
