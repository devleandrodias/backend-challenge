CREATE TABLE challenge.sale_item (
  sale_id INT NOT NULL,
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(300) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_SALE_ITEM FOREIGN KEY (sale_id) REFERENCES sale (id)
);