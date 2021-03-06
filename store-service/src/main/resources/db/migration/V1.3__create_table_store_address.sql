CREATE TABLE challenge_store.store_address (
  store_id INT,
  id INT NOT NULL AUTO_INCREMENT,
  street VARCHAR(300) NOT NULL,
  number VARCHAR(100) NOT NULL,
  complement VARCHAR(100) NOT NULL,
  zipcode VARCHAR(10) NOT NULL,
  neighborhood VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  uf VARCHAR(5) NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_STORE_ADDRESS FOREIGN KEY (store_id) REFERENCES store (id)
);