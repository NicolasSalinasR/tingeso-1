import axios from "axios";

const BackEndServer = import.meta.env.VITE_BACKEND_SERVER
const BackEndPort = import.meta.env.VITE_BACKEND_PORT

export default axios.create((
baseURL: "http://$(BackEndServer):$(BackEndPort)",
headers: {
    "content-Type": "application/json"
}

))