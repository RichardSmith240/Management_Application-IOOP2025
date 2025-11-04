#!/usr/bin/env bash
set -euo pipefail
sqlite3 bank.db < db/schema.sql
echo "✅ Created bank.db & applied schema."
