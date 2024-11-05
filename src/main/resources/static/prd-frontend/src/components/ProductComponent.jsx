import React, { useEffect, useState } from 'react';
import { createProduct, getProduct, listProducts, updateProduct } from '../services/ProductService';
import { useNavigate, useParams } from 'react-router-dom';

export const ProductComponent = () => {
    const [originPrice, setOriginPrice] = useState('');
    const [quantity, setQuantity] = useState('');
    const [sellPrice, setSellPrice] = useState('');
    const [color, setColor] = useState('');
    const [description, setDescription] = useState('');
    const [productName, setProductName] = useState('');
    const [statusId, setStatusId] = useState('');
    const [subCateId, setSubCateId] = useState('');
    const [brandId2, setBrandId2] = useState('');


    const [attributes, setAttributes] = useState({
        status: [],
        categories: [],
        brands: []
    });

    const { productId,brandId } = useParams();

    useEffect(() => {
        setBrandId2(brandId); 
    }, [brandId]);

    const [errors, setErrors] = useState({
        originPrice: "",
        quantity: "",
        sellPrice: "",
        color: "",
        description: "",
        productName: "",
        statusId: "",
        subCateId: "",
        brandId2:""
    });

    const navigate = useNavigate();

    useEffect(() => {
        getAttributes();
        if (productId) {
            getProduct(productId).then((response) => {
                const data = response.data.productDto;
                setOriginPrice(data.originPrice);
                setQuantity(data.quantity);
                setSellPrice(data.sellPrice);
                setColor(data.color);
                setDescription(data.description);
                setProductName(data.productName);
                setStatusId(data.statusId);
                setSubCateId(data.subCateId)
            }).catch(error => console.error(error));
        }
    }, [productId]);

    function getAttributes() {
        listProducts().then((response) => {
            setAttributes(response.data.attributeDto);
        }).catch(error => console.error(error));
    }

    function addUpdateProduct(e) {

        e.preventDefault();
        if (validateForm()) {
            const product = { originPrice, quantity, sellPrice, color, description, productName, statusId, subCateId };
            if (productId) {
                updateProduct(productId,brandId,brandId2, product).then(() => {
                    console.log('id brand:'+brandId);
                    console.log('id brand2:'+brandId2)
                    navigate('/products');
                }).catch(error => console.error(error));
            } else {
                createProduct(brandId2,product).then(() => {
                    console.log(brandId2);
                    navigate('/products');
                }).catch(error => console.error(error));
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorCopy = { ...errors };

        if (productName.trim()) errorCopy.productName = '';
        else {
            errorCopy.productName = 'Product Name is required';
            valid = false;
        }

        if (color.trim()) errorCopy.color = '';
        else {
            errorCopy.color = 'Color is required';
            valid = false;
        }

        if (originPrice > 0) errorCopy.originPrice = '';
        else {
            errorCopy.originPrice = 'OriginPrice is required and must be greater than 0';
            valid = false;
        }

        if (sellPrice > 0) errorCopy.sellPrice = '';
        else {
            errorCopy.sellPrice = 'SellPrice is required and must be greater than 0';
            valid = false;
        }

        if (quantity > 0) errorCopy.quantity = '';
        else {
            errorCopy.quantity = 'Quantity is required and must be greater than 0';
            valid = false;
        }

        if (description.trim()) errorCopy.description = '';
        else {
            errorCopy.description = 'Description is required';
            valid = false;
        }
        if (statusId) errorCopy.statusId = '';
        else {
            errorCopy.statusId = 'Statur is required';
            valid = false;
        }
        if (subCateId) errorCopy.subCateId = '';
        else {
            errorCopy.subCateId = 'Category is required';
            valid = false;
        }
        if (brandId2) errorCopy.brandId2 = '';
        else {
            errorCopy.brandId2 = 'Brand is required';
            valid = false;
        }

        setErrors(errorCopy);
        return valid;
    }

    function pageTitle() {
        return <h2 className="text-center">{productId ? 'Update Product' : 'Add Product'}</h2>;
    }

    return (
        <div className="container">
            <div className="row">
                {pageTitle()}
                <form>

                    <div className="mb-3">
                        <label className="form-label">Product Name</label>
                        <input type="text" className={`form-control ${errors.productName ? 'is-invalid' : ''}`} name="productName" value={productName} onChange={(e) => setProductName(e.target.value)} />
                        {errors.productName && <div className="invalid-feedback">{errors.productName}</div>}
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Color</label>
                        <input type="text" className={`form-control ${errors.color ? 'is-invalid' : ''}`} name="color" value={color} onChange={(e) => setColor(e.target.value)} />
                        {errors.color && <div className="invalid-feedback">{errors.color}</div>}
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Origin Price</label>
                        <input type="number" step="0.1" className={`form-control ${errors.originPrice ? 'is-invalid' : ''}`} name="originPrice" value={originPrice} onChange={(e) => setOriginPrice(e.target.value)} />
                        {errors.originPrice && <div className="invalid-feedback">{errors.originPrice}</div>}
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Sell Price</label>
                        <input type="number" step="0.1" className={`form-control ${errors.sellPrice ? 'is-invalid' : ''}`} name="sellPrice" value={sellPrice} onChange={(e) => setSellPrice(e.target.value)} />
                        {errors.sellPrice && <div className="invalid-feedback">{errors.sellPrice}</div>}
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Quantity</label>
                        <input type="number" className={`form-control ${errors.quantity ? 'is-invalid' : ''}`} name="quantity" value={quantity} onChange={(e) => setQuantity(e.target.value)} />
                        {errors.quantity && <div className="invalid-feedback">{errors.quantity}</div>}
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Description</label>
                        <input type="text" className={`form-control ${errors.description ? 'is-invalid' : ''}`} name="description" value={description} onChange={(e) => setDescription(e.target.value)} />
                        {errors.description && <div className="invalid-feedback">{errors.description}</div>}
                    </div>

                    <div className="mb-3">
                        <select className={`form-control ${errors.brandId2 ? 'is-invalid' : ''}`} value={brandId2} name="brand" onChange={(e) => setBrandId2(e.target.value)}>
                            <option value="">Brand</option>
                            {attributes.brands.map(brand => (
                                <option key={brand.id} value={brand.id}>{brand.brandName}</option>
                            ))}
                        </select>
                        {errors.brandId2 && <div className="invalid-feedback">{errors.brandId2}</div>}
                    </div>

                    <div className="mb-3">
                        <select className={`form-control ${errors.subCateId ? 'is-invalid' : ''}`} name="subCateId" onChange={(e) => setSubCateId(e.target.value)}>
                            <option value="">Category</option>
                            {attributes.categories.map(category => (
                                <option key={category.id} value={category.id}>{category.cateName}</option>
                            ))}
                        </select>
                        {errors.subCateId && <div className="invalid-feedback">{errors.subCateId}</div>}
                    </div>

                    <div className="mb-3">
                        <select className={`form-control ${errors.statusId ? 'is-invalid' : ''}`} name="statusId" onChange={(e) => setStatusId(e.target.value)}>
                            <option value="">Status</option>
                            {attributes.status.map(status => (
                                <option key={status.id} value={status.id}>{status.statusName}</option>
                            ))}
                        </select>
                        {errors.statusId && <div className="invalid-feedback">{errors.statusId}</div>}
                    </div>

                    <button className="btn btn-success" onClick={addUpdateProduct}>Submit</button>

                </form>
            </div>
        </div>
    );
};

export default ProductComponent;
