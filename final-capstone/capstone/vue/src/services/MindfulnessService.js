import axios from "axios";

export default {
    logActivity(activity) {
      return axios.post('/mindfulness', activity);
    },

    getActivity() {
      return axios.get('get-mindful');
    },

    getMindful(mindfulId) {
      return axios.get(`get-mindful/${mindfulId}`)
    }
}