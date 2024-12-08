DO $$
    DECLARE
        userId1 INT := 1;  -- Sostituisci con l'id del primo utente
        userId2 INT := 2;  -- Sostituisci con l'id del secondo utente
        product1 INT;
        product2 INT;
        product3 INT;
        product4 INT;
        product5 INT;
        address1 INT;
        address2 INT;
        order1 INT;
        order2 INT;
        order3 INT;
        order4 INT;
        order5 INT;
    BEGIN
        -- Elimina i dati esistenti
        DELETE FROM web_order_quantities;
        DELETE FROM web_order;
        DELETE FROM inventory;
        DELETE FROM product;
        DELETE FROM address;

        -- Inserisci i prodotti
        INSERT INTO product (name, short_description, long_description, price)
        VALUES
            ('Product #1', 'Product one short description.', 'This is a very long description of product #1.', 5.50),
            ('Product #2', 'Product two short description.', 'This is a very long description of product #2.', 10.56),
            ('Product #3', 'Product three short description.', 'This is a very long description of product #3.', 2.74),
            ('Product #4', 'Product four short description.', 'This is a very long description of product #4.', 15.69),
            ('Product #5', 'Product five short description.', 'This is a very long description of product #5.', 42.59);

        -- Assegna gli id dei prodotti a variabili
        SELECT id INTO product1 FROM product WHERE name = 'Product #1' LIMIT 1;
        SELECT id INTO product2 FROM product WHERE name = 'Product #2' LIMIT 1;
        SELECT id INTO product3 FROM product WHERE name = 'Product #3' LIMIT 1;
        SELECT id INTO product4 FROM product WHERE name = 'Product #4' LIMIT 1;
        SELECT id INTO product5 FROM product WHERE name = 'Product #5' LIMIT 1;

        -- Inserisci le quantità di inventario
        INSERT INTO inventory (product_id, quantity)
        VALUES
            (product1, 5),
            (product2, 8),
            (product3, 12),
            (product4, 73),
            (product5, 2);

        -- Inserisci gli indirizzi
        INSERT INTO address (address_line_1, city, country, local_user_id)
        VALUES
            ('123 Tester Hill', 'Testerton', 'England', userId1),
            ('312 Spring Boot', 'Hibernate', 'England', userId2);

        -- Assegna gli id degli indirizzi a variabili
        SELECT id INTO address1 FROM address WHERE local_user_id = userId1 ORDER BY id DESC LIMIT 1;
        SELECT id INTO address2 FROM address WHERE local_user_id = userId2 ORDER BY id DESC LIMIT 1;

        -- Inserisci gli ordini
        INSERT INTO web_order (address_id, local_user_id)
        VALUES
            (address1, userId1),
            (address1, userId1),
            (address1, userId1),
            (address2, userId2),
            (address2, userId2);

        -- Assegna gli id degli ordini a variabili
        SELECT id INTO order1 FROM web_order WHERE address_id = address1 AND local_user_id = userId1 ORDER BY id DESC LIMIT 1;
        SELECT id INTO order2 FROM web_order WHERE address_id = address1 AND local_user_id = userId1 ORDER BY id DESC OFFSET 1 LIMIT 1;
        SELECT id INTO order3 FROM web_order WHERE address_id = address1 AND local_user_id = userId1 ORDER BY id DESC OFFSET 2 LIMIT 1;
        SELECT id INTO order4 FROM web_order WHERE address_id = address2 AND local_user_id = userId2 ORDER BY id DESC LIMIT 1;
        SELECT id INTO order5 FROM web_order WHERE address_id = address2 AND local_user_id = userId2 ORDER BY id DESC OFFSET 1 LIMIT 1;

        -- Inserisci le quantità degli ordini
        INSERT INTO web_order_quantities (web_order_id, product_id, quantity)
        VALUES
            (order1, product1, 5),
            (order1, product2, 5),
            (order2, product3, 5),
            (order2, product2, 5),
            (order2, product5, 5),
            (order3, product3, 5),
            (order4, product4, 5),
            (order4, product2, 5),
            (order5, product3, 5),
            (order5, product1, 5);

    END $$;
