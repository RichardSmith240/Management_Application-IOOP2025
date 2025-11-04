#!/usr/bin/env bash
set -euo pipefail

rm -f bank.db
sqlite3 bank.db < db/schema.sql

if [ -d db/migrations ]; then
  for f in db/migrations/*.sql; do
    [ -e "$f" ] || continue
    echo "Applying migration: $f"
    sqlite3 bank.db < "$f"
  done
fi

if [ -f db/seed.sql ]; then
  sqlite3 bank.db < db/seed.sql
fi

echo "🧼 Reset complete. Schema + migrations + seed applied."

