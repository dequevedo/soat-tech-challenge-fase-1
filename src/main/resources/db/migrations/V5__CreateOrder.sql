CREATE TABLE order_entity (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    customer_id BIGINT REFERENCES customer_entity(id),
    status_id BIGINT REFERENCES order_status_entity(id) NOT NULL,
    total_price NUMERIC(10, 2)
);