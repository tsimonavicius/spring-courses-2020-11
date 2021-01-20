import {configureStore} from "@reduxjs/toolkit";
import cart from './slices/cartSlice'
import {logger} from "redux-logger";
import {loadFromStorage, saveToStorage} from "../utils/localStorage";
import _ from "lodash"

export default (initialState) => {

	const store = configureStore({
		reducer: {
			cart
		},
		middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger),
		preloadedState: loadFromStorage('state')
	})

	store.subscribe(_.throttle(() => {
		const state = store.getState()

		saveToStorage('state', state)
	}, 10000))

	return store
}