USE five;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100)
);

CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    project_lead_id INT,
    CONSTRAINT fk_clients FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    project_id INT,
    CONSTRAINT fk_projects FOREIGN KEY (project_id)
        REFERENCES projects (id)
);

ALTER TABLE projects ADD 
CONSTRAINT fk_projects1
FOREIGN KEY (project_lead_id)
REFERENCES employees(id)
;