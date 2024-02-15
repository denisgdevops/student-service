CREATE TABLE IF NOT EXISTS Tutorials (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  published BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO Tutorials (title, description, published)
VALUES
  ('Spring Boot H2 Example', 'Spring Boot H2 JPA extensive examples', false),
  ('Java Coding Cool', 'Java Spring Boot Java programming', false);