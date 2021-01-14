import {createSlice} from "@reduxjs/toolkit";

const initialState = []

const cartSlice = createSlice({
	name: 'cart',
	initialState,
	reducers: {
		addProduct(state, { product }) {
			state.push(product)
		},
		removeProduct(state, { id }) {
			return state.filter(product => product.id !== id)
		}
	}
})

export const { addProduct, removeProduct } = cartSlice.actions
export default cartSlice.reducer
