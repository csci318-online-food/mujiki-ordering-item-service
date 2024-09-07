CREATE TABLE items (
    id UUID PRIMARY KEY,
    restaurant_id UUID,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE,
    availability BOOLEAN DEFAULT true,
    create_at TIMESTAMP,
    modify_at TIMESTAMP,
    modify_by VARCHAR(255),
    create_by VARCHAR(255)
);