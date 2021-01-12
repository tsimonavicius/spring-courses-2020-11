import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {fetchProducts} from "../../api/productsApi";

export default () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)

	useEffect(() => {
		fetchProducts()
		.then(response => {
			setProducts(response.data) // [{id: 1, description: "aaa" ... }, {id: 2, name: "" ....}]
		}).finally(() => {
			setIsLoading(false);
		})

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
					<table>
						<thead>
							<tr>
								<th>#</th>
								<th>Product name</th>
								<th>Description</th>
								<th>In Stock</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
						{
							products.map(p => (
								<tr key={p.id}>
									<td>{p.id}</td>
									<td>{p.name}</td>
									<td>{p.description}</td>
									<td>{p.inStock}</td>
									<td>{p.price}</td>
								</tr>
							))
						}
						</tbody>
					</table>
			}
			<Link to="/products/new">
				<button type="button" className="btn btn-primary">Sukurti produkta</button>
			</Link>
		</>
	)
}
