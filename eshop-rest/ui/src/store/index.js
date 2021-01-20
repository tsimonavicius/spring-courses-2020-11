import {configureStore} from "@reduxjs/toolkit";
import cart from './slices/cartSlice'
import {logger} from "redux-logger";

export default (initialState) => configureStore({
	reducer: {
		cart
	},
	middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger)
})
