import { useParams, Link } from 'react-router-dom';
import { useState } from 'react';
import { retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from './api/HelloWorldApiService';
import { useAuth } from './security/AuthContext';

function WelcomeComponent() {
    const { username } = useParams();
    const authContext = useAuth();
    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {
        console.log('called');

        retrieveHelloWorldPathVariable('beomchul', authContext.token)
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
