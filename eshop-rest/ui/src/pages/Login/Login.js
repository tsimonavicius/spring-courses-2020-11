import {Form, Formik, Field, ErrorMessage} from "formik"

export default () => {

	return (
		<Formik>
			{(props) => (
				<Form>
					<div className="form-group">
						<label htmlFor="username">Username:</label>
						<Field name="username" id="username" className="form-control" placeholder="Please enter your username" />
					</div>
					<div className="form-group">
						<label htmlFor="password">Password:</label>
						<Field name="password" id="password" className="form-control" placeholder="Please enter your password" />
					</div>

					<button type="submit" className="btn btn-primary mt-2">Login</button>
				</Form>
			)}
		</Formik>
	)
}
