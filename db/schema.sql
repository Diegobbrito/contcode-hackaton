CREATE DATABASE IF NOT EXISTS hackaton;
USE hackaton;

CREATE TABLE stock (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(200) NOT NULL,
    company_name VARCHAR(200) NOT NULL,
    company_document VARCHAR(200) NOT NULL,
    type VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO stock (code, company_name, company_document, type)
VALUES
    -- Ações (50)
    ('SANB11', 'Banco Santander Brasil S.A.', '90.400.888/0001-42', '31'),
    ('ITUB4', 'Itaú Unibanco Holding S.A.', '60.677.781/0001-12', '31'),
    ('BBDC3', 'Bradesco S.A.', '60.746.948/0001-12', '31'),
    ('PETR4', 'Petrobras S.A.', '33.000.167/0001-01', '31'),
    ('VALE3', 'Vale S.A.', '33.592.510/0001-54', '31'),
    ('AMAR3', 'Marcopolo S.A.', '88.073.089/0001-10', '31'),
    ('LREN3', 'Lojas Renner S.A.', '92.756.970/0001-00', '31'),
    ('MAGAZ11', 'Magazine Luiza S.A.', '46.180.404/0001-75', '31'),
    ('GGBR4', 'Gerdau S.A.', '33.611.677/0001-85', '31'),
    ('MGLU3', 'Magazine Luiza S.A.', '46.180.404/0001-75', '31'),
    ('KLBN11', 'Klabin S.A.', '60.256.116/0001-23', '31'),
    ('CSNA3', 'CSN S.A.', '33.043.602/0001-99', '31'),
    ('BBAS3', 'Banco do Brasil S.A.', '00.000.000/0001-91', '31'),
    ('B3SA3', 'B3 S.A.', '09.346.601/0001-25', '31'),
    ('EQTL3', 'Equatorial Energia S.A.', '03.220.432/0001-36', '31'),
    ('TAEE11', 'Taesa - Transmissora Aliança de Energia Elétrica S.A.', '02.998.311/0001-06', '31'),
    ('WEGE3', 'Weg S.A.', '84.429.695/0001-11', '31'),
    ('JBSS3', 'JBS S.A.', '02.916.265/0001-60', '31'),
    ('RENT3', 'Localiza Rent a Car S.A.', '17.197.349/0001-92', '31'),
    ('PETR3', 'Petrobras S.A.', '33.000.167/0001-01', '31'),
    ('SUZB3', 'Suzano S.A.', '16.404.287/0001-55', '31'),
    ('XPBR31', 'XP Inc.', '12.160.113/0001-16', '31'),
    ('BIDI11', 'Banco Inter S.A.', '00.000.000/0001-00', '31'),
    ('LREN3', 'Lojas Renner S.A.', '92.756.970/0001-00', '31'),
    ('ALUP11', 'Alupar Investimento S.A.', '06.105.024/0001-13', '31'),
    ('TIMP3', 'TIM S.A.', '02.858.703/0001-47', '31'),
    ('VVAR3', 'Via Varejo S.A.', '00.000.000/0001-33', '31'),
    ('HGTX3', 'Hering S.A.', '84.402.255/0001-50', '31'),
    ('CVCB3', 'CVC Brasil Operadora e Agência de Viagens S.A.', '04.020.729/0001-97', '31'),
    ('BEEF3', 'Minerva S.A.', '03.255.508/0001-10', '31'),
    ('PSSA3', 'Porto Seguro S.A.', '61.075.206/0001-07', '31'),
    ('VIVT3', 'Vivo S.A.', '02.449.988/0001-03', '31'),
    ('CPFE3', 'CPFL Energia S.A.', '02.362.732/0001-10', '31'),
    ('CGAS5', 'Companhia de Gás de São Paulo - COMGÁS', '00.000.000/0001-22', '31'),
    ('SULA11', 'SulAmérica S.A.', '29.164.503/0001-87', '31'),
    ('LIGT3', 'Light S.A.', '33.035.975/0001-03', '31'),
    ('SEER3', 'Ser Educacional S.A.', '04.323.731/0001-08', '31'),
    ('CNTO3', 'Centauro S.A.', '02.628.135/0001-35', '31'),
    ('BEEF3', 'Minerva S.A.', '03.255.508/0001-10', '31'),
    ('CEAB3', 'Ceará Banco S.A.', '03.531.595/0001-99', '31'),
    ('JHSF3', 'JHSF S.A.', '08.669.568/0001-09', '31'),
    ('LREN3', 'Lojas Renner S.A.', '92.756.970/0001-00', '31'),
    ('DMMO3', 'Duratex S.A.', '47.213.448/0001-06', '31'),
    ('PLPL3', 'Polo S.A.', '12.053.987/0001-58', '31'),
    ('ITSA4', 'Itaúsa S.A.', '60.677.781/0001-12', '31'),
    ('IRBR3', 'IRB Brasil RE', '00.000.000/0001-23', '31'),
    ('HAPV3', 'Hapvida S.A.', '11.413.515/0001-90', '31'),

    -- Fundos Imobiliários (10) - Dados reais
    ('HGRU11', 'Fundo de Investimento Imobiliário - HGRU', '30.040.459/0001-73', '31'),
    ('KNRI11', 'Fundo de Investimento Imobiliário - KNRI', '02.257.261/0001-69', '31'),
    ('MXRF11', 'Fundo de Investimento Imobiliário - MXRF', '29.952.744/0001-92', '31'),
    ('FEXC11', 'Fundo de Investimento Imobiliário - FEXC', '00.000.000/0001-00', '31'),
    ('VISC11', 'Fundo de Investimento Imobiliário - VISC', '00.000.000/0001-00', '31'),
    ('JSRE11', 'Fundo de Investimento Imobiliário - JSRE', '00.000.000/0001-00', '31'),
    ('RBRF11', 'Fundo de Investimento Imobiliário - RBRF', '00.000.000/0001-00', '31'),
    ('TRXF11', 'Fundo de Investimento Imobiliário - TRXF', '00.000.000/0001-00', '31'),
    ('BBPO11', 'Fundo de Investimento Imobiliário - BBPO', '00.000.000/0001-00', '31'),
    ('XPLG11', 'Fundo de Investimento Imobiliário - XPLG', '00.000.000/0001-00', '31'),

    -- BDRs (corrigido código de imposto como 32)
    ('GOGL34', 'Golden Ocean Group Ltd', '13.889.298/0001-52', '32'),
    ('NFLX34', 'Netflix Inc.', '78.389.710/0001-00', '32'),
    ('AAPL34', 'Apple Inc.', '94.302.210/0001-00', '32'),
    ('MSFT34', 'Microsoft Corporation', '30.687.343/0001-00', '32'),
    ('TSLA34', 'Tesla Inc.', '02.345.435/0001-00', '32');


GRANT ALL PRIVILEGES ON *.* TO 'usuario'@'%' WITH GRANT OPTION;
flush privileges;