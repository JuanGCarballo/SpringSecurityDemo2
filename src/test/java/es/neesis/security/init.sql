INSERT INTO USERS (ID, PASSWORD, USERNAME) VALUES (1, 'Test', 'Nekku');
INSERT INTO USERS (ID, PASSWORD, USERNAME) VALUES (2, 'Test', 'User');
INSERT INTO USERS (ID, PASSWORD, USERNAME) VALUES (3, 'Test', 'Gestor');
INSERT INTO USERS (ID, PASSWORD, USERNAME) VALUES (4, 'Test', 'Consultor');
INSERT INTO ROLES (ID, NAME) VALUES (1, 'Admin');
INSERT INTO ROLES (ID, NAME) VALUES (2, 'User');
INSERT INTO ROLES (ID, NAME) VALUES (3, 'Gestion');
INSERT INTO ROLES (ID, NAME) VALUES (4, 'Consulta');
INSERT INTO USERS_ROLES (ROLES_ID, USER_ENTITY_ID) VALUES (1,1);
INSERT INTO USERS_ROLES (ROLES_ID, USER_ENTITY_ID) VALUES (2,2);
INSERT INTO USERS_ROLES (ROLES_ID, USER_ENTITY_ID) VALUES (3,3);
INSERT INTO USERS_ROLES (ROLES_ID, USER_ENTITY_ID) VALUES (4,4);
INSERT INTO AUTHORIZED_IPS (ID, IP) VALUES (1, '0:0:0:0:0:0:0:1');
INSERT INTO AUTHORIZED_IPS (ID, IP) VALUES (2, '50.50.50.50');