import mongoose, { Schema, model } from 'mongoose';

const proyectoSchema = new Schema({
    nombre: {
        type: String,
        required: true
    },
    descripcion: {
        type: String,
        required: true
    },
    fechaInicio: {
        type: String,
        required: true
    },
    fechaFinal: {
        type: String,
        required: true
    },
    objetivos: {
        type: String,
        required: true
    },
    observaciones: {
        type: String,
        required: true
    },
    presupuesto: {
        type: String,
        required: true
    },
    estado: {
        type: String,
        required: true
    },
    fase: {
        type: String,
        required: true
    },
    tipo: {
        type: String,
        required: true
    },
    usuarios: {
        type: [String],
        required: true
    }
});

export default model('Proyecto', proyectoSchema);