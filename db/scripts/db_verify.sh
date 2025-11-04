#!/usr/bin/env bash
set -euo pipefail
sqlite3 bank.db < db/verify.sql
