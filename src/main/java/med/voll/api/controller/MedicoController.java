package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired //no usar para pruebas unitarias, otra opcion puede ser @Setter
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println("Request Datos de Registros Medicos:");
        System.out.println("-----------------------------------");
        System.out.println(datosRegistroMedico);
        medicoRepository.save(new Medico(datosRegistroMedico));
        System.out.println("-----------------------------------");
    }

// /////////////////////////////////////////////////
// Retornando listado de medicos
//    @GetMapping
//    public List<Medico> listadoMedicos(){
//        return medicoRepository.findAll();
//    }
// /////////////////////////////////////////////////
// Retornando listado de medicos con datos limitados
//    @GetMapping
//    public List<DatosListadoMedico> listadoMedicos(){
//        return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
//    }
// /////////////////////////////////////////////////
// Retornando listado PAGINADO de 20 en 20 de medicos con datos limitados
//Paginacion
//    @GetMapping
//    //El paramentro ⚠️️Pageable⚠️ debe ser de ⚠️⚠️⚠️org.springframework.data.domain⚠️⚠️⚠️
//    public Page<DatosListadoMedico> listadoMedicos(Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
//    }
// /////////////////////////////////////////////////
// Retornando listado PAGINADO POR DEFAULT de medicos con datos limitados
//    @GetMapping
//    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
//    }
//    //@PageableDefault(value = 10,
//    //                 size = 10,
//    //                 page = 0,
//    //                 sort = {},
//    //                 direction = Sort.Direction.ASC)
// /////////////////////////////////////////////////
// RETORNANDO LISTA DE MEDICOS ACTIVOS
    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }
// /////////////////////////////////////////////////

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
// /////////////////////////////////////////////////
//  DELETE EN BASE DE DATOS
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarMedico(@PathVariable Long id){
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }
// /////////////////////////////////////////////////
// DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }
// /////////////////////////////////////////////////
}













