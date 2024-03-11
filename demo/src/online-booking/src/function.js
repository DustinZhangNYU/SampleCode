import fetch from 'unfetch';

export const getAllReservations = () => fetch('/booking/user/getAllUsers');
export const getReservationsForCurrentUser  = (userId) => fetch(`/booking/reservation/getReservationByUserId?id=${userId}`);
export const getReservationsForCurrentStore  = (storeId) => fetch(`/booking/reservation/getReservationByStoreId?id=${storeId}`);
export const getStoreByManagerId  = (userId) => fetch(`/booking/store/getStoreByManagerId?id=${userId}`);
export const getReservationById = (id) => fetch(`/booking/reservation/getReservationByUserId?id=${id}`)
export const getAllStores = () => fetch('/booking/store/getAllStores')