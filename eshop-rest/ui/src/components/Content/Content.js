import {Switch, Route} from "react-router-dom"

export default () => (
	<main className="container">
		<Switch>
			<Route path="/">
				<LandingPage/>
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
