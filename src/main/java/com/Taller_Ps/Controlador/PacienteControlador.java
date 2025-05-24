package com.Taller_Ps.Controlador;

import com.Taller_Ps.Entidad.Paciente;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteControlador {

    @GetMapping("/formulario")
    public String formularioRegistro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "Paciente/formularioPaciente";  // La vista Thymeleaf con el formulario
    }

    @PostMapping("/registrarPaciente")
    public String registrarPaciente(@Valid  @ModelAttribute Paciente paciente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Paciente/formularioPaciente";  // Volver al formulario si hay errores
        }


        // Pasamos los datos a la vista de confirmación
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("edad", paciente.getEdad());
        model.addAttribute("genero", paciente.getGenero());
        model.addAttribute("telefono", paciente.getTelefono());
        model.addAttribute("email", paciente.getEmail());
        model.addAttribute("password", paciente.getPassword());
        model.addAttribute("estadoCivil", paciente.getEstadoCivil());
        model.addAttribute("ocupacion", paciente.getOcupacion());
        model.addAttribute("atencionPrevia", paciente.getAtencionPrevia());
        model.addAttribute("motivo", paciente.getMotivo());

        return "Paciente/vistaPaciente";  // Vista para mostrar datos tras registro exitoso
    }
}
