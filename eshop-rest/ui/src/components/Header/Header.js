import {Link} from "react-router-dom";

export default () => (
	<header>
		<nav className="navbar navbar-expand-lg navbar-light bg-light">
			<div className="container justify-content-start">
				<Link className="navbar-brand" to="/">E-shop</Link>

				<ul className="navbar-nav">
					<li className="nav-item">
						<Link className="nav-link" to="/products">Produktai</Link>
					</li>
					<li className="nav-item">
						<Link className="nav-link" to="/about">Apie sistema</Link>
					</li>
				</ul>
			</div>
		</nav>
	</header>
)
