#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE user_service;
    CREATE DATABASE job_service;
    CREATE DATABASE bid_service;
    CREATE DATABASE payment_service;
    CREATE DATABASE notification_service;
    CREATE DATABASE rating_service;
    CREATE DATABASE skill_service;
EOSQL