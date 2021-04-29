CREATE TABLE lab (
    id INTEGER PRIMARY KEY
);

CREATE TABLE tribble (
    id INTEGER PRIMARY KEY,
    lab_id INTEGER REFERENCES lab(id) ON DELETE CASCADE
);

CREATE INDEX tribble_lab_index
    ON tribble (lab_id);