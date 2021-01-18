import HTTP from './'

export const fetchProducts = () => HTTP.get('/products');

export const addProduct = (product) => HTTP.post('/products', product);

export const deleteProduct = (id) => HTTP.delete(`/products/${id}`);

export const fetchSingleProduct = (id) => HTTP.get(`/products/${id}`);
