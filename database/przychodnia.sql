-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Maj 2019, 12:10
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `przychodnia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wizyty`
--

CREATE TABLE `wizyty` (
  `Data_wizyty` datetime NOT NULL,
  `Czas_wizyty` time NOT NULL,
  `ID_Wizyta` int(11) NOT NULL,
  `ID_Lekarz` int(11) NOT NULL,
  `ID_Pacjent` int(11) NOT NULL,
  `ID_Recepty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wizyty`
--

INSERT INTO `wizyty` (`Data_wizyty`, `Czas_wizyty`, `ID_Wizyta`, `ID_Lekarz`, `ID_Pacjent`, `ID_Recepty`) VALUES
('2019-04-01 12:00:00', '00:20:00', 234562, 132445, 231232, 321432),
('0000-00-00 00:00:00', '00:00:00', 547895, 4568789, 541232, 111111);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  ADD PRIMARY KEY (`ID_Wizyta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  MODIFY `ID_Wizyta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=547896;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
