package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;
import med.voll.api.direccion.DireccionPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String documentoIdentidad;
    @Embedded
    private DireccionPaciente direccionPaciente;
    private boolean activo;

    public Paciente(DatosRegistroPaciente datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccionPaciente = new DireccionPaciente(datos.direccionPaciente());
        this.activo = true;
    }

    public void actualizarInformacion(DatosActualizacionPaciente datosActualizacionPaciente){
        if (datosActualizacionPaciente.nombre() != null){
            this.nombre = datosActualizacionPaciente.nombre();
        }
        if (datosActualizacionPaciente.telefono() != null){
            this.telefono = datosActualizacionPaciente.telefono();
        }
        if (datosActualizacionPaciente.direccionPaciente() != null){
            this.direccionPaciente = direccionPaciente.actualizarInformacion(datosActualizacionPaciente.direccionPaciente());
        }
    }

    public void inactivar(){
        this.activo = false;
    }

}
