import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import Button from "@material-ui/core/Button";
import React from "react";
import {useDispatch, useSelector} from "react-redux";
import {removeProduct} from "../../store/slices/cartSlice";

export default () => {

	const products = useSelector(state => state.cart)
	const dispatch = useDispatch()

	return (
		<TableContainer>
			<Table >
				<TableHead>
					<TableRow>
						<TableCell align="center">#</TableCell>
						<TableCell align="center">Product name</TableCell>
						<TableCell align="center">Price</TableCell>
						<TableCell align="center"/>
					</TableRow>
				</TableHead>
				<TableBody>
					{
						products.map((p, i) => (
							<TableRow key={p.id}>
								<TableCell>{i + 1}</TableCell>
								<TableCell>{p.name}</TableCell>
								<TableCell>{p.price}</TableCell>
								<TableCell>
									<Button
										variant="contained"
										color="secondary"
										size="small"
										onClick={() => dispatch(removeProduct(p.id))}
									>Remove</Button>
								</TableCell>
							</TableRow>
						))
					}
				</TableBody>
			</Table>
		</TableContainer>
	)
}
