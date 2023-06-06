import axios from "axios";

export default {
    createMeal(meal) {
        return axios.post('/create-meal', meal);
    },

    getMeals() {
        return axios.get('/get-meals');
    },

    updateFood(food) {
        return axios.put('/update-food', food);
    },

    updateMeal(meal) {
        return axios.put('/update-meal', meal);
    }
}