import { useEffect, useState } from 'react';
import { useAuth } from './security/AuthContext';
import { useParams } from 'react-router-dom';
import { retrieveTodoApi } from './api/TodoApiService';

export default function TodoComponent() {
    const { id } = useParams();
    const [description, setDescription] = useState('');
    const authContext = useAuth();
    const username = authContext.username;

    useEffect(() => retrieveTodos(), [id]);

    function retrieveTodos() {
        retrieveTodoApi(username, id)
            .then((response) => {
                console.log(response.data.description);
                setDescription(response.data.description);
            })
            .catch((error) => console.log(error));
    }

    return (
        <div className="container">
            <h1>Enter Todo Details </h1>
            <div>description: {description}</div>
        </div>
    );
}
