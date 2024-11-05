CREATE TABLE order_entity_product (
    order_entity_id BIGINT REFERENCES order_entity(id),
    product_id BIGINT REFERENCES product_entity(id),
    PRIMARY KEY (order_entity_id, product_id)
);