import Usuario from './models/Usuarios';
import Proyecto from './models/Proyectos';

const resolvers = {
    Query: {
        async Usuarios() {
            const usuarios = await Usuario.find();
            return usuarios;
        },
        async Proyectos() {
            const proyectos = await Proyecto.find();
            return proyectos;
        },
        async Usuario(_, { _id }) {
            const usuario = await Usuario.findById(_id);
            return usuario;
        },
        async Proyecto(_, { _id }) {
            const proyecto = await Proyecto.findById(_id);
            return proyecto;
        }
    },

    Mutation: {
        async createUsuario(_, { input }) {
            const newUsuario = new Usuario(input)
            await newUsuario.save();
            return newUsuario;
        },

        async deleteUsuario(_, { _id }) {
            return await Usuario.findByIdAndDelete(_id);    
        },

        async updateUsuario(_, { _id, input }) {
            return await Usuario.findByIdAndUpdate(_id, input, { new: true });
        },

        async createProyecto(_, { input }) {
            const newProyecto = new Proyecto(input)
            await newProyecto.save();
            return newProyecto;
        },

        async deleteProyecto(_, { _id }) {
            return await Proyecto.findByIdAndDelete(_id);    
        },

        async updateProyecto(_, { _id, input }) {
            return await Proyecto.findByIdAndUpdate(_id, input, { new: true });
    }
}
};

export default resolvers;