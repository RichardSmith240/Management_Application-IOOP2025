.tables
.schema users
.schema sessions
SELECT COUNT(*) AS users_count FROM users;
SELECT * FROM users LIMIT 3;
.tables
.schema users
.schema sessions

.headers on
.mode column
SELECT id, username, created_at, failed_attempts, locked_until, (pin_hash IS NOT NULL) AS has_pin
FROM users
LIMIT 5;
