-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Kwi 2019, 12:48
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
-- Struktura tabeli dla tabeli `info_wizyta`
--

CREATE TABLE `info_wizyta` (
  `ID_Info_Wizyta` int(11) NOT NULL,
  `Data_Wizyty` datetime NOT NULL,
  `Czas_Wizyty` time NOT NULL,
  `ID_Pacjent` int(11) NOT NULL,
  `ID_Lekarz` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `info_wizyta`
--

INSERT INTO `info_wizyta` (`ID_Info_Wizyta`, `Data_Wizyty`, `Czas_Wizyty`, `ID_Pacjent`, `ID_Lekarz`) VALUES
(45123, '2019-04-08 10:00:00', '00:30:00', 12322, 23548);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konto`
--

CREATE TABLE `konto` (
  `ID_Konta` int(11) NOT NULL,
  `Login` varchar(255) NOT NULL,
  `Hasło` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `konto`
--

INSERT INTO `konto` (`ID_Konta`, `Login`, `Hasło`) VALUES
(78942, 'jkowalski32', '1234567');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarz`
--

CREATE TABLE `lekarz` (
  `ID_Lekarz` int(11) NOT NULL,
  `Imię` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `lekarz`
--

INSERT INTO `lekarz` (`ID_Lekarz`, `Imię`, `Nazwisko`, `Pesel`) VALUES
(565215, 'Jan', 'Kowalski', '95234879576');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjent`
--

CREATE TABLE `pacjent` (
  `ID_Pacjent` int(11) NOT NULL,
  `Imię` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pesel` varchar(11) NOT NULL,
  `Adres zamieszkania` varchar(255) NOT NULL,
  `ID_Konta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pacjent`
--

INSERT INTO `pacjent` (`ID_Pacjent`, `Imię`, `Nazwisko`, `Pesel`, `Adres zamieszkania`, `ID_Konta`) VALUES
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
-- Struktura tabeli dla tabeli `wizyta`
--

CREATE TABLE `wizyta` (
  `ID_Wizyta` int(11) NOT NULL,
  `ID_Lekarz` int(11) NOT NULL,
  `ID_Pacjent` int(11) NOT NULL,
  `ID_Recepty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wizyta`
--

INSERT INTO `wizyta` (`ID_Wizyta`, `ID_Lekarz`, `ID_Pacjent`, `ID_Recepty`) VALUES
(547895, 4568789, 541232, 111111);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `info_wizyta`
--
ALTER TABLE `info_wizyta`
  ADD PRIMARY KEY (`ID_Info_Wizyta`);

--
-- Indeksy dla tabeli `konto`
--
ALTER TABLE `konto`
  ADD PRIMARY KEY (`ID_Konta`);

--
-- Indeksy dla tabeli `lekarz`
--
ALTER TABLE `lekarz`
  ADD PRIMARY KEY (`ID_Lekarz`);

--
-- Indeksy dla tabeli `pacjent`
--
ALTER TABLE `pacjent`
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
