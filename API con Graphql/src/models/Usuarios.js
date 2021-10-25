import mongoose, { Schema, model } from 'mongoose';

const usuarioSchema = new Schema({
    nombre: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true
    },
    carrera: {
        type: String,
        required: true
    },
    cedula: {
        type: String,
        required: true
    },
    fecha_ingreso: {
        type: String,
        required: true
    },
    rol: {
        type: String,
        required: true
    },
    proyectos: {
        type: [String],
        required: true
    }
});

export default model('Usuario', usuarioSchema);