CREATE TABLE mountains (
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45)
);

CREATE TABLE peaks (
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45),
mountain_id INT,
CONSTRAINT fk_peaks_mountains
FOREIGN KEY (mountain_id)
REFERENCES mountains(id)
);