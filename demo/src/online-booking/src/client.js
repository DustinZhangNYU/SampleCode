import fetch from 'unfetch';

export const getAllCustomers = () => fetch('/booking/customers');