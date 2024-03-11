import React from 'react';
import { Badge, Calendar } from 'antd';
import {getReservationsForCurrentStore,getStoreByManagerId} from './function';
const userId = sessionStorage.getItem("userId")
const uType = sessionStorage.getItem("type")
console.log(userId)
var reservation = []
let storeId = 3
async function getStoreId(id) {
  const response = await fetch(`/booking/store/getStoreByManagerId?id=${id}`).then(response => response.json());
  console.log(response)
  const response2 = await fetch(`/booking/reservation/getReservationByStoreId?id=${response.id}`).then(response => response.json());
  reservation = response2
  console.log(reservation)
}
if(userId != null && uType != null && uType == 'e') {
  getStoreId(userId)
}



const getListData = (value) => {
  var listDate = []
  for(let i = 0; i < reservation.length;i++){
    const myObject = reservation[i]
    const date = new Date(myObject.startTime);
    if(date.getDate() == value.date() && date.getMonth() == value.month() && value.year() == date.getFullYear()){
      if(myObject.customer == null) {
        listDate.push({'type': 'warning', 'content' : "No Customer yet"})
      }
      else{
        listDate.push({'type': 'success', 'content' : myObject.customer.firstName + " " + myObject.customer.lastName})
      }
    }
    
  }
  return listDate
  // switch (value.month()) {
  //   case 8:
  //     listData = [
  //       {
  //         type: 'warning',
  //         content: 'This is warning event.',
  //       },
  //       {
  //         type: 'success',
  //         content: 'This is usual event.',
  //       },
  //     ];
  //     break;
  //   case 10:
  //     listData = [
  //       {
  //         type: 'warning',
  //         content: 'This is warning event.',
  //       },
  //       {
  //         type: 'success',
  //         content: 'This is usual event.',
  //       },
  //       {
  //         type: 'error',
  //         content: 'This is error event.',
  //       },
  //     ];
  //     break;
  //   case 15:
  //     listData = [
  //       {
  //         type: 'warning',
  //         content: 'This is warning event',
  //       },
  //       {
  //         type: 'success',
  //         content: 'This is very long usual event。。....',
  //       },
  //       {
  //         type: 'error',
  //         content: 'This is error event 1.',
  //       },
  //       {
  //         type: 'error',
  //         content: 'This is error event 2.',
  //       },
  //       {
  //         type: 'error',
  //         content: 'This is error event 3.',
  //       },
  //       {
  //         type: 'error',
  //         content: 'This is error event 4.',
  //       },
  //     ];
  //     break;
  //   default:
  // }
  // return listData || [];
};
const getMonthData = (value) => {
  if (value.month() === 8) {
    return 1394;
  }
};
const Restaurateur = () => {
    const monthCellRender = (value) => {
    const num = getMonthData(value);
    return num ? (
      <div className="notes-month">
        <section>{num}</section>
        <span>Backlog number</span>
      </div>
    ) : null;
  };
  const dateCellRender = (value) => {
    const listData = getListData(value);
    return (
      <ul className="events">
        {listData.map((item) => (
          <li key={item.content}>
            <Badge status={item.type} text={item.content} />
          </li>
        ))}
      </ul>
    );
  };
  return <Calendar dateCellRender={dateCellRender} monthCellRender={monthCellRender}/>
  ;
};
export default Restaurateur;