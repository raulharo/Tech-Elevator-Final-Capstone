import axios from 'axios';

export default {

    createProfile(profile) {
        return axios.post('create-profile', profile);
    },

    editProfile(profile) {
        return axios.put('edit-profile', profile);
    },

    getProfile(user) {
        return axios.get('get-profile', user);
    }

}