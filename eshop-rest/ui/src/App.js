import {BrowserRouter as Router} from "react-router-dom";
import Header from "./components/Header";
import Content from "./components/Content/Content";
import Footer from "./components/Footer/Footer";

function App() {
	return (
		<Router>
			<Header/>
			<Content/>
			<Footer/>
		</Router>
	);
}

export default App;
