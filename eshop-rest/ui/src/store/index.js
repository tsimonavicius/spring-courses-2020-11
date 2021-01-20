import {configureStore} from "@reduxjs/toolkit";
import cart, {loadCartFromStorage, subscribeToCartChanges} from './slices/cartSlice'
import {logger} from "redux-logger";

export default (initialState) => {

	const store = configureStore({
		reducer: {
			cart
		},
		middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger),
		preloadedState: {cart: loadCartFromStorage(), ...initialState}
	})

	subscribeToCartChanges(store)

	return store
}