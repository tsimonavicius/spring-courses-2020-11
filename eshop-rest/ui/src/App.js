import {BrowserRouter as Router} from "react-router-dom";
import Header from "./components/Header";
import Content from "./components/Content/Content";
import Footer from "./components/Footer/Footer";
import React, {useState} from "react";

const CartContext = React.createContext(null)

function App() {
	const [products, setProducts] = useState([])

	const cartContextState = {
		products,
		addProduct: (product) => setProducts([...products, product]),
		removeProduct: (id) => setProducts(products.filter((product) => product.id !== id))
	}

	return (
		<CartContext.Provider value={cartContextState}>
			<Router>
				<Header/>
				<Content/>
				<Footer/>
			</Router>
		</CartContext.Provider>
	);
}

export {CartContext}
export default App;
