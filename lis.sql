-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2023 at 06:11 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lis`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getsamples` (IN `id` VARCHAR(10))   SELECT Pid,Date,TechID,B1,B2,B3,B4,U1,U2,U3,S1,S2,S3 FROM samples WHERE Pid=id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `Doctor_ID` varchar(10) NOT NULL,
  `DName` varchar(20) NOT NULL,
  `Phone` bigint(20) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`Doctor_ID`, `DName`, `Phone`, `Email`) VALUES
('D11', 'yallappa', 7456238952, 'yallappa@gmail.com'),
('D12', 'meghana', 8745965455, 'meghana@gmail.com'),
('D13', 'shivam', 9897484584, 'shivam@gmail.com'),
('D14', 'suraksha', 7897997597, 'suraksh456@gmail.com'),
('D16', 'manjunath', 9842325564, 'manjunath@gmail.com'),
('D17', 'santhosh', 9841576185, 'santhosh@gmail.com'),
('D18', 'akshata', 8794668454, 'akshata@gmail.com'),
('D19', 'gagan', 7845195656, 'gagan@gmail.com'),
('D23', 'abhishek', 9746125545, 'abhishek@gmail.com'),
('D45', 'swati', 8970389641, 'swati@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `Pid` varchar(10) NOT NULL,
  `PName` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Mobile` bigint(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sample_collected` varchar(10) DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`Pid`, `PName`, `DOB`, `Mobile`, `Email`, `Gender`, `sample_collected`) VALUES
('P100', 'harsha', '2023-01-29', 6585695569, 'harsha@gmail.com', 'M', 'YES'),
('P101', 'suresh', '2022-01-25', 8564864824, 'suresh@gmail.com', 'M', 'YES'),
('P103', 'soundarya', '2022-02-23', 6945875645, 'soundarya123@gmail.com', 'F', 'YES'),
('P104', 'reshma', '2022-01-19', 8969765685, 'reshma123@gmail.com', 'F', 'YES'),
('P105', 'amaresh', '2022-06-01', 8974562459, 'amaresh567@gmail.com', 'M', 'YES'),
('P106', 'sukumar', '2023-01-12', 9462956275, 'sukumar@gmail.com', 'M', 'NO'),
('P108', 'kishan', '2002-01-25', 8964525625, 'kishan@gmail.com', 'M', 'NO'),
('P110', 'mahesh', '2023-01-12', 8947556555, 'mahesh@gmai.com', 'M', 'YES'),
('P113', 'kavya', '2002-12-13', 9459461522, 'kavya@gmail.com', 'F', 'NO'),
('P120', 'shruti', '2001-02-12', 9353165199, 'shruti@gmail.com', 'F', 'NO'),
('P124', 'ram', '2017-02-12', 8106440121, 'ram@gmail.com', 'M', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `samples`
--

CREATE TABLE `samples` (
  `Sid` varchar(10) NOT NULL,
  `Pid` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `TechID` varchar(10) NOT NULL,
  `B1` varchar(5) DEFAULT NULL,
  `B2` varchar(10) DEFAULT NULL,
  `B3` varchar(12) DEFAULT NULL,
  `B4` varchar(12) DEFAULT NULL,
  `U1` varchar(20) DEFAULT NULL,
  `U2` varchar(25) DEFAULT NULL,
  `U3` varchar(13) DEFAULT NULL,
  `S1` varchar(20) DEFAULT NULL,
  `S2` varchar(25) DEFAULT NULL,
  `S3` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `samples`
--

INSERT INTO `samples` (`Sid`, `Pid`, `Date`, `TechID`, `B1`, `B2`, `B3`, `B4`, `U1`, `U2`, `U3`, `S1`, `S2`, `S3`) VALUES
('S10003', 'P101', '2023-01-01', 'T1005', '', '', '', '', '', 'Culture sensitivity ', '', '', '', ''),
('S10004', 'P106', '2023-01-20', 'T1008', '', '', '', '', 'Wet mount ', '', '', '', '', ''),
('S10005', 'P106', '2023-01-20', 'T1003', '', '', '', 'Blood urea ', '', '', '', '', '', ''),
('S10007', 'P109', '2023-01-12', 'T1007', '', '', '', '', '', '', '', 'For occult blood ', '', ''),
('S10008', 'P105', '2023-01-23', 'T1008', '', '', '', '', '', 'Culture sensitivity ', '', '', '', ''),
('S10009', 'P103', '2023-01-15', 'T1007', '', '', '', '', '', '', '', '', '', 'Stool culture and sensitivity '),
('S10033', 'P104', '2023-10-12', 'T1005', '', '', 'Hemoglobin ', '', '', '', '', '', '', '');

--
-- Triggers `samples`
--
DELIMITER $$
CREATE TRIGGER `SC` AFTER INSERT ON `samples` FOR EACH ROW UPDATE patients P,samples S SET P.SAMPLE_COLLECTED='YES' where P.Pid in (SELECT S.Pid FROM samples S )
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `technicians`
--

CREATE TABLE `technicians` (
  `TechID` varchar(10) NOT NULL,
  `TName` varchar(20) NOT NULL,
  `Phone` bigint(20) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `technicians`
--

INSERT INTO `technicians` (`TechID`, `TName`, `Phone`, `Email`) VALUES
('T1001', 'deelip', 7419856278, 'deelip@gmail.com'),
('T1003', 'mahendra', 9554678565, 'mahendra@gmail.com'),
('T1004', 'suraj', 9745648556, 'suraj@gmail.com'),
('T1005', 'sanjana', 9467816586, 'sanjana@gmail.com'),
('T1006', 'pooja', 4868662655, 'pooja@gmail.com'),
('T1007', 'bharath', 4566864889, 'bharath@gmail.com'),
('T1008', 'parimala', 8795462643, 'parimala@gmail.com'),
('T1009', 'shivalila', 7414512554, 'shivalila@gmail.com'),
('T1012', 'jyoti', 9743615452, 'jyoti@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UName` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UName`, `Password`) VALUES
('admin', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`Doctor_ID`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`Pid`);

--
-- Indexes for table `samples`
--
ALTER TABLE `samples`
  ADD PRIMARY KEY (`Sid`),
  ADD KEY `samples_ibfk_2` (`TechID`);
ALTER TABLE `samples` ADD FULLTEXT KEY `Pid` (`Pid`);

--
-- Indexes for table `technicians`
--
ALTER TABLE `technicians`
  ADD PRIMARY KEY (`TechID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `samples`
--
ALTER TABLE `samples`
  ADD CONSTRAINT `samples_ibfk_2` FOREIGN KEY (`TechID`) REFERENCES `technicians` (`TechID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
