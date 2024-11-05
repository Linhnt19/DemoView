
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListProductComponents from './components/ListProductComponents'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { ProductComponent } from './components/ProductComponent'

function App() {

  return (
    <>
    <div style={{marginLeft:'10px',marginRight:'10px'}}>
    <BrowserRouter>
        <HeaderComponent />
        <Routes>

          {/* http://localhost:3000/ */}
          <Route path='/' element={<ListProductComponents/>}></Route>

          {/* http://localhost:3000/products */}
          <Route path='/products' element={<ListProductComponents/>}></Route>

          {/* http://localhost:3000/add-product */}
          <Route path='/add-product' element={<ProductComponent/>}></Route>

          {/* http://localhost:3000/edit-product/id */}
          <Route path='/edit-product/:productId/:brandId' element={<ProductComponent/>}></Route>

        </Routes>
        {/* <FooterComponent /> */}
      </BrowserRouter>
    </div>
      
    </>
  )
}

export default App
