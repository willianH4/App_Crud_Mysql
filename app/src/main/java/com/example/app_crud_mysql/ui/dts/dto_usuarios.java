package com.example.app_crud_mysql.ui.dts;

public class dto_usuarios{
    int id;
    String nombre;
    String apellido;
    String correo;
    String usuario;
    String clave;
    int tipo;
    int estado_us;
    String pregunta;
    String respuesta;

    public dto_usuarios() {
    }

    public dto_usuarios(int id, String nombre, String apellido, String correo, String usuario, String clave, int tipo, int estado_us, String pregunta, String respuesta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado_us = estado_us;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado_us() {
        return estado_us;
    }

    public void setEstado_us(int estado_us) {
        this.estado_us = estado_us;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}

