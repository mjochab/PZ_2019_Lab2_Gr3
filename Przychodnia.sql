-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Kwi 2019, 14:06
-- Wersja serwera: 5.6.21
-- Wersja PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `przychodnia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE IF NOT EXISTS `konta` (
  `ID_Konta` int(11) NOT NULL,
  `Login` varchar(255) NOT NULL,
  `Haslo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`ID_Konta`, `Login`, `Haslo`) VALUES
(78942, 'jkowalski32', '1234567');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarze`
--

CREATE TABLE IF NOT EXISTS `lekarze` (
  `ID_Lekarz` int(11) NOT NULL,
  `Imie` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `lekarze`
--

INSERT INTO `lekarze` (`ID_Lekarz`, `Imie`, `Nazwisko`, `Pesel`) VALUES
(565215, 'Jan', 'Kowalski', '95234879576');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE IF NOT EXISTS `pacjenci` (
  `ID_Pacjent` int(11) NOT NULL,
  `Imie` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL,
  `Adres zamieszkania` varchar(255) NOT NULL,
  `ID_Konta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pacjenci`
--

INSERT INTO `pacjenci` (`ID_Pacjent`, `Imie`, `Nazwisko`, `Pesel`, `Adres zamieszkania`, `ID_Konta`) VALUES
(12322, 'Adam', 'Małysz', '95234879561', 'ul. Konopnickiej 2 Rzeszów', 88889);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `recepty`
--

CREATE TABLE IF NOT EXISTS `recepty` (
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

CREATE TABLE IF NOT EXISTS `wizyty` (
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
-- Indexes for table `konta`
--
ALTER TABLE `konta`
 ADD PRIMARY KEY (`ID_Konta`);

--
-- Indexes for table `lekarze`
--
ALTER TABLE `lekarze`
 ADD PRIMARY KEY (`ID_Lekarz`);

--
-- Indexes for table `pacjenci`
--
ALTER TABLE `pacjenci`
 ADD PRIMARY KEY (`ID_Pacjent`), ADD UNIQUE KEY `ID_Konta` (`ID_Konta`);

--
-- Indexes for table `recepty`
--
ALTER TABLE `recepty`
 ADD PRIMARY KEY (`ID_Recepty`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

