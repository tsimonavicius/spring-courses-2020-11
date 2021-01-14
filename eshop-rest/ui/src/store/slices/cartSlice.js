import {createSlice} from "@reduxjs/toolkit";

const initialState = []

const cartSlice = createSlice({
	name: 'cart',
	initialState,
	reducers: {
		addProduct(state, { payload: product }) {
			state.push(product)
		},
		removeProduct(state, { payload: id }) {
			return state.filter(product => product.id !== id)
		}
	}
})

export const { addProduct, removeProduct } = cartSlice.actions
export default cartSlice.reducer
