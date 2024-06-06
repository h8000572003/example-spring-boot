import React from "react";
import {Box, Container} from "@mui/material";


const App: React.FC = () => {

    return(
        <div>
            <Container maxWidth="sm">
                <Box
                    display="flex"
                    flexDirection="column"
                    alignItems="center"
                    justifyContent="center"
                    height="100vh"
                >
                    <h1>通話結束</h1>
                </Box>
            </Container>
        </div>
    );

}
export default App;