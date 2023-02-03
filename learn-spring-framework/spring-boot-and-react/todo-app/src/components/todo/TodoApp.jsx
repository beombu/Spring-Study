import { useState } from 'react';
import { BrowserRouter, Routes, Route, useNavigate, useParams, Link } from 'react-router-dom';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route path="/welcome/:username" element={<WelcomeComponent />} />
                    <Route path="/todos" element={<ListTodosComponent />} />
                    <Route path="/logout" element={<LogoutComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
        </div>
    );
}

function WelcomeComponent() {
    const { username } = useParams();

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
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

function ListTodosComponent() {
    const today = new Date();

    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay());

    const todos = [
        { id: 1, description: 'Learn AWS', done: false, targetDate: targetDate },
        { id: 2, description: 'Learn Full Stack Dev', done: false, targetDate: targetDate },
        { id: 3, description: 'Learn DevOps', done: false, targetDate: targetDate },
    ];

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Description</td>
                            <td>Is Done?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map((todo) => (
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                <td>{todo.targetDate.toDateString()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

function HeaderComponent() {
    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://www.in28minutes.com">
                            in28minutes
                        </a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5">
                                    <Link className="nav-link" to="/welcome/in28minutes">
                                        Home
                                    </Link>
                                </li>
                                <li className="nav-item fs-5">
                                    <Link className="nav-link" to="/todos">
                                        Todos
                                    </Link>
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5">
                                <Link className="nav-link" to="/login">
                                    Login
                                </Link>
                            </li>
                            <li className="nav-item fs-5">
                                <Link className="nav-link" to="/logout">
                                    Logout
                                </Link>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    );
}

function FooterComponent() {
    return (
        <footer className="footer">
            <div className="container">Your Footer</div>
        </footer>
    );
}

function LogoutComponent() {
    return (
        <div className="LogoutComponent">
            <h1>You are logged out!</h1>
            <div>Thank you for using our App. Come back soon!</div>
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