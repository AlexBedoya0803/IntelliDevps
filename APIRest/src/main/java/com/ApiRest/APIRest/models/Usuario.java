package com.ApiRest.APIRest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document
public class Usuario {
    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String email;
    @Field
    private String carrera;
    @Field
    private String celula;
    @Field
    private Date fecha_ingreso;
    @Field
    private String rol;
    @Field
    private List proyectos;

    public Usuario(){}

    public Usuario(String nombre, String email, String carrera, String celula, Date fecha_ingreso, String rol, List proyectos) {
        this.nombre = nombre;
        this.email = email;
        this.carrera = carrera;
        this.celula = celula;
        this.fecha_ingreso = fecha_ingreso;
        this.rol = rol;
        this.proyectos = proyectos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCelula() {
        return celula;
    }

    public void setCelula(String celula) {
        this.celula = celula;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List getProyectos() {
        return proyectos;
    }

    public void setProyectos(List proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return String.format("Usuario[id='%s', nombre='%s', email='%s', carrera='%s', cedula='%s', fecha_ingreso='%s', rol='%s', proyectos='%s']", id, nombre, email, carrera, celula, fecha_ingreso, rol, proyectos);
    }
}
