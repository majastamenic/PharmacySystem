import { environment } from "src/environments/environment.prod";
import { DermatologistService } from "../service/dermatologist.service";

export const BACKEND_PATH ='http://localhost:8081';
//export const BACKEND_PATH = environment.backend_url ? environment.backend_url :'http://localhost:8081';


export const USER_PATH = BACKEND_PATH + '/user';
export const LOGIN_PATH = USER_PATH + '/login';
export const PASSWORD_USER_PATH = USER_PATH + '/password';
export const INFO_PATH = USER_PATH + '/info';
export const UPDATE_USER_PATH = USER_PATH + '/update';

export const PHARMACY_PATH = BACKEND_PATH + '/pharmacy';
export const PHARMACY_PROFIT = PHARMACY_PATH + '/profit';
export const PHARMACY_FROM_PHARMACY_NAME = PHARMACY_PATH + '/ph';
export const AVAILABLE_PHARMACIES = PHARMACY_PATH + '/availablePharmacies';  // Gets pharmacies with available pharmacists
export const HOSPITAL_PATH = BACKEND_PATH + '/hospital';
export const ACTION_PATH = BACKEND_PATH + '/actions';

export const MEDICINE_PATH = BACKEND_PATH + '/medicine';
export const MEDICINE_SEARCH_PATH = MEDICINE_PATH + '/search';
export const MEDICINEALL_PATH = MEDICINE_PATH + '/getAllMedicines';
export const MEDICINES_CHECK_PATH = MEDICINE_PATH + '/check';
export const MEDICINES_CHECK_PHARMACIST_PATH = MEDICINES_CHECK_PATH + '/pharmacist';
export const MEDICINE_SPECIFICATION_PATH = MEDICINE_PATH + '/specification';

export const RESERVATION_PATH = BACKEND_PATH + '/medicineReservation';
export const RESERVATION_MEDICINE_PATH = RESERVATION_PATH + '/accept';

export const EPRESCRIPTION_PATH = BACKEND_PATH + '/ePrescription';
export const UPLOADQR_PATH = EPRESCRIPTION_PATH + '/uploadQr';
export const QR_ORDER_PATH = EPRESCRIPTION_PATH + '/order';
export const EPRESCRIPTION_PATIENT_PATH = EPRESCRIPTION_PATH + '/patient';
export const SCHEDULE_PATH = BACKEND_PATH + '/workschedule';

export const PHARMACIST_PATH = BACKEND_PATH + '/pharmacist';
export const PHARMACIST_REGISTRATION_PATH = PHARMACIST_PATH + '/registration';
export const PHARMACISTSBYPHARMACY_PATH = PHARMACIST_PATH + '/pharmacist';
export const DELETEPHARMACIST_PATH = PHARMACIST_PATH + '/delete';
export const FREE_PHARMACIST_PATH = PHARMACIST_PATH + '/free';
export const PHARMACIST_VACATION_CHECK_PATH = PHARMACIST_PATH + '/check/vacation';

export const PATIENT_PATH = BACKEND_PATH + '/patient';
export const PATIENT_VALID_PATH = PATIENT_PATH + '/valid';
export const UPDATE_ALLERGY_PATH = PATIENT_PATH + '/updateAllergy';
export const PATIENT_EMAIL_PATH = PATIENT_PATH + '/examination';

export const DERMATOLOGIST_PATH = BACKEND_PATH + '/dermatologist';
export const ADD_DERMATOLOGIST_AND_WORKSCHEDULE =  DERMATOLOGIST_PATH + '/addDermatologist';
export const DERMATOLOGISTS_BY_ADMIN =  DERMATOLOGIST_PATH + '/findByPharmacy';
export const DERMATOLOGISTS_DEFINE_EXAM =  DERMATOLOGIST_PATH + '/examination';
export const DELETE_DERMATOLOGIST_PATH = DERMATOLOGIST_PATH;
export const DERMATOLOGIST_BY_PHARMACY = DERMATOLOGIST_PATH + '/dermatologists';
export const DERMATOLOGIST_VACATION_CHECK_PATH = DERMATOLOGIST_PATH + '/check/vacation';

export const PHARMACY_ADMIN_PATH = BACKEND_PATH + '/phadmin';
export const SUPPLIER_PATH = BACKEND_PATH + '/supplier';


export const SYSTEM_ADMIN_PATH = BACKEND_PATH + '/system_admin';

export const PRICELISTDEFINE_PATH = BACKEND_PATH + '/pricelist/define';

export const COUNSELING_PATH = BACKEND_PATH + '/counseling';
export const COUNSELING_ADD_PATH = COUNSELING_PATH + '/add';
export const COUNSELING_START_PATH = COUNSELING_PATH + '/start';
export const PATIENT_COUNSELINGS_PATH = COUNSELING_PATH + '/patient';
export const COUNSELING_UPDATE_PATH = COUNSELING_PATH + '/update';
export const CREATE_COUNSELING_PHARMACIST_PATH = COUNSELING_PATH + '/create/pharmacist';
export const COUNSELING_FIND_PATIENT = COUNSELING_PATH + '/find';


