package med.voll.api.medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;
//DTO usado para recibir lo que viene de la api
//NotNull hereda de NotBlank
//Pattern es una expresion regular (regexp)
// "\\d{4,6}" -> busca de 4 a 6 digitos consecutivos
// Especialidad es de tipo Enum por lo que su validacion es @NotNull y no es @NotBlank
public record DatosRegistroMedico(@NotBlank String nombre,
                                  @NotBlank @Email String email,
                                  @NotBlank String telefono,
                                  @NotBlank @Pattern(regexp = "\\d{4,6}") String documento,
                                  @NotNull Especialidad especialidad,
                                  @NotNull @Valid DatosDireccion direccion) {

}
