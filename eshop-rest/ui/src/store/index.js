import {configureStore} from "@reduxjs/toolkit";
import cart from './slices/cartSlice'

export default (initialState) => configureStore({
	reducer: {
		cart
	},
})
