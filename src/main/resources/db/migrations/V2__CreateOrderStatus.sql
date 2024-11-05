CREATE TABLE order_status_entity (
    id BIGSERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255)
);