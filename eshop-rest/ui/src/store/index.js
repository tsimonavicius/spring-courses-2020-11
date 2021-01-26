import {configureStore} from "@reduxjs/toolkit";
import cart, {loadCartFromStorage, subscribeToCartChanges} from './slices/cartSlice'
import {logger} from "redux-logger";
import user from './slices/userSlice'

export const createStore = (initialState) => {

	const store = configureStore({
		reducer: {
			cart,
			user
		},
		middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger),
		preloadedState: {cart: loadCartFromStorage(), ...initialState}
	})

	subscribeToCartChanges(store)

	return store
}

export default createStore()
