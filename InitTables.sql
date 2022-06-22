DROP TABLE IF EXISTS buyer CASCADE;
CREATE TABLE IF NOT EXISTS buyer
(
    id   bigserial PRIMARY KEY,
    nickname VARCHAR(255)
    );
    INSERT INTO buyer (nickname)
    VALUES ('Loki_cat'),
           ('Thor'),
           ('svG.'),
           ('Tony'),
           ('Soprano');


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products
(
    id   bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost double
    );

    INSERT INTO products (title, cost)
    VALUES ('Onion', 15.00),
           ('Garlic', 78.00),
           ('Orange', 120.00),
           ('Carrot', 50.00),
           ('Potato', 60.00),
           ('Banana', 55.00)
           ('Melon', 220.00);

DROP TABLE IF EXISTS bucket CASCADE;
CREATE TABLE IF NOT EXISTS bucket
(
    id          bigserial PRIMARY KEY,
    buyer_id bigint,
    product_id  bigint,
    price       double,
    FOREIGN KEY (buyer_id) REFERENCES buyer (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
    );

INSERT INTO bucket (buyer_id, product_id, price)
VALUES (1, 1, 15.00),
       (1, 1, 17.00),
       (1, 5, 60.00),
       (2, 4, 52.00),
       (2, 5, 60.00),
       (2, 4, 52.00),
       (2, 1, 15.00),
       (3, 7, 220.00),
       (4, 6, 60.00),
       (5, 5, 61.00),
       (5, 6, 60.00);