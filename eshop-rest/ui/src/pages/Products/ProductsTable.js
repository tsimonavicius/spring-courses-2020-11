import PropTypes from 'prop-types';
import Button from "@material-ui/core/Button";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import React from "react";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableContainer from "@material-ui/core/TableContainer";
import {connect} from "react-redux";
import {addProduct} from "../../store/slices/cartSlice";
import {Link} from "react-router-dom";

function ProductTable({ products, handleDeleteClick, addProduct }) {

    return (
        <TableContainer>
            <Table >
                <TableHead>
                    <TableRow>
                        <TableCell align="center">#</TableCell>
                        <TableCell align="center">Product name</TableCell>
                        <TableCell align="center">Description</TableCell>
                        <TableCell align="center">In Stock</TableCell>
                        <TableCell align="center">Price</TableCell>
                        <TableCell align="center"/>
                        <TableCell align="center"/>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {
                        products.map(p => (
                            <TableRow key={p.id}>
                                <TableCell>{p.id}</TableCell>
                                <TableCell><Link to={`/products/${p.id}`}>{p.name}</Link></TableCell>
                                <TableCell>{p.description}</TableCell>
                                <TableCell>{p.inStock}</TableCell>
                                <TableCell>{p.price}</TableCell>
                                <TableCell>
                                    <Button
                                        variant="outlined"
                                        color="secondary"
                                        size="small"
                                        onClick={() => handleDeleteClick(p.id)}
                                    >Delete</Button>
                                </TableCell>
                                <TableCell>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        size="small"
                                        onClick={() => addProduct({
                                            id: p.id,
                                            name: p.name,
                                            price: p.price
                                        })}
                                    >Add</Button>
                                </TableCell>
                            </TableRow>
                        ))
                    }
                </TableBody>
            </Table>
        </TableContainer>
    )
}

ProductTable.propTypes = {
    products: PropTypes.arrayOf(
        PropTypes.shape({
            id: PropTypes.number.isRequired,
            name: PropTypes.string.isRequired,
            description: PropTypes.string.isRequired,
            inStock: PropTypes.number.isRequired,
            price: PropTypes.number.isRequired,
        })
    ).isRequired,
    handleDeleteClick: PropTypes.func.isRequired,
    addProduct: PropTypes.func
}

const mapDispatchToProps = {
    addProduct
}

export default connect(null, mapDispatchToProps)(ProductTable);
