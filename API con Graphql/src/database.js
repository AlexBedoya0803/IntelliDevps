import mongoose from 'mongoose';

export async function connect() {
    
    const url = `mongodb+srv://dbFirst:dbFirst@cluster0.iehnr.mongodb.net/IntelliDevps?retryWrites=true&w=majority`;

    const connectionParams={
        useNewUrlParser: true,
        useUnifiedTopology: true 
    }

    await mongoose.connect(url,connectionParams)
        .then( () => {
            console.log('Connected to database ')
        })
        .catch( (err) => {
            console.error(`Error connecting to the database. \n${err}`);
        })
    }