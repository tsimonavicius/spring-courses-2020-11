import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import { deleteProduct, fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import { useTranslation } from "react-i18next";
import Button from "@material-ui/core/Button";
import Loader from "../common/Loader";

const Products = () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)
	const { t } = useTranslation('products');

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
			<h1>{t('totalProductsDesc', { total: products.length })}</h1>
			<Link to="/products/new">
				<Button type="button" variant="contained" color="primary">Sukurti produkta</Button>
			</Link>
			{
				isLoading ? (<Loader />) :
					<ProductsTable
						products={products}
						handleDeleteClick={handleDeleteClick}
					/>

			}
		</>
	)
}

Products.displayName = "Products"

export default Products
