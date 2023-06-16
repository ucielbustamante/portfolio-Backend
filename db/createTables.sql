
-- portfolio.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- portfolio.rol definition

CREATE TABLE `rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;


-- portfolio.`user` definition

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- portfolio.user_rol definition

CREATE TABLE `user_rol` (
  `user_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`rol_id`),
  KEY `FKpfraq7jod5w5xd3sxm3m6y1o` (`rol_id`),
  CONSTRAINT `FKkijwolbkui74em8ip1i6vniu4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKpfraq7jod5w5xd3sxm3m6y1o` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- portfolio.education definition

CREATE TABLE `education` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkvbl6xk332o16kxhc8hp0pnhh` (`person_id`),
  CONSTRAINT `FKkvbl6xk332o16kxhc8hp0pnhh` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- portfolio.project definition

CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKppmmj8b0oeesglh1lkcgawdu` (`person_id`),
  CONSTRAINT `FKppmmj8b0oeesglh1lkcgawdu` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- portfolio.skill definition

CREATE TABLE `skill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnu4vq754g7a54h2rmy2bt3o36` (`person_id`),
  CONSTRAINT `FKnu4vq754g7a54h2rmy2bt3o36` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- portfolio.social_media definition

CREATE TABLE `social_media` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3f7t0vy5j5nx7wcxhw9qs4xpp` (`person_id`),
  CONSTRAINT `FK3f7t0vy5j5nx7wcxhw9qs4xpp` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

INSERT INTO portfolio.rol (rol_name) VALUES
	 ('ROLE_ADMIN'),
	 ('ROLE_USER');
	 
COMMIT;