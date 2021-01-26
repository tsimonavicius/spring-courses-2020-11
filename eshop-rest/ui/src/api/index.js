import axios from "axios"
import store from '../store'

const HTTP = axios.create({
	baseURL: '/api'
})

HTTP.interceptors.request.use(config => {

	config.headers.authorization = store.getState().user.jwt
	return config
})

export { HTTP as default }
