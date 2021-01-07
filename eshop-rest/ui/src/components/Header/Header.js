import {NavLink} from "react-router-dom";

export default () => (
	<header>
		<nav className="navbar navbar-expand-lg navbar-light bg-light">
			<div className="container justify-content-start">
				<NavLink className="navbar-brand" exact to="/">E-shop</NavLink>

				<ul className="navbar-nav">
					<li className="nav-item">
						<NavLink className="nav-link" to="/products">Produktai</NavLink>
					</li>
					<li className="nav-item">
						<NavLink className="nav-link" to="/about">Apie sistema</NavLink>
					</li>
				</ul>
			</div>
		</nav>
	</header>
)
