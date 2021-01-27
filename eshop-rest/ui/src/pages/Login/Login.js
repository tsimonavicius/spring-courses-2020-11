import {Form, Formik, Field} from "formik"
import PropsState from "../../components/PropsState";
import {login} from "../../api/usersApi";
import {useHistory, useLocation} from "react-router-dom";
import {useDispatch} from "react-redux";
import {setJwt, setUserData} from "../../store/slices/userSlice";

export default () => {
	const history = useHistory()
	const location = useLocation()
	const dispatch = useDispatch()

	const postLogin = (loginData, { setSubmitting }) => {
		setSubmitting(true)

		login(loginData)
			.then(({data, headers: { authorization }}) => {
				dispatch(setUserData(data))
				dispatch(setJwt(authorization))

				const { from } = location.state || {
					from: {
						pathname: '/'
					}
				}

				history.push(from)
			})
			.finally(() => setSubmitting(false))
	}

	return (
		<Formik
			initialValues={{
				username: '',
				password: ''
			}}
			onSubmit={postLogin}
		>
			{(props) => (
				<>
					<PropsState {...props} />
					<Form>
						<div className="form-group">
							<label htmlFor="username">Username:</label>
							<Field name="username" id="username" className="form-control" placeholder="Please enter your username" />
						</div>
						<div className="form-group">
							<label htmlFor="password">Password:</label>
							<Field name="password" id="password" type="password" className="form-control" placeholder="Please enter your password" />
						</div>

						<button type="submit" className="btn btn-primary mt-2" disabled={props.isSubmitting}>Login</button>
					</Form>
				</>
			)}
		</Formik>
	)
}
