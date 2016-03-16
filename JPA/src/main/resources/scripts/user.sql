-- cellular
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('101', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('201', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('301', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('401', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('501', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('601', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('701', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO cellular(cellular_id, number, version, created_time, created_by, modified_time, modified_by) VALUES ('801', '010-1234-5678', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- person
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('100', '101', 'bliex1', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('200', '201', 'bliex2', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('300', '301', 'bliex3', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('400', '401', 'bliex4', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('500', '501', 'bliex5', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('600', '601', 'bliex6', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('700', '701', 'bliex7', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO person(person_id, cellular_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('800', '801', 'bliex8', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- member
INSERT INTO member(member_id, name, address, version, created_time, created_by, modified_time, modified_by) VALUES ('100', 'bliex1', 'H스퀘어 103', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO member(member_id, name, address, version, created_time, created_by, modified_time, modified_by) VALUES ('200', 'bliex2', 'H스퀘어 203', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO member(member_id, name, address, version, created_time, created_by, modified_time, modified_by) VALUES ('300', 'bliex3', 'H스퀘어 303', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO member(member_id, name, address, version, created_time, created_by, modified_time, modified_by) VALUES ('400', 'bliex4', 'H스퀘어 403', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- order
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('100', 'iPhone1', 1, 10000, '100', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('200', 'iPhone2', 1, 20000, '200', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('300', 'iPhone3', 1, 30000, '300', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('400', 'iPhone4', 1, 40000, '400', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('500', 'iPhone5', 1, 50000, '100', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('600', 'iPhone6', 1, 60000, '200', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('700', 'iPhone7', 1, 70000, '300', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO orders(order_id, item, cnt, price, member_id, version, created_time, created_by, modified_time, modified_by) VALUES ('800', 'iPhone8', 1, 80000, '400', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- category
INSERT INTO category(category_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('100', 'category1', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO category(category_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('200', 'category2', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO category(category_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('300', 'category3', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO category(category_id, name, version, created_time, created_by, modified_time, modified_by) VALUES ('400', 'category4', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- product
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('100', '제품1', 10000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('200', '제품2', 10000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('300', '제품3', 30000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('400', '제품4', 40000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('500', '제품5', 50000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('600', '제품6', 60000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('700', '제품7', 70000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO product(product_id, name, price, version, created_time, created_by, modified_time, modified_by) VALUES ('800', '제품8', 80000, 1.0, NOW(), 'INIT',  NOW(), 'INIT');

--product_category
INSERT INTO product(product_id, name) VALUES ('100', '100');
INSERT INTO product(product_id, name) VALUES ('200', '100');
INSERT INTO product(product_id, name) VALUES ('300', '200');
INSERT INTO product(product_id, name) VALUES ('400', '200');
INSERT INTO product(product_id, name) VALUES ('100', '300');
INSERT INTO product(product_id, name) VALUES ('200', '300');
INSERT INTO product(product_id, name) VALUES ('300', '400');
INSERT INTO product(product_id, name) VALUES ('400', '400');

-- users
INSERT INTO users(id, password, name, email, version, created_time, created_by, modified_time, modified_by) VALUES ('spc', 'spc', 'spc', 'spc@gmail.com', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO users(id, password, name, email, version, created_time, created_by, modified_time, modified_by) VALUES ('bliex', 'bliex', 'bliex', 'spc@gmail.com', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

-- board
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (1, 'NOTICE_BOARD', 'title1', 'content1', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (2, 'NOTICE_BOARD', 'title2', 'content2', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (3, 'NOTICE_BOARD', 'title3', 'content3', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (4, 'NOTICE_BOARD', 'title4', 'content4', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (5, 'FREE_BOARD', 'title5', 'content5', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (6, 'FREE_BOARD', 'title6', 'content6', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (7, 'FREE_BOARD', 'title7', 'content7', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (8, 'FREE_BOARD', 'title8', 'content8', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (9, 'ALERT_BOARD', 'title9', 'content9', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, version, created_time, created_by, modified_time, modified_by) VALUES (10, 'ALERT_BOARD', 'title10', 'content10', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

COMMIT;