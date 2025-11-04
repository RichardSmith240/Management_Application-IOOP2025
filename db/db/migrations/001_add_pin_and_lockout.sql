PRAGMA foreign_keys = ON;

-- Add optional PIN auth (hashed), and basic brute-force protection fields
ALTER TABLE users ADD COLUMN pin_hash TEXT;
ALTER TABLE users ADD COLUMN failed_attempts INTEGER DEFAULT 0;
ALTER TABLE users ADD COLUMN locked_until TIMESTAMP NULL;
