import axios from 'axios';


// const http = axios.create ({
//     baseURL: "http://localhost:9000"
// });

export default {

    createProfile(profile) {
        return axios.post('create-profile', profile);
    },

    editProfile(profile) {
        return axios.put('edit-profile', profile);
    },

    getProfile(user) {
        return axios.get('get-profile', user);
    },

    deleteUser(id) {  //created to delete login if user does not agree to rules
        return axios.delete(`delete-user/${id}`);
    },

    getWeights() {
        return axios.get('get-weights')
    },

    updateCurrentWeight(weight){
        return axios.put('update-weight', weight, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },

    getMindfulGoal() {
        return axios.get(`get-mindful-goal/`);
    },

    getCalorieGoal(){
        return axios.get(`get-calorie-goal/`);

    },

    getDayCalories() {
        return axios.get('day-calories');
    },

    getDayMindful() {
        return axios.get('day-mindful');
    }

}