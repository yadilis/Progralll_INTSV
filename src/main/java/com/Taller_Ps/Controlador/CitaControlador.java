package com.Taller_Ps.Controlador;

import com.Taller_Ps.Entidad.Cita;
import com.Taller_Ps.Servicio.EmailServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CitaControlador {

    @Autowired
    private EmailServicio emailServicio;

    @GetMapping("/cita")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        return "Cita/contactos";
    }

    @PostMapping("/enviarCita")
    public String enviarCita(@Valid @ModelAttribute("cita") Cita cita,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "Cita/contactos";
        }

        String mensaje = String.format(
                "🧠 Nueva solicitud de cita recibida:\n\n"
                        + "👤 Nombre completo: %s\n"
                        + "📞 Teléfono: %s\n"
                        + "🩺 Especialidad solicitada: %s\n"
                        + "📅 Fecha preferida: %s\n"
                        + "📝 Comentarios adicionales: %s\n\n"
                        + "Por favor, responder a la brevedad.",
                cita.getNombre(),
                cita.getTelefono(),
                cita.getEspecialidad(),
                cita.getFecha(),
                (cita.getMensaje() == null || cita.getMensaje().isBlank()) ? "No especificado" : cita.getMensaje()
        );

        emailServicio.enviarCorreo("yadirapalomo05@gmail.com", "Nueva Cita Solicitada", mensaje);

        model.addAttribute("mensaje", "La cita fue enviada correctamente. Pronto nos pondremos en contacto.");
        return "Cita/confirmacionCita";
    }
}
