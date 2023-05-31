import axios from 'axios';

export default {

    createProfile(profile) {
        console.log("Yes");
        return axios.post('createProfile', profile);
    }

}