import {createSlice} from "@reduxjs/toolkit";

const initialState = []

const cartSlice = createSlice({
	name: 'cart',
	initialState,
	reducers: {
		addProduct(state, action) {
			state.push(action.product)
		},
		removeProduct(state, action) {
			return state.filter(product => product.id !== action.id)
		}
	}
})

export const { addProduct, removeProduct } = cartSlice.actions
export default cartSlice.reducer
