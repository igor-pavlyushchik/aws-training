CREATE TABLE IF NOT EXISTS image_metadata (
    id SERIAL,
    last_update_date TIMESTAMP,
    name VARCHAR(255),
    size_in_bytes BIGINT,
    file_extension VARCHAR(100),
    CONSTRAINT PK_images PRIMARY KEY (id)
);