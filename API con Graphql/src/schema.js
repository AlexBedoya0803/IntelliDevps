import { makeExecutableSchema } from 'graphql-tools';
import resolvers from './resolvers';


const typeDefs = `

    type Usuario {
        _id: ID
        nombre: String!
        email: String!
        carrera: String!
        cedula: String!
        fecha_ingreso: String!
        rol: String!
        proyectos: [ID]
    }

    type Proyecto {
        _id: ID
        nombre: String!
        descripcion: String!
        fechaInicio: String!
        fechaFinal: String!
        objetivos: String!
        observaciones: String!
        presupuesto: String!
        estado: String!
        fase: String!
        tipo: String!
        usuarios: [ID]
    }

    input usuarioInput {
        nombre: String!
        email: String!
        carrera: String!
        cedula: String!
        fecha_ingreso: String!
        rol: String!
        proyectos: [ID]
    }

    input proyectoInput {
        nombre: String!
        descripcion: String!
        fechaInicio: String!
        fechaFinal: String!
        objetivos: String!
        observaciones: String!
        presupuesto: String!
        estado: String!
        fase: String!
        tipo: String!
        usuarios: [ID]
    }

    type Query {
        Usuarios: [Usuario]
        Usuario(_id: ID): Usuario
        Proyectos: [Proyecto]
        Proyecto(_id: ID): Proyecto
    }

    type Mutation {
        createUsuario(input: usuarioInput): Usuario
        deleteUsuario(_id: ID): Usuario
        updateUsuario(_id: ID, input : usuarioInput): Usuario

        createProyecto(input: proyectoInput): Proyecto
        deleteProyecto(_id: ID): Proyecto
        updateProyecto(_id: ID, input : proyectoInput): Proyecto
    }
`;


export default makeExecutableSchema({
    typeDefs: typeDefs,
    resolvers: resolvers
})

