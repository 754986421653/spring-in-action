CREATE TABLE Spittle (
	id IDENTITY,
	message VARCHAR(140) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	latitude DOUBLE,
	longitude DOUBLE	
);