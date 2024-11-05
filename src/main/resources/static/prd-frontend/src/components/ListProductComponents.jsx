import React, { useEffect, useState } from 'react'
import { deleteProduct, listProducts } from '../services/ProductService';
import { useNavigate } from 'react-router-dom';

function ListProductComponents() {
    //state hook

    const [attributes, setAttributes] = useState({
        status: [],
        categories: [],
        brands: []
    });

    const [productBrands,setProductBrands] =useState([]);

    const navigator = useNavigate();

    useEffect(() => {
        getAllProducts();
    }, [])

    function getAllProducts() {
        listProducts().then((response) => {

            setAttributes(response.data.attributeDto);
            setProductBrands(response.data.productBrandDto)

        }).catch(error => {
            console.error(error);
        })
    }

    function addNewProduct() {
        navigator('/add-product')
    }

    function updateProduct(productId,brandId) {
        navigator(`/edit-product/${productId}/${brandId}`);
        console.log('id sp'+productId,'id br' +brandId);
    }

    function removeProduct(productId,brandId) {
        console.log(productId,brandId);

        deleteProduct(productId,brandId).then(() => {
            getAllProducts();
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div>
            <div className='row' style={{ marginTop: '10px' }}>

                <div className="col-md-2">
                    <input type="text" className="form-control" placeholder="Name" name="name" />
                </div>
                <div className="col-md-2">
                    <input type="number" className="form-control" placeholder="Price" step="0,1" min="1" name="price" />
                </div>

                <div className="col-md-2">
                    <select className="form-control" name="Brand">
                        <option value="">Brand</option>

                        {
                            attributes.brands.map(brand =>
                                <option key={brand.id} value={brand.id}>{brand.brandName}</option>
                            )
                        }

                    </select>
                </div>

                <div className="col-md-2">
                    <select className="form-control" name="Category">
                        <option value="">Category</option>

                        {
                            attributes.categories.map(category =>
                                <option key={category.id} value={category.id}>{category.cateName}</option>
                            )
                        }

                    </select>
                </div>

                <div className="col-md-2">
                    <select className="form-control" name="Status">
                        <option value="">Status</option>

                        {
                            attributes.status.map(status =>
                                <option key={status.id} value={status.id}>{status.statusName}</option>
                            )
                        }

                    </select>
                </div>

                <div className="col-md-2">
                    <button className="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20px" height="25px" fill="currentColor"
                            className="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
                        </svg>
                    </button>
                </div>

            </div>

            <button className='btn btn-primary mb-2' onClick={addNewProduct}>Add Product</button>
            <h3>List of product</h3>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
            
                        <th>Product Name</th>
                        <th>Brand</th>
    
                        <th>SubCategory</th>
                        <th>Sell Price</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        productBrands.map(productBrand =>
                            <tr key={productBrand.productId}>
                                <td>{productBrand.productName}</td>
                                <td>{productBrand.brandName}</td>
                                <td>{productBrand.subCateName}</td>
                                <td>{productBrand.sellPrice}</td>
                                <td>{productBrand.statusName}</td>
                
                            
                                <td>
                                    <button className='btn btn-info' onClick={() => updateProduct(productBrand.productId)}>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                            className="bi bi-0-circle" viewBox="0 0 16 16">
                                            <path d="M7.988 12.158c-1.851 0-2.941-1.57-2.941-3.99V7.84c0-2.408 1.101-3.996 2.965-3.996 1.857 0 2.935 1.57 2.935 3.996v.328c0 2.408-1.101 3.99-2.959 3.99M8 4.951c-1.008 0-1.629 1.09-1.629 2.895v.31c0 1.81.627 2.895 1.629 2.895s1.623-1.09 1.623-2.895v-.31c0-1.8-.621-2.895-1.623-2.895" />
                                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8" />
                                        </svg>
                                    </button>

                                    <button className='btn btn-warning' onClick={() => updateProduct(productBrand.productId, productBrand.brandId)} style={{ marginLeft: '10px' }}>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                            className="bi bi-pencil-square" viewBox="0 0 16 16">
                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                                            <path fillRule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z" />
                                        </svg>
                                    </button>

                                    <button className='btn btn-danger' onClick={() => removeProduct(productBrand.productId, productBrand.brandId)} style={{ marginLeft: '10px' }}>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                            className="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
                                        </svg>
                                    </button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListProductComponents