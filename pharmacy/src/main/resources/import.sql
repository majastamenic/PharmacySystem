-- Pharmacies
insert into pharmacy (address, name) values('Rumenacka 15, Novi Sad', 'Jankovic');
insert into pharmacy (address, name) values('Hajduk Veljkova 8, Novi Sad', 'Benu');
insert into pharmacy (address, name) values('Bulevar Cara Lazara 76, Novi Sad', 'Zelena Apoteka');
insert into pharmacy (address, name) values('Bulevar Cara Lazara 88, Novi Sad', 'Galen pharm');
insert into pharmacy (address, name) values('Rumenacka 13, Novi Sad', 'Irisfarm');
insert into pharmacy (address, name) values('Futoski Put 85A, Novi Sad', 'Tilia');
-- Hospital
insert into hospital(email, name) values('integration.adapter@gmail.com', 'WellDevClinic');

-- Schedule
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-07', '08:00:00', '14:00:00');
insert into schedule(start_date, end_date, start_time, end_time) values('2021-02-01', '2021-02-07', '14:00:00', '20:00:00');

-- WorkSchedule
insert into work_schedule(schedule_id) values(1);
insert into work_schedule(schedule_id) values(2);

-- ********************************  USERS ****************************************************************
-- Patient
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Maja', 'Stamenic', 'maja@gmail.com', 'maja', 'Suboticka 23', 'Novi Sad', 'Srbija', '066/468965', 0, true);
insert into patient(id, verification_code, user_id) values(1, 'bgbhjjgfgggfhouytr', 1);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Gojko', 'Novcic', 'gojko@gmail.com', 'gojko', 'Rumenacka 23', 'Novi Sad', 'Srbija', '061/558877', 0, true);
insert into patient(id, verification_code, user_id) values(2, 'fdssdsdggsfgfsasgj', 2);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Tasa', 'Damjanac', 'tasa@gmail.com', 'tasa', 'Temerinska 23', 'Novi Sad', 'Srbija', '066/123466', 0, true);
insert into patient(id, verification_code, user_id) values(3, 'gdfhjgkrterfscvtyu', 3);
-- User: Pharmacist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Masa', 'Milanovic', 'masa@gmail.com', 'masa', 'Ticanova 23', 'Novi Sad', 'Srbija', '069/7798654', 3, true);
insert into pharmacist(id, is_first_log, pharmacy_id, user_id) values(1, true, 5, 4);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milan', 'Knezevic', 'milan@gmail.com', 'milan', 'Gagarinova 83', 'Novi Sad', 'Srbija', '065/963565', 3, true);
insert into pharmacist(id, is_first_log, pharmacy_id, user_id) values(2, true, 6, 5);
-- Admin
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Nikola', 'Luburic', 'nikola.luburic@uns.ac.rs', 'nikola', 'Marka Kraljevica 2', 'Novi Sad', 'Srbija', '062/468965', 1, true);
-- Dermatologist
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Milica', 'Pavlovic', 'milica@gmail.com', 'milica', 'Somborska 37', 'Novi Sad', 'Srbija', '063/887345', 2, true);
-- Supplier
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Luka', 'Djurdjevic', 'luka@gmail.com', 'luka', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 4, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Simona', 'Prokic', 'simona@gmail.com', 'simona', 'Fruskogorsa 15', 'Novi Sad', 'Srbija', '067/114885', 4, true);

insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Mikica', 'Djurdjevic', 'mikica@gmail.com', 'mikica', 'Futoska 101', 'Novi Sad', 'Srbija', '067/823789', 5, true);
insert into app_user (name, surname, email, password, address, city, country, phone, role, active) values ('Vikica', 'Prokic', 'vikica@gmail.com', 'vikica', 'Fruskogorsa 15', 'Novi Sad', 'Srbija', '067/114885', 5, true);
-- PharmacyAdmin
insert into pharmacy_admin(user_id, pharmacy_id, is_first_log) values (10,1,true);
insert into pharmacy_admin(user_id, pharmacy_id, is_first_log) values (11,2,true);

-- *********************************************************************************************************

-- WorkSchedule
insert into work_schedule(schedule_id) values(1);
insert into work_schedule(schedule_id) values(2);

--Medicine
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(62542, 0, 'Galenika', 'Brufen', 'Beleska 1', 0, 'Lek za temperaturu', 'cochenillrot, laktoza, monohidrat');
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(66042, 1, 'Optisorb', 'Panadol', 'Beleska 2', 1, 'Lek za bolove', 'kalijum-sorbat, prečišćeni talk');
insert into medicine(code, form_of_medicine, manufactured, name, note, publishing_type, type_of_medicine, composition) values(62217, 2, 'Bayer', 'Aspirin', 'Beleska 3', 0, 'Lek za bolove i prehladu', 'skrob, trietil-citrat');


-- Lekovi Jankovic
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.50, 2350, 1, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(2.00, 2985, 2, 1);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.75, 1420, 3, 1);
-- Lekovi Benu
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.44, 15, 1, 2);
insert into medicine_pharmacy(price, quantity, medicine_id, pharmacy_id) values(1.90, 18, 2, 2);


insert into app_order( end_date, end_time) values ('2021-02-07', '08:00:00');
insert into app_order(end_date, end_time) values ('2021-03-07', '04:00:00');

-- Za apoteku sa id=1
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.50, 2350, 1, 1);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (2.00, 2985, 2, 1);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.75, 1420, 3, 1);
-- Za apoteku sa id=2
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.44, 15, 1, 2);
INSERT INTO public.medicine_pharmacy(price, quantity, medicine_id, pharmacy_id)VALUES (1.90, 18, 2, 2);

insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(1, 62217);
insert into medicine_replacement_medicines(medicine_id, replacement_medicines) values(2, 66042);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 1);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 2);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(1, 3);

insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 4);
insert into pharmacy_medicine_pharmacy(pharmacy_id, medicine_pharmacy_id) values(2, 5);

insert into medicineeprescription(code, name, quantity) values(2, 'brufen', 123419);
insert into medicineeprescription(code, name, quantity) values(8, 'panadol', 6839093);

insert into eprescription(code, date_of_issue, file_text, patient_name) values(24363, null, 'Brufen, Panadol', 'Marko Markovic');
insert into eprescription(code, date_of_issue, file_text, patient_name) values(246663, null, 'Brufen', 'Petar Petrovic');

insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 1);
insert into eprescription_list_of_medication(eprescription_id, list_of_medication_id) values(1, 2);

-- PatientAllergicMedicines
insert into patient_allergic_medicines(patient_id, allergic_medicines_id) values(1, 1);
insert into patient_allergic_medicines(patient_id, allergic_medicines_id) values(1, 2);