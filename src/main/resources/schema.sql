CREATE TABLE stock (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(200) NOT NULL,
    company_name VARCHAR(200) NOT NULL,
    company_document VARCHAR(200) NOT NULL,
    type VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);