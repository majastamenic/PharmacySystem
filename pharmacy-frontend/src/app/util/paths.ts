//export const BACKEND_PATH = 'https://pharmacy-25-backend.herokuapp.com';
export const BACKEND_PATH = 'http://localhost:8081'

export const USER_PATH = BACKEND_PATH + '/user';
export const LOGIN_PATH = USER_PATH + '/login';

export const PHARMACY_PATH = BACKEND_PATH + '/pharmacy';
export const HOSPITAL_PATH = BACKEND_PATH + '/hospital';
export const ACTION_PATH = BACKEND_PATH + '/actions';
export const REG_PATH = HOSPITAL_PATH + '/signup';

export const MEDICINE_PATH = BACKEND_PATH + '/medicine';
export const EPRESCRIPTION_PATH = BACKEND_PATH + '/ePrescription';
export const UPLOADQR_PATH = EPRESCRIPTION_PATH + '/uploadQr';
