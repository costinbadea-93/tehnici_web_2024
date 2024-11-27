CREATE TABLE `library`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `name`        varchar(45) DEFAULT NULL,
    `description` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `book`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `title`       varchar(45) DEFAULT NULL,
    `author`      varchar(45) DEFAULT NULL,
    `description` varchar(45) DEFAULT NULL,
    `libraryId`   int NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`),
    KEY           `libraryfk_idx` (`libraryId`),
    CONSTRAINT `libraryfk` FOREIGN KEY (`libraryId`) REFERENCES `library` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


