import axios from 'axios';

export default {

    createProfile(profile) {
        return axios.post('createProfile', profile);
    },

    editProfile(profile) {
        return axios.put('editProfile', profile);
    },

    getProfile(user) {
        return axios.get('getProfile', user);
    }

}