package com.ApiRest.APIRest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document
public class Proyecto {

    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String descripcion;
    @Field
    private Date fechaInicio;
    @Field
    private Date fechaFinal;
    @Field
    private List objetivos;
    @Field
    private List observaciones;
    @Field
    private double presupesto;
    @Field
    private String estado;
    @Field
    private String fase;
    @Field
    private String tipo;
    @Field
    private List usuarios;

    public Proyecto(){}

    public Proyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFinal, List objetivos, List observaciones, double presupesto, String estado, String fase, String tipo, List usuarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.objetivos = objetivos;
        this.observaciones = observaciones;
        this.presupesto = presupesto;
        this.estado = estado;
        this.fase = fase;
        this.tipo = tipo;
        this.usuarios = usuarios;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public List getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List objetivos) {
        this.objetivos = objetivos;
    }

    public List getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List observaciones) {
        this.observaciones = observaciones;
    }

    public double getPresupesto() {
        return presupesto;
    }

    public void setPresupesto(double presupesto) {
        this.presupesto = presupesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return String.format("Proyecto[id='%s', nombre='%s', descripcion='%s', fechaInicio='%s', fechaFinal='%s', objetivos='%s', observaciones='%s', presupesto='%s', estado='%s', fase='%s', tipo='%s', usuarios='%s']", id, nombre, descripcion, fechaInicio, fechaFinal, objetivos, observaciones, presupesto, estado, fase, tipo, usuarios);
    }
}
