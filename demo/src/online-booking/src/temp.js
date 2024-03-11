import React, { Component } from 'react';
import Container from './Container';
import Footer from './Footer';
import './App.css';
import { getAllCustomers } from './client';
import { Avatar, Table, Spin, Model } from 'antd';

class App extends Component {
    state = {
      customers: [],
      isFetching: false
    }
  
    componentDidMount () {
      this.fetchCustomers();
    }
  
    openAddStudentModel = () => this.setState({isAddCustomerModelVisible: true})
  
    closeAddStudentModel = () => this.setState({isAddCustomerModelVisible: false})
  
  
    fetchCustomers = () => {
      this.setState({
        isFetching: true,
        isAddCustomerModelVisible: false
      });
  
      getAllCustomers()
      .then(res => res.json()
      .then(customers => {
        console.log(customers);
        this.setState({
          customers,
          isFetching: false
        })
      }));
    }
  
    render() {
      const { customers, isFetching } = this.state;
  
      if (isFetching) {
        return (
          <Container>
          <Spin tip="Loading">
            
          </Spin>
          </Container>
        )
      }
  
      if (customers && customers.length) {
        const columns = [
          {
            title: '',
            key: 'avatar',
            render: (text, customer) => (
              <Avatar size='larget'>
                {`${customer.firstName.charAt(0).toUpperCase()}${customer.lastName.charAt(0).toUpperCase()}`}
              </Avatar>
            )
          },
          {
            title: 'Customer ID',
            dataIndex: 'customerId',
            key: 'customerId'
          },
          {
            title: 'First Name',
            dataIndex: 'firstName',
            key: 'firstName'
          },
          {
            title: 'Last Name',
            dataIndex: 'lastName',
            key: 'lastName'
          },
          {
            title: 'Gender',
            dataIndex: 'gender',
            key: 'gender'
          },
          {
            title: 'Email',
            dataIndex: 'email',
            key: 'eamil'
          },
          {
            title: 'Zip code',
            dataIndex: 'zipCode',
            key: 'zipCode'
          }
        ];
  
        return (
        <Container>
          <Table 
          dataSource={customers}
          columns = {columns}
          pagination = {false}
          rowKey = 'customerId'/>
        <Model
        titile = 'Add new customer'
        visible = {isAddCustomerModelVisible}
        onOk = {this.closeAddStudentModel}
        onCancel = {this.closeAddStudentModel}
        width = {1000}>
          
          <h1>Hello</h1>
  
        </Model>
  
          <Footer numberOfCustomers = {customers.length}>
          </Footer>
        </Container>
        );
      
      }
      return <h1>No Customers found</h1>
    }
  }