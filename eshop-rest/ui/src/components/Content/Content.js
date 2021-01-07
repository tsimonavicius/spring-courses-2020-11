import {Switch, Route} from "react-router-dom"
import LandingPage from "../../pages/LandingPage/LandingPage";
import Products from "../../pages/Products/Products";
import About from "../../pages/About/About";
import ProductForm from "../../pages/ProductForm/ProductForm";

export default () => (
	<main className="container">
		<Switch>
			<Route exact path="/">
				<LandingPage/>
			</Route>
			<Route path="/products/new">
				<ProductForm/>
			</Route>
			<Route path="/products">
				<Products/>
			</Route>
			<Route path="/about">
				<About/>
			</Route>
		</Switch>
	</main>
)
