CREATE TABLE dealer(
    id BIGSERIAL PRIMARY KEY,
    fullName TEXT NOT NULL,
    email TEXT NOT NULL ,
    phoneNumber TEXT NOT NULL,
    password TEXT NOT NULL,
    address TEXT NOT NULL,
    registrationDate DATE NOT NULL
);
