import {createSlice} from "@reduxjs/toolkit";

const initialState = {
	userData: null,
	jwt: null
}

const userSlice = createSlice({
	name: 'user',
	initialState,
	reducers: {
		setUserData(state, { payload: user }) {
			state.userData = user
		},
		setJwt(state, { payload: jwt }) {
			state.jwt = jwt
		}
	}
})

export default userSlice.reducer
export const { setUserData, setJwt } = userSlice.actions
