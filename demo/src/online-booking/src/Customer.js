import React, { Component } from 'react';
import {
    Divider,
    Modal,
    Button,
    Table,
    Form,
    Input,
    Radio,
    Select,
    DatePicker,
    TimePicker,
    Switch,
    List
    } from 'antd';
import { getReservationById,getAllStores} from './function';
import { Container } from './Container';

const { TextArea } = Input;

class Customer extends Component {
    state = {
        reservations: [],
        restaurants: [],
        isAddReservationVisible: false
    }

    componentDidMount () {
        this.fetchReservations();
      }

    openNewReservation = () => this.setState({isAddReservationVisible: true})

    closeNewReservation = () => this.setState({isAddReservationVisible: false})

    userId = sessionStorage.getItem("userId");

    fetchReservations = () => {
        this.setState({
            isAddReservationVisible: false
        });

        getReservationById(this.userId)
        .then(res => res.json()
        .then(reservations => {
            //console.log(reservations);
            this.setState({
                reservations
            })
        }));
    }



    render() {
        const { reservations, isAddReservationVisible, restaurants } = this.state;
        if ( reservations && reservations.length ) {
            const reservationColumns = [
                {
                    title: 'Restaurant',
                    key: 'storeName',
                    render: (text, reservation) => (
                        <List.Item>
                            {`${reservation.store.name}`}
                        </List.Item> 
                    )
                },
                {
                    title: 'Start Time',
                    dataIndex: 'startTime',
                    key: 'startTime'
                },
                {
                    title: 'End Time',
                    dataIndex: 'endTime',
                    key: 'endTime'
                }
            ];


            // const restaurantColumns = [
            //     {
            //         title: 'Restaurant',
            //         dataIndex: 'storeName',
            //         key: 'storeName'
            //     },
            //     {
            //         title: 'Start Time',
            //         dataIndex: 'startTime',
            //         key: 'startTime'
            //     },
            //     {
            //         title: 'End Time',
            //         dataIndex: 'endTime',
            //         key: 'endTime'
            //     },
            // ]

            //console.log(reservationColumns)

        return (
            <>
            <Divider orientation="left">Your Reservations</Divider>
            <Table
            dataSource={reservations}
            columns = {reservationColumns}
            pagination = {false}
            rowKey = 'name'
            />
            <Divider orientation="left">Available Restaurants</Divider>

            <Modal
            titile = 'Make new reservation'
            visible = {isAddReservationVisible}
            onOk = {this.closeNewReservation}
            okText = "That's it!"
            onCancel = {this.closeNewReservation}
            width = {1000}>

<>
      <Form
        labelCol={{
          span: 4,
        }}
        wrapperCol={{
          span: 14,
        }}
        layout="horizontal"
      >
        
        <Form.Item label="Restaurants">
          <Select>
            <Select.Option>Jeju Noodle Bar</Select.Option>
            <Select.Option>Atomix</Select.Option> 
            <Select.Option>Panda express</Select.Option>
            <Select.Option>NYU restaurant</Select.Option>
          </Select>
        
        </Form.Item>
        <Form.Item label="Party Size">
          <Select>
            <Select.Option value="demo">1</Select.Option>
            <Select.Option value="demo">2</Select.Option>
            <Select.Option value="demo">3</Select.Option>
            <Select.Option value="demo">4</Select.Option>
            <Select.Option value="demo">5</Select.Option>
            <Select.Option value="demo">6</Select.Option>
            <Select.Option value="demo">7</Select.Option>
            <Select.Option value="demo">8</Select.Option>
            <Select.Option value="demo">Over 9</Select.Option>
          </Select>
        </Form.Item>
        <Form.Item label="Date">
          <DatePicker />
          <TimePicker.RangePicker format={'HH:mm'} />
          </Form.Item>
        <Form.Item label="Notes">
          <TextArea rows={4} />
        </Form.Item>
        <Form.Item label="" valuePropName="checked">
          <Switch />
        </Form.Item>
        <Form.Item label="Allergy?">
          <Radio.Group>
            <Radio value="apple"> Yes </Radio>
            <Radio value="pear"> No </Radio>
          </Radio.Group>
        </Form.Item>
        {/* <Form.Item label="Button">
          <Button>Button</Button>
        </Form.Item> */}
      </Form>
    </>

            </Modal>

            <Container>
            <Button
            onClick={this.openNewReservation}
            type = 'primary'>
                Make new Reservation
            </Button>
            </Container>
        </>);
        }
    }
}

export default Customer;