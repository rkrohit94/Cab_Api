ALTER TABLE passengers ADD  city_id INT NOT NULL ;
ALTER TABLE passengers ADD CONSTRAINT fk_city_id  FOREIGN KEY (city_id)  REFERENCES cities(id);