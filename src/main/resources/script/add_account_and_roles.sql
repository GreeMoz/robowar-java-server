CREATE EXTENSION IF NOT EXISTS "pgcrypto";
DO $$
DECLARE
	admin_id uuid := gen_random_uuid();
	admin_role_id uuid := gen_random_uuid();
BEGIN
	insert into role(id, name, code) values
		(admin_role_id, 'Admin', 'ADMIN'),
		(gen_random_uuid(), 'User', 'USER');

	insert into account(id, login, password, status) values
		(admin_id, 'admin', 'admin', 'ACTIVE');

	insert into account_roles(account_id, role_id) values
		(admin_id, admin_role_id);
END $$