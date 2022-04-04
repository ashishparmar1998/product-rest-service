-- dummy seller data
insert into SELLER(ID, NAME)
values (1001, 'ashish'),
       (1002, 'aman'),
       (1003, 'pyiyanka');

insert into PRODUCT (id, name, type, category, price, addon,seller_id)
values (9001, 'Dell Latitude 5420', 'laptop', 'electronics', 55000.00,
        'ram=16gb,cpu=intel core i3 7210,gpu= Intel Iris Xe Integrated Graphics',1002),
       (9002, 'Tenda N301 Wireless-N300 Easy Setup Router', 'routers', 'electronics', 3500.00,
        'Connector Type=RJ45,Brand=tenda,Frequency Band Class= Single-Band,Operating System=Windows, Android',1001),
       (9003, 'Head & Shoulders, Anti-Hairfall, Anti-Dandruff Shampoo for Women & Men , 650ml', 'shampoo', 'beauty',
        350.00,
        'Hair Type=Thinning/Hairfall,Recommended Uses=Anti-dandruff,Scent=Fresh,Brand=Head & Shoulders',1001),
       (9004, 'VEGA Round Brush For Men & Women, (R3-RB), Color May Vary', 'hair bursh', 'beauty', 200.00,
        'Skin Type=normal,Product Benefits=Scalp Stimulation,Colour=black,Material=nylon',1003),
       (9005, 'AMERICAN CREW Polo Collar T-Shirt for Plus Size Men', 'tshirt', 'cloths', 700.00,
        'Product Dimensions=30 x 20 x 2 cm; 350 Grams,Manufacturer=Sunstar Appparels Private Limited,Item Weight =350gm',1002),
       (9006, 'Denver black jeans', 'jeans', 'cloths', 1500.00,
        'Package Dimensions=33.7 x 27 x 6.7 cm; 510 Grams,Department=men,Item Weight =510gm',1003);

