import React, { Component } from 'react';
import './App.css';
import {
  Route,
  Navigate,
  BrowserRouter as Router,
  Routes } from 'react-router-dom';
import Restauranteur from './Restauranteur.js';
import Login from './Login.js';
import Customer from './Customer';

class App extends Component {
  state = {
    isLogin: false,
    isCustomer: true
  }

  render() {
    return (
      <div>
        <Router>
          <div>
            <Routes>
              <Route
                exact path="/"
                render={() => {
                  return (
                    this.state.isLogin ?
                    <Navigate to="/restauranteur" /> :
                    <Navigate to="/booking" /> 
                  )
                }}
              />
              <Route path="/booking" element={<Login />} />
              <Route path="/restauranteur" element={<Restauranteur />} />
              <Route path="/customer" element={<Customer />} />
            </Routes>
          </div>
        </Router>
      </div>
    );
  }
}

export default App;