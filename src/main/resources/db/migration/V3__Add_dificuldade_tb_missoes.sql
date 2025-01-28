-- V3: Migrations para adicionar a coluna DIFICULDADE na tabela de missoes

ALTER TABLE tb_missoes ADD COLUMN dificuldade VARCHAR(255);