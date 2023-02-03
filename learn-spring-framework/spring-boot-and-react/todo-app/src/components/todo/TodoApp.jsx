import { useState } from 'react';
import { BrowserRouter, Routes, Route, useNavigate, useParams } from 'react-router-dom';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route path="/welcome/:username" element={<WelcomeComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

function WelcomeComponent() {
    const { username } = useParams();

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>welcome</div>
        </div>
    );
}

function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>에러!</h1>
            <div>404 Error!!</div>
        </div>
    );
}

function LoginComponent() {
    const [username, setUsername] = useState('beom');
    const [password, setPassword] = useState('');
    const [showSeccessMessage, setShowSuccessMessage] = useState(false);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if (username === 'beom' && password === '123') {
            console.log('success');
            setShowSuccessMessage(true);
            setShowErrorMessage(false);
            navigate(`/welcome/${username}`);
        } else {
            console.log('failed');
            setShowSuccessMessage(false);
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
