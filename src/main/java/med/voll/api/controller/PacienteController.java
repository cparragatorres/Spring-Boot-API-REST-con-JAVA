package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DatosRegistroPaciente datos) {
        System.out.println("Request Datos de Registros Medicos:");
        System.out.println("-----------------------------------");
        repository.save(new Paciente(datos));
        System.out.println("-----------------------------------");
    }
    //PAGINACION POR DEFAULT
//    @GetMapping
//    public Page<DatosListaPaciente> listadoPacientes(@PageableDefault(page = 0,
//                                                                        size = 10,
//                                                                        sort = {"nombre"}) Pageable paginacion) {
//        return repository.findAll(paginacion).map(DatosListaPaciente::new);
//    }
    // LISTA DE PACIENTES ACTIVOS
    @GetMapping
    public Page<DatosListaPaciente> listadoPacientes(Pageable paginacion) {
        return repository.findByActivoTrue(paginacion).map(DatosListaPaciente::new);
    }
    @PutMapping
    @Transactional
    public void actualizarPaciente(@RequestBody @Valid DatosActualizacionPaciente datosActualizacionPaciente){
        Paciente paciente = repository.getReferenceById(datosActualizacionPaciente.id());
        paciente.actualizarInformacion(datosActualizacionPaciente);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id){
        Paciente paciente = repository.getReferenceById(id);
        paciente.inactivar();
    }

}
