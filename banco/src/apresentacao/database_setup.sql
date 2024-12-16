CREATE DATABASE IF NOT EXISTS banco;
USE banco;

-- contas
CREATE TABLE IF NOT EXISTS conta (
    numero VARCHAR(20) PRIMARY KEY,
    saldo DOUBLE NOT NULL,
    tipo_conta VARCHAR(20) NOT NULL
);

-- Conta Normal
CREATE TABLE IF NOT EXISTS conta_normal (
    numero VARCHAR(20) PRIMARY KEY,
    FOREIGN KEY (numero) REFERENCES conta(numero)
);

-- Conta Especial
CREATE TABLE IF NOT EXISTS conta_especial (
    numero VARCHAR(20) PRIMARY KEY,
    limite DOUBLE NOT NULL,
    FOREIGN KEY (numero) REFERENCES conta(numero)
);

-- Conta Débito Especial
CREATE TABLE IF NOT EXISTS conta_deb_especial (
    numero VARCHAR(20) PRIMARY KEY,
    FOREIGN KEY (numero) REFERENCES conta_especial(numero)
);
