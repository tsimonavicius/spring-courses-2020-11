import PropTypes from 'prop-types';

function ProductTable(props) {

    const { products, handleDeleteClick } = props;

    return (
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Product name</th>
                <th>Description</th>
                <th>In Stock</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {
                products.map(p => (
                    <tr key={p.id}>
                        <td>{p.id}</td>
                        <td>{p.name}</td>
                        <td>{p.description}</td>
                        <td>{p.inStock}</td>
                        <td>{p.price}</td>
                        <th>
                            <button onClick={() => handleDeleteClick(p.id)}>Delete product</button>
                        </th>
                    </tr>
                ))
            }
            </tbody>
        </table>
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
}

export default ProductTable;