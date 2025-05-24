package com.Taller_Ps.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlador {

    @GetMapping("/")
    public String mostrarInicio() {
        return "index"; // index.html en /templates/
    }

    @GetMapping("/servicios")
    public String mostrarServicios() {
        return "Vistas/servicios"; // servicios.html en /templates/Vistas/
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros() {
        return "Vistas/nosotros";
    }

    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "Vistas/contactos";
    }
    @GetMapping("/login")
    public String mostrarlogin() {
        return "Vistas/login";
    }
}


