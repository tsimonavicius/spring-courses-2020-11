import axios from "axios";

export const getRandomText = () => axios.get('https://baconipsum.com/api/?type=meat-and-filler');