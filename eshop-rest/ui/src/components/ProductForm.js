import {useState} from "react";
import PropsState from "./PropsState";

export default () => {
	const [product, setProduct] = useState({name: ''})

	const setProductName = (e) => {
		setProduct({name: e.target.value})
	}

	const handleSubmit = (e) => {
		e.preventDefault()

		console.log("submitting data", product)
	}

	return (
		<>
			<PropsState product={product}/>
			<form className="mx-4" onSubmit={handleSubmit}>
				<div className="form-group">
					<label htmlFor="name">Name:</label>
					<input type="text" className="form-control" id="name"
						   placeholder="Please enter product name"
						   name="name"
						   value={product.name}
						   onChange={setProductName}
					/>
				</div>

				<button type="submit" className="btn btn-primary mt-2">Submit</button>
			</form>
		</>
	)
}
