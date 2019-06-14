CREATE DATABASE filmstore;

\c filmstore;

CREATE SCHEMA filmstore;
CREATE USER filmuser PASSWORD 'filmuser';
GRANT ALL PRIVILEGES ON SCHEMA filmstore TO filmuser;