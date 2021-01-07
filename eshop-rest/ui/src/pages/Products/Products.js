import {Link} from "react-router-dom";

export default () => (
	<>
		<h1>Products Page!</h1>
		<Link to="/products/new">
			<button type="button" className="btn btn-primary">Sukurti produkta</button>
		</Link>
	</>
)
