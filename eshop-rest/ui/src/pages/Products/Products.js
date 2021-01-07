import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {fetchProducts} from "../../api/productsApi";

export default () => {
	const [products, setProducts] = useState([])

	useEffect(() => {
		fetchProducts().then(response => {
			setProducts(response.data)
			console.log('response', response)
		})
	}, [])

	return (
		<>
			<h1>Products Page!</h1>
			<h2>{JSON.stringify(products)}</h2>
			<Link to="/products/new">
				<button type="button" className="btn btn-primary">Sukurti produkta</button>
			</Link>
		</>
	)
}
