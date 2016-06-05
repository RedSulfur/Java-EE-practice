/*
CREATE SCHEMA payment_joined;

DROP TABLE payment;
*//*

*//*
CREATE TABLE payment_joined.payment (
  payment_id BIGSERIAL NOT NULL,
  amount     DOUBLE PRECISION,
  CONSTRAINT payment_pkey PRIMARY KEY (payment_id)
);*//*

*//*
INSERT INTO payment_joined.payment (payment_id,amount) VALUES (1,195.90);
INSERT INTO payment_joined.payment (payment_id,amount) VALUES (2,26.65);
INSERT INTO payment_joined.payment (payment_id,amount) VALUES (3,130.87);
INSERT INTO payment_joined.payment (payment_id,amount) VALUES (4,229.31);*//*

CREATE TABLE payment_joined.credit_payment(
  card_number CHARACTER VARYING(255)
);*/

/*create table payment_joined.cash_payment(
  cash_desk VARCHAR(255),
  payment_id INT,
  CONSTRAINT cash_payment_fkey FOREIGN KEY (payment_id)
  REFERENCES payment_joined.payment (payment_id),
  CONSTRAINT cash_payment_pkey PRIMARY KEY (payment_id)
);*/

/*create table payment_joined.cheque_payment(
  bank_id VARCHAR(255),
  payment_id INT,
  CONSTRAINT cheque_payment_fkey FOREIGN KEY (payment_id)
  REFERENCES payment_joined.payment (payment_id),
  CONSTRAINT cheque_payment_pkey PRIMARY KEY (payment_id)
);*/
/*

CREATE TABLE payment_joined.credit_payment (
  credit_number VARCHAR(255),
  payment_id    INT,
  CONSTRAINT credit_payment_fkey FOREIGN KEY (payment_id)
  REFERENCES payment_joined.payment (payment_id),
  CONSTRAINT credit_payment_pkey PRIMARY KEY (payment_id)
);
*/




































