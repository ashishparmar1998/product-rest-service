-- dummy seller data
insert into SELLER(ID, NAME)
values (1, 'ashish'),
       (2, 'aman'),
       (3, 'pyiyanka');

insert into PRODUCT (id, name, type, category, price, addon)
values (1, 'Dell Latitude 5420', 'laptop', 'electronics', 55000.00,
        'ram=16gb,cpu=intel core i3 7210,gpu= Intel Iris Xe Integrated Graphics'),
       (2, 'Tenda N301 Wireless-N300 Easy Setup Router', 'routers', 'electronics', 3500.00,
        'Connector Type=RJ45,Brand=tenda,Frequency Band Class= Single-Band,Operating System=Windows, Android'),
       (3, 'Head & Shoulders, Anti-Hairfall, Anti-Dandruff Shampoo for Women & Men , 650ml', 'shampoo', 'beauty',
        350.00,
        'Hair Type=Thinning/Hairfall,Recommended Uses=Anti-dandruff,Scent=Fresh,Brand=Head & Shoulders'),
       (4, 'VEGA Round Brush For Men & Women, (R3-RB), Color May Vary', 'hair bursh', 'beauty', 200.00,
        'Skin Type=normal,Product Benefits=Scalp Stimulation,Colour=black,Material=nylon'),
       (5, 'AMERICAN CREW Polo Collar T-Shirt for Plus Size Men', 'tshirt', 'cloths', 700.00,
        'Product Dimensions=30 x 20 x 2 cm; 350 Grams,Manufacturer=Sunstar Appparels Private Limited,Item Weight =350gm'),
       (6, 'Denver black jeans', 'jeans', 'cloths', 1500.00,
        'Package Dimensions=33.7 x 27 x 6.7 cm; 510 Grams,Department=men,Item Weight =510gm');

insert into SELLER_PRODUCTS(seller_id, product_id)
values (1, 3),
       (1, 5),
       (2, 1),
       (2, 4),
       (3, 2),
       (3, 6);