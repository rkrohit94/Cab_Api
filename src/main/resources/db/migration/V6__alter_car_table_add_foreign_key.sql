ALTER TABLE cars ADD  driver_id INT NOT NULL ;
ALTER TABLE cars ADD CONSTRAINT fk_driver_id  FOREIGN KEY (driver_id)  REFERENCES drivers(id);