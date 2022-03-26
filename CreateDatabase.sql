CREATE TABLE `champ`
(
    `id`          varchar(255) NOT NULL,
    `name`        varchar(255) NOT NULL,
    `mainRole`    varchar(255) NOT NULL,
    `region`      varchar(255) NOT NULL,
    `winRate`    varchar(255) NOT NULL,
    `pickRate`    varchar(255) NOT NULL,
    `banRate`     varchar(255) NOT NULL,
    `roleRank`    varchar(255) NOT NULL,
    `overAllRank` varchar(255) NOT NULL,
    `tier`        varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `champs`
--

INSERT INTO `champ` (`id`, `name`, `mainRole`, `region`, `winRate`, `pickRate`, `banRate`, `roleRank`, `overAllRank`,
                     `tier`)
VALUES ('1', 'Warwick', 'Jungler', 'Zuan', '50.45', '2.96', '1.47', '5', '30', 'A'),
       ('2', 'Skarner', 'Jungler', 'Shurima', '48.54', '11.2', '11.7', '34', '168', 'D'),
       ('3', 'Garen', 'Toplane', 'Demacia', '59.95', '1.68', '3.66', '11', '40', 'S'),
       ('4', 'Karma', 'Toplane', 'Ionia', '52.98', '2.26', '1.08', '42', '152', 'B'),
       ('5', 'Neeko', 'Midlane', 'Ixtal', '52.56', '3.83', '0.28', '37', '156', 'A'),
       ('6', 'Akshan', 'Midlane', 'Shurima', '51.17', '3.88', '16.3', '5', '17', 'S'),
       ('7', 'Vayne', 'Botlane', 'Demacia', '52.09', '13.59', '18.0', '5', '54', 'S'),
       ('8', 'Draven', 'Botlane', 'Noxus', '49.71', '5.17', '6.87', '18', '145', 'B'),
       ('9', 'Sona', 'Support', 'Demacia', '52.74', '3.52', '0.33', '4', '24', 'A'),
       ('10', 'Traic', 'Support', 'Targon', '50.71', '0.95', '0.11', '19', '132', 'B');