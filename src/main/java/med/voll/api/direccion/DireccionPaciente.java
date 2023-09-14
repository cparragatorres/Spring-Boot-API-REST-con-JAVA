package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionPaciente {

    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;
    private String urbanizacion;
    private String codigoPostal;
    private String provincia;

    public DireccionPaciente(DatosDireccionPaciente direccionPaciente) {
        this.distrito = direccionPaciente.distrito();
        this.ciudad = direccionPaciente.ciudad();
        this.numero = direccionPaciente.numero();
        this.complemento = direccionPaciente.complemento();
        this.urbanizacion = direccionPaciente.urbanizacion();
        this.codigoPostal = direccionPaciente.codigoPostal();
        this.provincia = direccionPaciente.provincia();

    }

    public DireccionPaciente actualizarInformacion(DatosDireccionPaciente direccionPaciente){
        this.distrito = direccionPaciente.distrito();
        this.ciudad = direccionPaciente.ciudad();
        this.numero = direccionPaciente.numero();
        this.complemento = direccionPaciente.complemento();
        this.urbanizacion = direccionPaciente.urbanizacion();
        this.codigoPostal = direccionPaciente.codigoPostal();
        this.provincia = direccionPaciente.provincia();
        return this;
    }
}
