import {Form, Formik, Field, ErrorMessage} from "formik"
import PropsState from "../../components/PropsState"
import * as Yup from "yup"

const validationSchema = Yup.object().shape({
	name: Yup.string()
		.max(20, 'Name privalo buti trumpesnis nei 20')
		.required(),
	inStock: Yup.number()
		.integer('In stock privalo buti sveikas skaicius')
		.positive()
		.required(),
	price: Yup.number()
		.positive()
		.required()
		.test("is-price", "Turi buti validi kaina", (value) => {
			if (value !== '') {
				return (value + "").match(/^\d+(\.\d{1,2})?$/)
			}

			return true
		})
})

export default () => {
	return (
		<Formik
			initialValues={{
				name: '',
				inStock: '',
				price: '',
				description: ''
			}}
			onSubmit={(values, formikHelpers) => {
				console.log("values", values)
				console.log("formikHelpers", formikHelpers)

				setTimeout(() => {
					alert(JSON.stringify(values))
					formikHelpers.setSubmitting(false)
				}, 1000)
			}}
			validationSchema={validationSchema}>
			{(props) => (
				<>
					<PropsState {...props} />
					<Form className="mx-4">
						<div className="form-group">
							<label htmlFor="name">Name:</label>
							<Field name="name" id="name" className="form-control" placeholder="Please enter product name" />
							<ErrorMessage name="name" component="small" className="form-text text-danger"/>
						</div>

						<div className="form-group">
							<label htmlFor="inStock">In stock:</label>
							<Field name="inStock" id="inStock" className="form-control" placeholder="Please enter product in stock number" />
							<ErrorMessage name="inStock" component="small" className="form-text text-danger"/>
						</div>

						<div className="form-group">
							<label htmlFor="price">Price:</label>
							<Field name="price" id="price" className="form-control" placeholder="Please enter product price" />
							<ErrorMessage name="price" component="small" className="form-text text-danger"/>
						</div>

						<div className="form-group">
							<label htmlFor="description">Description:</label>
							<Field name="description" id="description" className="form-control"
								   placeholder="Please enter product description" component="textarea"
								   rows="10"/>
							<ErrorMessage name="description" component="small" className="form-text text-danger"/>
						</div>

						<button type="submit" className="btn btn-primary mt-2" disabled={props.isSubmitting}>Submit</button>
					</Form>
				</>
			)}
		</Formik>
	)
}
