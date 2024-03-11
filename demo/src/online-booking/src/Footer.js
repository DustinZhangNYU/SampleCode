import { Avatar, Button } from "antd";
import React from "react";
import Container from "./Container";
import './Footer.css';

const Footer = (props) => (
    <div className = 'footer'>
        <Container>
            {props.numberOfCustomers ?
                <Avatar
                style={{backgroundColor: '#f56a00', marginRight: '5px'}}
                size='larger'>{props.numberOfCustomers} </Avatar> : null
            }
            <Button type='primary'>
                Add customer +
            </Button>
        </Container>
    </div>
)

export default Footer;