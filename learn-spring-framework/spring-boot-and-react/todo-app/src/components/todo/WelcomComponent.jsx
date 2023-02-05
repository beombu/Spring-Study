import { useParams, Link } from 'react-router-dom';
import axios from 'axios';

function WelcomeComponent() {
    const { username } = useParams();

    function callHelloWorldRestApi() {
        console.log('called');

        axios
            .get('http://localhost:8080/hello-world')
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup'));
    }

    function successfulResponse(response) {
        console.log(response);
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
        </div>
    );
}

export default WelcomeComponent;
