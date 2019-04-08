-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Kwi 2019, 17:45
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.3

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
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE `konta` (
  `ID_Konta` int(11) NOT NULL,
  `Login` varchar(255) NOT NULL,
  `Hasło` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`ID_Konta`, `Login`, `Hasło`) VALUES
(78942, 'jkowalski32', '1234567');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarze`
--

CREATE TABLE `lekarze` (
  `ID_Lekarz` int(11) NOT NULL,
  `Imię` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `lekarze`
--

INSERT INTO `lekarze` (`ID_Lekarz`, `Imię`, `Nazwisko`, `Pesel`) VALUES
(565215, 'Jan', 'Kowalski', '95234879576');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE `pacjenci` (
  `ID_Pacjent` int(11) NOT NULL,
  `Imię` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL,
  `Adres zamieszkania` varchar(255) NOT NULL,
  `ID_Konta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pacjenci`
--

INSERT INTO `pacjenci` (`ID_Pacjent`, `Imię`, `Nazwisko`, `Pesel`, `Adres zamieszkania`, `ID_Konta`) VALUES
(12322, 'Adam', 'Małysz', '95234879561', 'ul. Konopnickiej 2 Rzeszów', 88889);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `recepty`
--

CREATE TABLE `recepty` (
  `ID_Recepty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `recepty`
--

INSERT INTO `recepty` (`ID_Recepty`) VALUES
(451236);

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
('0000-00-00 00:00:00', '00:00:00', 547895, 4568789, 541232, 111111),
('2019-04-01 12:00:00', '00:20:00', 234562, 132445, 231232, 321432);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `konta`
--
ALTER TABLE `konta`
  ADD PRIMARY KEY (`ID_Konta`);

--
-- Indeksy dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  ADD PRIMARY KEY (`ID_Lekarz`);

--
-- Indeksy dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  ADD PRIMARY KEY (`ID_Pacjent`),
  ADD UNIQUE KEY `ID_Konta` (`ID_Konta`);

--
-- Indeksy dla tabeli `recepty`
--
ALTER TABLE `recepty`
  ADD PRIMARY KEY (`ID_Recepty`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
