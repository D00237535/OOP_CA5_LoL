CREATE TABLE `champ`
(
    `id`          int NOT NULL Auto_increment,
    `name`        varchar(255) NOT NULL,
    `mainRole`    varchar(255) NOT NULL,
    `region`      varchar(255) NOT NULL,
    `winRate`    varchar(255) NOT NULL,
    `pickRate`    varchar(255) NOT NULL,
    `banRate`     varchar(255) NOT NULL,
    `roleRank`    varchar(255) NOT NULL,
    `overAllRank` varchar(255) NOT NULL,
    `tier`        varchar(255) NOT NULL,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `champs`
--

INSERT INTO `champ` (`name`, `mainRole`, `region`, `winRate`, `pickRate`, `banRate`, `roleRank`, `overAllRank`,`tier`)
VALUES ( 'Warwick', 'Jungler', 'Zuan', '50.45', '2.96', '1.47', '5', '30', 'A'),
       ( 'Skarner', 'Jungler', 'Shurima', '48.54', '11.2', '11.7', '34', '168', 'D'),
       ( 'Garen', 'Toplane', 'Demacia', '59.95', '1.68', '3.66', '11', '40', 'S'),
       ( 'Karma', 'Toplane', 'Ionia', '52.98', '2.26', '1.08', '42', '152', 'B'),
       ( 'Neeko', 'Midlane', 'Ixtal', '52.56', '3.83', '0.28', '37', '156', 'A'),
       ( 'Akshan', 'Midlane', 'Shurima', '51.17', '3.88', '16.3', '5', '17', 'S'),
       ( 'Vayne', 'Botlane', 'Demacia', '52.09', '13.59', '18.0', '5', '54', 'S'),
       ( 'Draven', 'Botlane', 'Noxus', '49.71', '5.17', '6.87', '18', '145', 'B'),
       ( 'Sona', 'Support', 'Demacia', '52.74', '3.52', '0.33', '4', '24', 'A'),
       ( 'Traic', 'Support', 'Targon', '50.71', '0.95', '0.11', '19', '132', 'B');