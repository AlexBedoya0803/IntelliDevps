import express from 'express';
import { graphqlHTTP } from 'express-graphql';
import schema from "./schema";
const cors = require('cors');

import { connect } from "./database";

const app = express();

connect();

app.use(cors());

app.use('/graphql', graphqlHTTP({
    graphiql: true,
    schema: schema,
    context: {
        messageId: 'test'
    }
}));

app.listen(5000, () => console.log('Iniciando server desde el puerto 5000'));