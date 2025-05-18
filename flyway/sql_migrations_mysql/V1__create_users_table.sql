CREATE TABLE `user` (
    `user_id` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255),
    `email` VARCHAR(255),
    `phone_number` VARCHAR(20),
    `gender` VARCHAR(20),
    `age` INT,
    `date_of_birth` DATE,
    PRIMARY KEY (`user_id`),
    UNIQUE (`email`)
);
