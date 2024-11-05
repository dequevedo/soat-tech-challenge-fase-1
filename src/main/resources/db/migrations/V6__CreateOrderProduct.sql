CREATE TABLE order_entity_product (
    id BIGSERIAL PRIMARY KEY,
    order_entity_id BIGINT REFERENCES order_entity(id),
    product_id BIGINT REFERENCES product_entity(id)
);