import { useEffect, useState } from 'react';
import { retrieveAllTodosForUsernameApi, deleteTodoApi, retrieveTodoApi } from './api/TodoApiService';
import { useAuth } from './security/AuthContext';
import { useNavigate } from 'react-router-dom';

function ListTodosComponent() {
    const today = new Date();
    const authContext = useAuth();
    const username = authContext.username;
    const navigate = useNavigate();

    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay());

    const [message, setMessage] = useState(null);
    const [todos, setTodos] = useState([]);

    useEffect(() => refreshTodos(), []);

    function refreshTodos() {
        retrieveAllTodosForUsernameApi(username).then((respone) => {
            //console.log(respone.data);
            setTodos(respone.data);
        });
    }

    function deleteTodo(id) {
        deleteTodoApi(username, id)
            .then(() => {
                setMessage(`${id} 삭제완료`);
                refreshTodos();
            })
            .catch((error) => console.log(error));
    }

    function updateTodo(id) {
        retrieveTodoApi(username, id)
            .then(() => {
                navigate(`/todo/${id}`);
            })
            .catch((error) => console.log(error));
    }

    function addNewTodo() {
        navigate(`/todo/-1`);
    }

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            {message && (
                <div
                    className="alert alert-wa
            "
                >
                    {message}
                </div>
            )}
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map((todo) => (
                            <tr key={todo.id}>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                {/* <td>{todo.targetDate.toDateString()}</td> */}
                                <td>{todo.targetDate.toString()}</td>
                                <td>
                                    <button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>
                                        삭제
                                    </button>
                                </td>
                                <td>
                                    <button className="btn btn-success" onClick={() => updateTodo(todo.id)}>
                                        업뎃
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>
                Todo 추가
            </div>
        </div>
    );
}

export default ListTodosComponent;
