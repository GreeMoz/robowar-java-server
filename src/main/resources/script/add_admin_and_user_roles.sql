CREATE EXTENSION IF NOT EXISTS "pgcrypto";
insert into role(id, name, code) values
(gen_random_uuid(), 'Admin', 'ADMIN'),
(gen_random_uuid(), 'User', 'USER');