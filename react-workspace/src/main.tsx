import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { CssBaseline } from '@mui/material';
import ThemeProvider from './theme/ThemeProvider';
ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
            <ThemeProvider>
                        <App/>
                        <CssBaseline />
            </ThemeProvider>

    </React.StrictMode>,
)