export const MEDICINEPHARMACY_PATH = BACKEND_PATH + '/medicinepharmacy';
export const GET_MEDICINEPHARMACY_PATH = MEDICINEPHARMACY_PATH + '/getMedicines';
export const GET_MEDICINEPHARMACY_NUMBER_PATH = MEDICINEPHARMACY_PATH + '/number';

export const GET_MEDICINEPHARMACYBYADMIN_PATH = MEDICINEPHARMACY_PATH + '/getMedicinesByAdminPharmacy';
export const ORDER_INIT_PATH = BACKEND_PATH + '/order/define';
export const MEDICINES_PHARMACY_PATH = MEDICINEPHARMACY_PATH + '/all';
export const MEDICINES_PHARMACIST_PATH = MEDICINES_PHARMACY_PATH + '/pharmacist';
export const MEDICINEPH_BY_MEDICINE_PATH = MEDICINEPHARMACY_PATH + '/medicine';

export const EXAMINATION_PATH = BACKEND_PATH + '/examination';
export const EXAMINATION_NUMBER_PATH = EXAMINATION_PATH + '/number';
export const FREE_EXAM_TERMS_PATH = EXAMINATION_PATH + '/freeTerms';
export const SCHEDULE_EXAM_PATH = EXAMINATION_PATH + '/schedule';
export const CANCEL_EXAMINATION = EXAMINATION_PATH + '/cancel';
export const EXAMINATION_START_PATH = EXAMINATION_PATH + '/start';
export const EXAMINATION_UPDATE_PATH = EXAMINATION_PATH + '/update';
export const PATIENT_EXAMINATIONS = EXAMINATION_PATH + '/scheduled';
export const FREE_EXAM_TERMS_WORKER_PATH = EXAMINATION_PATH + '/free';
export const FREE_PREDEFINED_TERMS = EXAMINATION_PATH + '/freeterms/dermatologist';
export const CREATE_EXAMINATION_DERMATOLOGIST_PATH = EXAMINATION_PATH + '/create/dermatologist';
export const EXAMINATION_FIND_PATIENT_PATH = EXAMINATION_PATH + '/find';

export const DIAGNOSIS_PATH = BACKEND_PATH + '/diagnosis';
export const DIAGNOSIS_ADD_PATH = DIAGNOSIS_PATH + '/add';

export const MEDICINE_LOYALTY_PATH = MEDICINE_PATH + '/loyalty';
export const LOYALTY_GROUP_PATH = BACKEND_PATH + '/loyaltyGroup';
export const CATEGORY_PATH = LOYALTY_GROUP_PATH + '/category';

export const COMPLAINT_PATH = BACKEND_PATH + '/complaint';

export const ORDER_PATH = BACKEND_PATH + '/order';
export const OFFER_PATH = BACKEND_PATH + '/supplier-offer';
export const OFFERS_PATH = OFFER_PATH + '/offers';
export const ORDERS_PATH = ORDER_PATH + '/orders';
export const FINISHED_ORDERS_PATH = ORDER_PATH + '/finishedOrders';
export const UPDATE_WINNER_PATH = ORDER_PATH + '/winner';

export const VACATION_PATH = BACKEND_PATH + '/vacation';
export const VACATIONS_DERMATOLOGIST_PATH = VACATION_PATH + '/dermatologist';
export const VACATION_PHARMACIST_PATH = VACATION_PATH + '/pharmacist';
export const VACATIONS_PHARMACISTS_PATH = VACATION_PATH + '/pharmacyAdmin';
export const VACATIONS_DERMATOLOGISTS_PATH = VACATION_PATH + '/admin';
export const VACATIONS_CONFIRMATION_PHARMACISTS_PATH = VACATION_PATH + '/confirmationPh';
export const VACATIONS_CONFIRMATION_DERMATOLOGISTS_PATH = VACATION_PATH + '/confirmation';

export const SUBSCRIBE_PATH = PHARMACY_PATH + '/subscribe';
export const UNSUBSCRIBE_PATH = PHARMACY_PATH + '/unsubscribe';
export const PHARMACY_SUB_PATH = PHARMACY_PATH + '/sub_pharmacy';

export const RATING_PHARMACIST_PATH = BACKEND_PATH + '/pharmacistRating'
export const RATING_DERMATOLOGIST_PATH = BACKEND_PATH + '/dermatologistRating'
export const RATING_MEDICINE_PATH = BACKEND_PATH + '/medicineRating'
export const RATING_PHARMACY_PATH = BACKEND_PATH + '/pharmacyRating'
