-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Maj 2019, 18:55
-- Wersja serwera: 10.1.30-MariaDB
-- Wersja PHP: 7.2.1

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
  `tresc` text COLLATE utf8_polish_ci NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `artykuly`
--

INSERT INTO `artykuly` (`artykul_id`, `tytul`, `tresc`, `data`) VALUES
(1, 'BEZPLATNE BADANIE SLUCHU', 'tresc artukulu', '2019-04-15');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `choroby`
--

CREATE TABLE `choroby` (
  `choroba_id` int(3) NOT NULL,
  `nazwa` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `choroby`
--

INSERT INTO `choroby` (`choroba_id`, `nazwa`, `opis`) VALUES
(1, 'Zapalenie pluc', 'Zapalenie pluc njkfnjdsnj fndjksfnd nfdjs nfdsfn jdsnfkdns jkdsnj snjfkndjsfkdsnfk');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE `konta` (
  `konto_id` int(4) NOT NULL,
  `login` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `rodzaj_konta` varchar(13) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`konto_id`, `login`, `haslo`, `rodzaj_konta`) VALUES
(1, 'jkowalski32', 'kowal123', 'pacjenci'),
(5, 'anowak', '1234', 'lekarze'),
(6, 'kkrol', '1234', 'recepcjonisci'),
(7, 'test', 'test', 'pacjent'),
(8, 'test4', 'test', 'pacjent'),
(9, 'test5', 'test', 'pacjent'),
(10, 'lekarztest', 'test', 'lekarz'),
(11, 'pacjent', 'test', 'pacjent'),
(12, 'recepcjonista', 'test', 'recepcjonista'),
(13, 'testczypacjent', 'test', 'pacjent');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarze`
--

CREATE TABLE `lekarze` (
  `lekarz_id` int(4) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `nr_tel` int(11) NOT NULL,
  `PESEL` int(11) NOT NULL,
  `miejscowosc` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `ulica` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `nr_domu` int(3) DEFAULT NULL,
  `nr_lokalu` int(3) DEFAULT NULL,
  `kod_pocztowy` varchar(6) COLLATE utf8_polish_ci DEFAULT NULL,
  `poczta` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `konto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `leki`
--

CREATE TABLE `leki` (
  `lek_id` int(4) NOT NULL,
  `nazwa` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL,
  `dawkowanie` varchar(100) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE `pacjenci` (
  `pacjent_id` int(4) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `nr_tel` int(11) NOT NULL,
  `PESEL` bigint(11) NOT NULL,
  `miejscowosc` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `ulica` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `nr_domu` int(3) NOT NULL,
  `nr_lokalu` int(3) NOT NULL,
  `kod_pocztowy` varchar(6) COLLATE utf8_polish_ci NOT NULL,
  `poczta` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `konto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pacjenci`
--

INSERT INTO `pacjenci` (`pacjent_id`, `imie`, `nazwisko`, `email`, `nr_tel`, `PESEL`, `miejscowosc`, `ulica`, `nr_domu`, `nr_lokalu`, `kod_pocztowy`, `poczta`, `konto_id`) VALUES
(1, 'Jan', 'Kowalski', 'jkowalski32@gmail.com', 166216905, 87031787987, 'Rzeszow', 'Tadeusza Rejtana', 16, 5, '37-119', 'Rzeszow', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `recepcjonisci`
--

CREATE TABLE `recepcjonisci` (
  `recepcjonista_id` int(4) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `nr_tel` int(11) NOT NULL,
  `PESEL` int(11) NOT NULL,
  `miejscowosc` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `ulica` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `nr_domu` int(3) DEFAULT NULL,
  `nr_lokalu` int(3) DEFAULT NULL,
  `kod_pocztowy` varchar(6) COLLATE utf8_polish_ci DEFAULT NULL,
  `poczta` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `konto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `recepty`
--

CREATE TABLE `recepty` (
  `recepta_id` int(11) NOT NULL,
  `data_wystawienia` date NOT NULL,
  `lek_id` int(11) NOT NULL,
  `uwagi` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wizyty`
--

CREATE TABLE `wizyty` (
  `wizyta_id` int(5) NOT NULL,
  `recepcjonista_id` int(3) NOT NULL,
  `lekarz_id` int(3) NOT NULL,
  `pacjent_id` int(4) NOT NULL,
  `recepta_id` int(5) NOT NULL,
  `choroba_id` int(4) DEFAULT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `artykuly`
--
ALTER TABLE `artykuly`
  ADD PRIMARY KEY (`artykul_id`);

--
-- Indexes for table `choroby`
--
ALTER TABLE `choroby`
  ADD PRIMARY KEY (`choroba_id`);

--
-- Indexes for table `konta`
--
ALTER TABLE `konta`
  ADD PRIMARY KEY (`konto_id`);

--
-- Indexes for table `lekarze`
--
ALTER TABLE `lekarze`
  ADD PRIMARY KEY (`lekarz_id`),
  ADD KEY `konto_id` (`konto_id`);

--
-- Indexes for table `leki`
--
ALTER TABLE `leki`
  ADD PRIMARY KEY (`lek_id`);

--
-- Indexes for table `pacjenci`
--
ALTER TABLE `pacjenci`
  ADD PRIMARY KEY (`pacjent_id`),
  ADD KEY `konto_id` (`konto_id`);

--
-- Indexes for table `recepcjonisci`
--
ALTER TABLE `recepcjonisci`
  ADD PRIMARY KEY (`recepcjonista_id`),
  ADD KEY `konto_id` (`konto_id`);

--
-- Indexes for table `recepty`
--
ALTER TABLE `recepty`
  ADD PRIMARY KEY (`recepta_id`),
  ADD KEY `id_leku` (`lek_id`);

--
-- Indexes for table `wizyty`
--
ALTER TABLE `wizyty`
  ADD PRIMARY KEY (`wizyta_id`),
  ADD KEY `pacjent_id` (`pacjent_id`),
  ADD KEY `recepcjonista_id` (`recepcjonista_id`),
  ADD KEY `lekarz_id` (`lekarz_id`),
  ADD KEY `recepta_id` (`recepta_id`),
  ADD KEY `choroba_id` (`choroba_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `artykuly`
--
ALTER TABLE `artykuly`
  MODIFY `artykul_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `choroby`
--
ALTER TABLE `choroby`
  MODIFY `choroba_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `konta`
--
ALTER TABLE `konta`
  MODIFY `konto_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  MODIFY `lekarz_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `leki`
--
ALTER TABLE `leki`
  MODIFY `lek_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  MODIFY `pacjent_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `recepcjonisci`
--
ALTER TABLE `recepcjonisci`
  MODIFY `recepcjonista_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `recepty`
--
ALTER TABLE `recepty`
  MODIFY `recepta_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  MODIFY `wizyta_id` int(5) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  ADD CONSTRAINT `lekarze_ibfk_1` FOREIGN KEY (`lekarz_id`) REFERENCES `wizyty` (`lekarz_id`),
  ADD CONSTRAINT `lekarze_ibfk_2` FOREIGN KEY (`konto_id`) REFERENCES `konta` (`konto_id`);

--
-- Ograniczenia dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  ADD CONSTRAINT `pacjenci_ibfk_1` FOREIGN KEY (`konto_id`) REFERENCES `konta` (`konto_id`);

--
-- Ograniczenia dla tabeli `recepcjonisci`
--
ALTER TABLE `recepcjonisci`
  ADD CONSTRAINT `recepcjonisci_ibfk_1` FOREIGN KEY (`konto_id`) REFERENCES `konta` (`konto_id`);

--
-- Ograniczenia dla tabeli `recepty`
--
ALTER TABLE `recepty`
  ADD CONSTRAINT `recepty_ibfk_1` FOREIGN KEY (`lek_id`) REFERENCES `leki` (`lek_id`);

--
-- Ograniczenia dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  ADD CONSTRAINT `wizyty_ibfk_1` FOREIGN KEY (`pacjent_id`) REFERENCES `pacjenci` (`pacjent_id`),
  ADD CONSTRAINT `wizyty_ibfk_2` FOREIGN KEY (`recepcjonista_id`) REFERENCES `recepcjonisci` (`recepcjonista_id`),
  ADD CONSTRAINT `wizyty_ibfk_3` FOREIGN KEY (`choroba_id`) REFERENCES `choroby` (`choroba_id`),
  ADD CONSTRAINT `wizyty_ibfk_4` FOREIGN KEY (`recepta_id`) REFERENCES `recepty` (`recepta_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
