CREATE TABLE challenge.order_item (
  id INT NOT NULL AUTO_INCREMENT,
  description String NOT NULL,
  unitPrice Number NOT NULL,
  quantity INT NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);