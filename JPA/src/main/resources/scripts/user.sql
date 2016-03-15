
INSERT INTO users(id, password, name, version, created_time, created_by, modified_time, modified_by) VALUES ('spc', 'spc', 'spc', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO users(id, password, name, version, created_time, created_by, modified_time, modified_by) VALUES ('bliex', 'bliex', 'bliex', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

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