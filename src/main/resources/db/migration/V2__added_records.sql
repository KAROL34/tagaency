INSERT INTO continent
VALUES ('1', 'Europa');
INSERT INTO continent
VALUES ('2', 'Azja');
INSERT INTO continent
VALUES ('3', 'Afryka');
INSERT INTO continent
VALUES ('4', 'Ameryka Południowa');
INSERT INTO continent
VALUES ('5', 'Ameryka Północna');
INSERT INTO continent
VALUES ('6', 'Australia i Oceania');

INSERT INTO country
VALUES ('1', 'Polska', '1');
INSERT INTO country
VALUES ('2', 'Grecja', '1');
INSERT INTO country
VALUES ('3', 'Hiszpania', '1');
INSERT INTO country
VALUES ('4', 'Brazylia', '4');
INSERT INTO country
VALUES ('5', 'Chiny', '2');
INSERT INTO country
VALUES ('6', 'Japonia', '2');
INSERT INTO country
VALUES ('7', 'Kenia', '3');
INSERT INTO country
VALUES ('8', 'Argentyna', '4');
INSERT INTO country
VALUES ('10', 'Australia', '6');
INSERT INTO country
VALUES ('11', 'Nowa Zelandia', '6');

INSERT INTO city
VALUES ('1', 'Gdynia', '1');
INSERT INTO city
VALUES ('2', 'Kraków', '1');
INSERT INTO city
VALUES ('3', 'Warszawa', '1');
INSERT INTO city
VALUES ('4', 'Ateny', '2');
INSERT INTO city
VALUES ('5', 'Szanghaj', '5');
INSERT INTO city
VALUES ('6', 'Gdańsk', '1');
INSERT INTO city
VALUES ('7', 'Tokio', '6');
INSERT INTO city
VALUES ('8', 'Wrocław', '1');
INSERT INTO city
VALUES ('9', 'Nairobi', '7');
INSERT INTO city
VALUES ('10', 'Sydney', '10');
INSERT INTO city
VALUES ('11', 'Wellington', '11');

INSERT INTO hotel
VALUES ('1', 'Piękny hotel z widokiem na morze.', 'Antracyt', '5', '1');
INSERT INTO hotel
VALUES ('2', 'Idealny hotel na wyjazd służbowy', 'Sheraton', '5', '3');
INSERT INTO hotel
VALUES ('3', 'Pięknie położony hotel, z dostępem do plaży.', 'Zeus', '3', '4');
INSERT INTO hotel
VALUES ('4', 'Taki hotel że hoho', 'Budda', '4', '5');
INSERT INTO hotel
VALUES ('5', 'Hotel jako tako', 'Yako Tako', '2', '7');
INSERT INTO hotel
VALUES ('6', 'Ekstra luksusowa ziemianka!', 'UngaHotelunga', '4', '9');
INSERT INTO hotel
VALUES ('7', 'Hotel nad morzem z widokiem na skaczące kangury', 'Pod dzikim kangurem', '4', '10');

INSERT INTO airport
VALUES ('1', 'Lotnisko Chopina', '3');
INSERT INTO airport
VALUES ('2', 'Port lotniczy Ateny', '4');
INSERT INTO airport
VALUES ('3', 'Shanghai Pudong Airport', '5');
INSERT INTO airport
VALUES ('4', 'Port Lotniczy Rębiechowo', '6');
INSERT INTO airport
VALUES ('5', 'Port lotniczy Tokio-Haneda', '7');
INSERT INTO airport
VALUES ('6', 'Lotnisko Nairobi', '9');
INSERT INTO airport
VALUES ('7', 'Lotnisko Wrocław', '8');
INSERT INTO airport
VALUES ('8', 'Port lotniczy Sydney', '10');

-- id - cena.dorosly - miejsca.dor - cena.dziecko - miejsca.dzie - il.dni - koniec.data - prom.- pocz.data - typ - lotn.przylot
-- miasto.przylot - lotn.odlot - miasto.odlot - hotel

INSERT INTO trip
VALUES ('1', '1899.99', '50', '1349.99', '35', '7', '2019-08-23', '1', '2019-12-16', 'BB', '2', '4', '1', '3', '3');
INSERT INTO trip
VALUES ('2', '3299.99', '30', '2499.99', '10', '12', '2019-09-29', '0', '2019-12-17', 'BB', '3', '5', '4', '6', '4');
INSERT INTO trip
VALUES ('3', '3899.99', '60', '2899.99', '25', '10', '2019-10-29', '0', '2019-10-19', 'BB', '5', '7', '1', '3', '5');
INSERT INTO trip
VALUES ('4', '5499.99', '40', '4899.99', '10', '14', '2019-12-29', '1', '2019-12-15', 'HB', '6', '9', '7', '8', '6');
INSERT INTO trip
VALUES ('5', '11999.99', '45', '8899.99', '25', '12', '2019-12-13', '1', '2019-12-01', 'BB', '8', '10', '7', '8', '7');