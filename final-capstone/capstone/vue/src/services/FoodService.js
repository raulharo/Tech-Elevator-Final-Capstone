import axios from "axios";

export default {
    createMeal(meal) {
        return axios.post('/create-meal', meal);
    },

    getMeal(mealId) {
        return axios.get(`/get-meal/${mealId}`)
    },

    getMeals() {
        return axios.get('/get-meals');
    },

    updateFood(food) {
        return axios.put('/update-food', food);
    },

    updateMeal(meal) {
        return axios.put('/update-meal', meal);
    },

    deleteMeal(mealIdVar) {
        return axios.delete('/delete-meal', {data: {id: mealIdVar}});
    }
}