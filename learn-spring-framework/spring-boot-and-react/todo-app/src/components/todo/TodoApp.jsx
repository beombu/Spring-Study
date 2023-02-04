import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HeaderComponent from './HeaderComponent';
import LogoutComponent from './LogoutComponent';
import ListTodosComponent from './ListTodosComponent';
import ErrorComponent from './ErrorComponent';
import FooterComponent from './FooterComponent';
import WelcomeComponent from './WelcomComponent';
import LoginComponent from './LoginComponent';
import AuthProvider from './security/AuthContext';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
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
            </AuthProvider>
        </div>
    );
}
