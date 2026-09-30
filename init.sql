CREATE TABLE village (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE village_part (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    village_id BIGINT NOT NULL REFERENCES village(id)
);