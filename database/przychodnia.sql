-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Maj 2019, 13:10
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
-- Struktura tabeli dla tabeli `artykuly`
--

CREATE TABLE `artykuly` (
  `artykul_id` int(11) NOT NULL,
  `tytul` varchar(200) COLLATE utf8_polish_ci NOT NULL,
  `tresc` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `choroby`
--

CREATE TABLE `choroby` (
  `choroba_id` int(3) NOT NULL,
  `nazwa` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE `konta` (
  `id` int(4) NOT NULL,
  `imie` varchar(20) NOT NULL,
  `nazwisko` varchar(30) NOT NULL,
  `login` varchar(50) DEFAULT NULL,
  `haslo` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nr_tel` varchar(11) NOT NULL,
  `PESEL` varchar(11) NOT NULL,
  `miejscowosc` varchar(30) DEFAULT NULL,
  `ulica` varchar(30) DEFAULT NULL,
  `nr_domu` varchar(3) DEFAULT NULL,
  `nr_lokalu` varchar(3) DEFAULT NULL,
  `kod_pocztowy` varchar(6) DEFAULT NULL,
  `poczta` varchar(30) DEFAULT NULL,
  `typ_konta` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`id`, `imie`, `nazwisko`, `login`, `haslo`, `email`, `nr_tel`, `PESEL`, `miejscowosc`, `ulica`, `nr_domu`, `nr_lokalu`, `kod_pocztowy`, `poczta`, `typ_konta`) VALUES
(1, 'Konrad', 'Rejman', 'Konrad', 'haslo', 'rreejjmmaann@gmail.com', '45654564', '4584545445', 'Rzeszow', 'sdf', '10', 'sdf', '23323', 'sdf', 'pacjenci');

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
('2019-04-01 12:00:00', '00:20:00', 234562, 132445, 231232, 321432),
('0000-00-00 00:00:00', '00:00:00', 547895, 4568789, 541232, 111111);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `artykuly`
--
ALTER TABLE `artykuly`
  ADD PRIMARY KEY (`artykul_id`);

--
-- Indeksy dla tabeli `choroby`
--
ALTER TABLE `choroby`
  ADD PRIMARY KEY (`choroba_id`);

--
-- Indeksy dla tabeli `konta`
--
ALTER TABLE `konta`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `recepty`
--
ALTER TABLE `recepty`
  ADD PRIMARY KEY (`ID_Recepty`);

--
-- Indeksy dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  ADD PRIMARY KEY (`ID_Wizyta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `artykuly`
--
ALTER TABLE `artykuly`
  MODIFY `artykul_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `choroby`
--
ALTER TABLE `choroby`
  MODIFY `choroba_id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `konta`
--
ALTER TABLE `konta`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  MODIFY `ID_Wizyta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=547896;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
