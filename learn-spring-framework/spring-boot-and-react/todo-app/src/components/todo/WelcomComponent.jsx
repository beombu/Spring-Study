import { useParams, Link } from 'react-router-dom';
import { useState } from 'react';
import { retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from './api/HelloWorldApiService';

function WelcomeComponent() {
    const { username } = useParams();
    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {
        console.log('called');

        // axios
        //     .get('http://localhost:8080/hello-world')
        //     .then((response) => successfulResponse(response))
        //     .catch((error) => errorResponse(error))
        //     .finally(() => console.log('cleanup'));

        retrieveHelloWorldPathVariable('beomdfsf')
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup'));
    }

    function successfulResponse(response) {
        console.log(response);
        //setMessage(response.data);
        setMessage(response.data.message);
    }

    function errorResponse(response) {
        console.log(response);
    }

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Hello World Rest API 호출버튼
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    );
}

export default WelcomeComponent;
