DROP TABLE IF EXISTS City;

CREATE TABLE City(
code VARCHAR(5) PRIMARY KEY,
name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS Distance;

CREATE TABLE Distance(
  id INTEGER NOT NULL,
  cityFromCode VARCHAR(5) NOT NULL,
  cityToCode VARCHAR(5) NOT NULL,
  distance DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO City VALUES
( 'JHB', 'Johannesburg' ),
('CPT', 'Cape Town'),
('DBN', 'Durban');

INSERT INTO Distance VALUES
(1, 'JHB', 'DBN', 700),
(2, 'DBN', 'JHB', 700),
(3, 'JHB', 'CPT', 1400),
(4, 'CPT', 'JHB', 1400),
(5, 'CPT', 'DBN', 1700),
(6, 'DBN', 'CPT', 1700);

