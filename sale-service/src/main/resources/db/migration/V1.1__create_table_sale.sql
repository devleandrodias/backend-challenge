CREATE TABLE challenge_sale.sale (
  id INT NOT NULL AUTO_INCREMENT,
  confirmation_date DATETIME NULL,
  status varchar(50),
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);