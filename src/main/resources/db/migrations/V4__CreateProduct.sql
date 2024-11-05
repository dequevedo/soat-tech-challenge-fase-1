CREATE TABLE product_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price NUMERIC(10, 2),
    category_id BIGINT REFERENCES category_entity(id)
);