import {Route, Redirect} from "react-router-dom";
import useUser from "../../hooks/useUser";

export default ({ children, ...props }) => {
	const user = useUser()

	return (
		<Route {...props}>
			{
				!!user ? children : (
					<Redirect
						to={{
							pathname: '/login'
						}}
					/>
				)
			}
		</Route>
	)
}
