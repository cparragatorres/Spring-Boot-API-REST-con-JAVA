package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccionPaciente;

public record DatosRegistroPaciente(@NotBlank String nombre,
                                    @NotBlank @Email String email,
                                    @NotBlank String telefono,
                                    @NotBlank @Pattern(regexp = "\\d{8,10}") String documentoIdentidad,
                                    @NotNull @Valid DatosDireccionPaciente direccionPaciente) {
}
