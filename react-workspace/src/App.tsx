import React from 'react';
import Call from './Call.tsx';
import Room from './Room.tsx';
import Callover from './Callover.tsx';
import { HashRouter as Router, Route, Routes, Link } from 'react-router-dom';

const App: React.FC = () => {
    return (
        <>
        <Router basename="/">
            <div>
                <nav>
                    <ul>
                        <li><Link to="/">Home</Link></li>
                        <li><Link to="/call">打電話中</Link></li>
                        <li><Link to="/callover">打電話中</Link></li>
                    </ul>
                </nav>
                <Routes>
                    <Route path="/" element={<Room />} />
                    <Route path="/call/*" element={<Call />} />
                    <Route path="/callover" element={<Callover />} />
                </Routes>
            </div>
        </Router>
        </>
    );
};

export default App;
