package com.Taller_Ps.Entidad;

import jakarta.validation.constraints.*;

public class Paciente {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 10, message = "El nombre debe tener entre 3 y 10 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "El nombre solo puede contener letras")
    private String nombre;


    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "Debe ser mayor de edad (18 años o más)")
    @Max(value = 120, message = "La edad máxima permitida es 120")
    private Integer edad;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener exactamente 10 dígitos")
    private String telefono;


    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe ingresar un correo electrónico válido")
    private String email;

    @Pattern(
            regexp = "^(?=.*[a-z])"          +  // al menos una minúscula
                    "(?=.*[A-Z])"          +  // al menos una mayúscula
                    "(?=.*\\d)"            +  // al menos un dígito
                    "(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])" + // al menos un especial
                    ".{8,15}$",               // longitud 8–15
            message = "La contraseña debe tener entre 8 y 15 caracteres, incluir mayúscula, minúscula, número y carácter especial"
    )
    private String password;



    @NotBlank(message = "El estado civil es obligatorio")
    private String estadoCivil;

    // Puede ser opcional, si quieres obligatorio agrega @NotBlank
    private String ocupacion;

    @NotBlank(message = "Debe indicar si ha recibido atención psicológica previa")
    private String atencionPrevia;

    @NotBlank(message = "El motivo de consulta es obligatorio")
    @Size(min = 10, message = "El motivo debe tener al menos 10 caracteres")
    private String motivo;

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAtencionPrevia() {
        return atencionPrevia;
    }

    public void setAtencionPrevia(String atencionPrevia) {
        this.atencionPrevia = atencionPrevia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
