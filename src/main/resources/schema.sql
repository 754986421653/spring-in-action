CREATE TABLE IF NOT EXISTS Spittle (
	id IDENTITY,
	message VARCHAR(140) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	latitude DOUBLE,
	longitude DOUBLE	
);

CREATE TABLE IF NOT EXISTS Spitter (
  id IDENTITY,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  first_name VARCHAR(40) NOT NULL,
  last_name VARCHAR(40) NOT NULL
);