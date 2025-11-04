-- Demo users (password hashes only).
-- Example hash below is BCrypt for the sample password "demo123!" (replace for real demos).
-- Generate your own with: Java BCrypt, Python passlib, or an online generator you trust.
IDELETE FROM users;

INSERT OR IGNORE INTO users(username, password_hash, pin_hash)
VALUES (
  'demo',
  '$2a$12$REPLACE_WITH_YOUR_PASSWORD_HASH',
  '$2a$12$REPLACE_WITH_YOUR_PIN_HASH'
);