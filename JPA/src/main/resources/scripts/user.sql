
INSERT INTO users(id, password, name, version, created_time, created_by, modified_time, modified_by) VALUES ('spc', 'spc', 'spc', 1.0, NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO users(id, password, name, version, created_time, created_by, modified_time, modified_by) VALUES ('bliex', 'bliex', 'bliex', 1.0, NOW(), 'INIT',  NOW(), 'INIT');

INSERT INTO boards(id, board_type, title, contents, created_time, created_by, modified_time, modified_by) VALUES ('1', 'NOTICE_BOARD', 'title', 'content', NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, created_time, created_by, modified_time, modified_by) VALUES ('2', 'NOTICE_BOARD', 'title', 'content', NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, created_time, created_by, modified_time, modified_by) VALUES ('3', 'FREE_BOARD', 'title', 'content', NOW(), 'INIT',  NOW(), 'INIT');
INSERT INTO boards(id, board_type, title, contents, created_time, created_by, modified_time, modified_by) VALUES ('4', 'FREE_BOARD', 'title', 'content', NOW(), 'INIT',  NOW(), 'INIT');

COMMIT;