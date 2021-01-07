import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {fetchProducts} from "../../api/productsApi";

export default () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)

	useEffect(() => {
		setTimeout(() => fetchProducts().then(response => {
			setProducts(response.data)
			setIsLoading(false)
			console.log('response', response)
		}), 2000)

	}, [])

	return (
		<>
			<h1>Products Page!</h1>
			{
				isLoading ?
					(
						<div className="spinner-border" role="status">
						</div>
					) :
					<h2>{JSON.stringify(products)}</h2>
			}
			<Link to="/products/new">
				<button type="button" className="btn btn-primary">Sukurti produkta</button>
			</Link>
		</>
	)
}
