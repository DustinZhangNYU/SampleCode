import React, { Component} from 'react';
import LoginContainer from './LoginContainer';
import { Button, Checkbox, Form, Input, message } from 'antd';

class Login extends Component {
  state = {
    email: '',
    password: '',
    isLogin: false,
    isCustomer: true
  }

  onFinish = (values) => {
    this.setState({
      email: values.email,
      password: values.password
    })
    console.log(this.state);
  };

  onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  failMessage = () => {
    message.info('Incorrect email or password.')
  };

  handleSubmit = async (e) => {
    console.log(this.state)

    try {
      let res = await fetch("/booking/user/login", {
        method: "POST",
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify(
          this.state
        ),
      });

      let resJson = await res.json();

      const userId = resJson.id;
      const type = resJson.type;

      sessionStorage.setItem("userId", userId);
      sessionStorage.setItem("type", type);

      if (res.status === 200) {
        window.location.href = "/customer";
      } else {
        alert("wrong password or email")  
      }
    } catch (err) {
      console.log(err);
      alert("wrong password or email")
    }
  }

    render() {
      return (
      <LoginContainer>
        <h1>Online Booking System</h1>
      <Form
        name="basic"
        id='login'
        labelCol={{
          span: 8,
        }}
        wrapperCol={{
          span: 16,
        }}
        initialValues={{
          remember: true,
        }}
        onFinish = {this.onFinish}
        onFinishFailed = {this.failMessage}
        autoComplete="off"
      >
        <Form.Item
          label="Email"
          name="email"
          rules={[
            {
              required: true,
              message: 'Please input your email!',
            },
          ]}
        >
          <Input value={this.state.email}/>
        </Form.Item>
  
        <Form.Item
          label="Password"
          name="password"
          rules={[
            {
              required: true,
              message: 'Please input your password!',
            },
          ]}
        >
          <Input.Password value={this.state.password}/>
        </Form.Item>
  
        <Form.Item
          name="remember"
          valuePropName="checked"
          wrapperCol={{
            offset: 8,
            span: 16,
          }}
        >
          <Checkbox>Remember me</Checkbox>
        </Form.Item>
  
        <Form.Item
          wrapperCol={{
            offset: 8,
            span: 16,
          }}
        >
          <Button type="primary"
            htmlType="submit"
            onClick={this.handleSubmit}
            >
            Login
          </Button>
          <Button type="link" htmlType="submit">
            Register
          </Button>
        </Form.Item>
      </Form>
      </LoginContainer>
      );
    }
}
  
export default Login;