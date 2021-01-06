import {useState} from "react";
import PropsState from "./PropsState";

export default () => {
	const [product, setProduct] = useState({name: '', inStock: ''})
	const [errors, setErrors] = useState({})

	const setProductName = (e) => {
		setErrors({})
		setProduct(prevProduct => ({
			...prevProduct,
			name: e.target.value
		}))
	}

	const setProductInStock = (e) => {
		setProduct(prevProduct => ({
			...prevProduct,
			inStock: e.target.value
		}))
	}

	const handleSubmit = (e) => {
		e.preventDefault()

		console.log("submitting data", product)
	}

	const validateName = ({ target: { value } }) => {
		if (!value) {
			setErrors({...errors, name: 'Producto "Pavadinimas" yra privalomas'})
		}
	}

	const validateInStock = (e) => {
		if (!e.target.value) {
			setErrors({...errors, inStock: 'Producto "Kiekis" yra privalomas'})
		}
	}

	return (
		<>
			<PropsState product={product} errors={errors}/>
			<form className="mx-4" onSubmit={handleSubmit}>
				<div className="form-group">
					<label htmlFor="name">Name:</label>
					<input type="text" id="name" name="name"
						   className="form-control"
						   placeholder="Please enter product name"
						   value={product.name}
						   onChange={setProductName}
						   onBlur={validateName}
					/>
					<small className="form-text text-danger">{errors.name}</small>
				</div>

				<div className="form-group">
					<label htmlFor="inStock">In stock:</label>
					<input type="text" id="inStock" name="inStock"
						   className="form-control"
						   placeholder="Please enter product's in stock number"
						   value={product.inStock}
						   onChange={setProductInStock}
						   onBlur={validateInStock}
					/>
					<small className="form-text text-danger">{errors.inStock}</small>
				</div>

				<button type="submit" className="btn btn-primary mt-2">Submit</button>
			</form>
		</>
	)
}
