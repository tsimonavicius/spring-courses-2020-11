import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import { deleteProduct, fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";

export default () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)

	useEffect(() => {
		loadAllProducts();
	}, [])

	const loadAllProducts = () => {
		setIsLoading(true);
		fetchProducts()
			.then(response => {
				setProducts(response.data) // [{id: 1, description: "aaa" ... }, {id: 2, name: "" ....}]
			})
			.finally(() => {
				setIsLoading(false);
			})
	}

	const handleDeleteClick = (id) => {
		setIsLoading(true);
		deleteProduct(id)
			.then(() => {
				loadAllProducts();
			})
			.finally(() => {
				setIsLoading(false);
			})
	}

	return (
		<>
			<h1>Products Page!</h1>
			{
				isLoading ?
					(
						<div className="spinner-border" role="status">
						</div>
					) :
					<ProductsTable
						products={products}
						handleDeleteClick={handleDeleteClick}
					/>

			}
			<Link to="/products/new">
				<button type="button" className="btn btn-primary">Sukurti produkta</button>
			</Link>
		</>
	)
}
