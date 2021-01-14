import {BrowserRouter as Router} from "react-router-dom";
import Header from "./components/Header";
import Content from "./components/Content/Content";
import Footer from "./components/Footer/Footer";
import React from "react";
import {Provider} from "react-redux";
import configureStore from './store'

const store = configureStore()

function App() {
	return (
		<Provider store={store}>
			<Router>
				<Header/>
				<Content/>
				<Footer/>
			</Router>
		</Provider>
	);
}

export default App;
