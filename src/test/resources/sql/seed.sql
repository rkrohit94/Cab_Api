USE cabtest;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE table cities;
TRUNCATE table cars;
TRUNCATE table drivers;
TRUNCATE table passengers;
TRUNCATE table trips;
set FOREIGN_KEY_CHECKS = 1;


INSERT INTO cities (name,state,day_rate,night_rate) VALUES
  ('bangalore', 'karnataka',25,40),
  ('new delhi', 'Delhi',25,50);


INSERT INTO passengers(name,age,gender,credit_balance,city_id)VALUES
  ('abc',45,'MALE',10000,1),
  ('passenger1',35,'MALE',10000,1),
  ('test',25,'MALE',1000,2);

INSERT INTO drivers(name,age,gender)VALUES
  ('abc',45,'MALE'),
  ('test',25,'MALE'),
  ('drivrename',35,'FEMALE');


INSERT INTO cars(make,model,year,type,driver_id)VALUES
  ('hyundai','i20',2010,'BASIC',1),
  ('hyundai','i10',2011,'BASIC',1),
  ('Honda','Civic',2000,'LUX',2);


INSERT INTO trips(city_id,car_id,passenger_id,driver_id,kms_driven,trip_cost,tip,total_trip_cost,trip_start_time,trip_end_time)VALUES
  (1,1,1,1,10,100,10,110,"2015-01-01","2015-01-01"),
  (2,1,2,1,20,200,10,220,"2015-01-02","2015-01-02");

