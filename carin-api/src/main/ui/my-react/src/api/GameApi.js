import React from 'react'
import axios from 'axios'

export default axios.create({
    baseURL : `http://jsonplaceholder.typicode.com/`
});
