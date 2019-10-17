CREATE TABLE challenge.order_item (
  order_id INT NOT NULL,
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(300) NOT NULL,
  unitPrice DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_ORDER_ITEM FOREIGN KEY (order_id) REFERENCES `order` (id)
);