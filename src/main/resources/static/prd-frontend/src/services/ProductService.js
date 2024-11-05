import axios from "axios";

const REST_API_BASE_URL ="http://localhost:8080/api/products";

export const listProducts = () => axios.get(REST_API_BASE_URL);

export const createProduct= (brandId,product) => axios.post(REST_API_BASE_URL + '?brandId=' + brandId,product);

export const getProduct = (productId) => axios.get(REST_API_BASE_URL + '/' + productId);

export const updateProduct = (productId,brandId,brandId2, product) => axios.put(REST_API_BASE_URL + '/' + productId + '/' + brandId+ '?brandId2=' + brandId2, product);
// export const updateProduct = (productId,brandId, product) => axios.put(REST_API_BASE_URL + '/' + productId + '/' + brandId, product);


export const deleteProduct = (productId,brandId) => axios.delete(REST_API_BASE_URL + '/' + productId  + '/' + brandId);
