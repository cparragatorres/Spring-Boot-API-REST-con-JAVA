package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.DatosDireccionPaciente;

public record DatosActualizacionPaciente(@NotNull Long id, String nombre, String telefono, @Valid DatosDireccionPaciente direccionPaciente) {

}
