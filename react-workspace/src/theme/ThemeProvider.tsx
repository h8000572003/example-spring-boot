import React, {ReactNode, useState} from 'react';
import { ThemeProvider } from '@mui/material';
import { themeCreator } from './base';
import { StylesProvider } from '@mui/styles';

export const ThemeContext = React.createContext(
    (): void => {}
);
interface ThemeProviderWrapperProps {
  children: ReactNode;
}

const ThemeProviderWrapper: React.FC<ThemeProviderWrapperProps> = ({ children }) => {
  const curThemeName = localStorage.getItem('appTheme') || 'PureLightTheme';
  const [themeName, _setThemeName] = useState(curThemeName);
  const theme = themeCreator(themeName);

  const setThemeName = (): void => {
    localStorage.setItem('appTheme', themeName);
    _setThemeName(themeName);
  };

  return (
      <StylesProvider injectFirst>
        <ThemeContext.Provider value={setThemeName}>
          <ThemeProvider theme={theme}>{children}</ThemeProvider>
        </ThemeContext.Provider>
      </StylesProvider>
  );
};

export default ThemeProviderWrapper;
