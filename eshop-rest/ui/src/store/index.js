import {configureStore} from "@reduxjs/toolkit";
import cart from './slices/cartSlice'
import {logger} from "redux-logger";
import {loadFromStorage, saveToStorage} from "../utils/localStorage";

export default (initialState) => {

	const store = configureStore({
		reducer: {
			cart
		},
		middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger),
		preloadedState: loadFromStorage('state')
	})

	store.subscribe(() => {
		const state = store.getState()

		saveToStorage('state', state)
	})

	return store
}