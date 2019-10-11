CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `admin` bool NOT NULL DEFAULT false,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE `raffles` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `created_by` int,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp,
  `active` bool NOT NULL DEFAULT true,
  `starts_at` timestamp,
  `ends_at` timestamp
);

CREATE TABLE `prizes` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image_url` varchar(255),
  `raffle_id` int,
  `won_by` int,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE `donations` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `raffle_id` int,
  `amount` float NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE `entries` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `prize_id` int,
  `tickets` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE `tiers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `raffle_id` int,
  `amount` float NOT NULL,
  `tickets` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp,
  `updated_at` datetime NOT NULL DEFAULT current_timestamp
);

ALTER TABLE `raffles` ADD FOREIGN KEY (`created_by`) REFERENCES `users` (`id`);

ALTER TABLE `prizes` ADD FOREIGN KEY (`raffle_id`) REFERENCES `raffles` (`id`);

ALTER TABLE `prizes` ADD FOREIGN KEY (`won_by`) REFERENCES `users` (`id`);

ALTER TABLE `donations` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `donations` ADD FOREIGN KEY (`raffle_id`) REFERENCES `raffles` (`id`);

ALTER TABLE `entries` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `entries` ADD FOREIGN KEY (`prize_id`) REFERENCES `prizes` (`id`);

ALTER TABLE `tiers` ADD FOREIGN KEY (`raffle_id`) REFERENCES `raffles` (`id`);
