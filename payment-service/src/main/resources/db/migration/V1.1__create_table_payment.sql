CREATE TABLE challenge_payment.payment (
  id INT NOT NULL AUTO_INCREMENT,
  credit_card_number varchar(50),
  status varchar(50),
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);