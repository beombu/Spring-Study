import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

function LoginComponent() {
    const [username, setUsername] = useState('beom');
    const [password, setPassword] = useState('');
    const [showSeccessMessage] = useState(false);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if (authContext.login(username, password)) {
            navigate(`/welcome/${username}`);
        } else {
            setShowErrorMessage(true);
        }
    }

    function SuccessMessageComponent() {
        if (showSeccessMessage) {
            return <div className="successMessage">로그인 성공</div>;
        }

        return null;
    }

    function ErrorMessageComponent() {
        if (showErrorMessage) {
            return <div className="errorMessage">로그인 실패</div>;
        }

        return null;
    }

    return (
        <div className="Login">
            <SuccessMessageComponent />
            <ErrorMessageComponent />
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>
                        Login
                    </button>
                </div>
            </div>
        </div>
    );
}

export default LoginComponent;
