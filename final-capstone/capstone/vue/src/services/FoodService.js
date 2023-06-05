import axios from "axios";

export default {
    createMeal(meal) {
        return axios.post('/create-meal', meal);
    },

    getMeals() {
        return axios.get('/get-meals');
    }
}