-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 15, 2019 at 10:40 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `form`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `a_id` int(11) NOT NULL,
  `a_description` varchar(255) DEFAULT NULL,
  `a_name` varchar(255) DEFAULT NULL,
  `question_q_id` int(11) DEFAULT NULL,
  `sub_question_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`a_id`, `a_description`, `a_name`, `question_q_id`, `sub_question_id`) VALUES
(1, 'Satisfied', 'A1', 1, 0),
(2, 'Somewhat satisfied', 'A2', 1, 0),
(4, 'Neither satisfied nor dissatisfied', 'A3', 1, 0),
(5, 'Somewhat dissatisfied', 'A4', 1, 0),
(6, 'Dissatisfied', 'A5', 1, 0),
(87, 'Agree', NULL, 84, 2),
(88, 'Somewhat agree', NULL, 84, 3),
(89, 'Somewhat agree', NULL, 84, 2),
(90, 'Neither agree nor disagree', NULL, 84, 2),
(91, 'Somewhat disagree', NULL, 84, 2),
(92, 'Disagree', NULL, 84, 2),
(93, 'Nepal', NULL, 87, 0),
(94, 'India', NULL, 87, 0),
(95, 'China', NULL, 87, 0),
(102, 'Excellent', NULL, 91, 4),
(103, 'Good', NULL, 91, 4),
(104, 'Fair', NULL, 91, 4),
(105, 'Poor', NULL, 91, 4),
(106, 'Very poor', NULL, 91, 4),
(107, 'N/A', NULL, 91, 4),
(108, 'Excellent', NULL, 91, 5),
(109, 'Good', NULL, 91, 5),
(110, 'Fair', NULL, 91, 5),
(111, 'Poor', NULL, 91, 5),
(112, 'Very poor', NULL, 91, 5),
(113, 'N/A', NULL, 91, 5),
(114, 'Excellent', NULL, 91, 6),
(115, 'Good', NULL, 91, 6),
(116, 'Fair', NULL, 91, 6),
(117, 'Poor', NULL, 91, 6),
(118, 'Very poor', NULL, 91, 6),
(119, 'N/A', NULL, 91, 6),
(120, 'Excellent', NULL, 91, 7),
(121, 'Good', NULL, 91, 7),
(122, 'Fair', NULL, 91, 7),
(123, 'Poor', NULL, 91, 7),
(124, 'Very poor', NULL, 91, 7),
(125, 'N/A', NULL, 91, 7),
(126, 'Excellent', NULL, 91, 8),
(127, 'Good', NULL, 91, 8),
(128, 'Fair', NULL, 91, 8),
(129, 'Poor', NULL, 91, 8),
(130, 'Very poor', NULL, 91, 8),
(131, 'N/A', NULL, 91, 8),
(132, 'Excellent', NULL, 91, 9),
(133, 'Good', NULL, 91, 9),
(134, 'Fair', NULL, 91, 9),
(135, 'Poor', NULL, 91, 9),
(136, 'Very poor', NULL, 91, 9),
(137, 'N/A', NULL, 91, 9),
(138, 'Excellent', NULL, 91, 10),
(139, 'Good', NULL, 91, 10),
(140, 'Fair', NULL, 91, 10),
(141, 'Poor', NULL, 91, 10),
(142, 'Very poor', NULL, 91, 10),
(143, 'N/A', NULL, 91, 10),
(144, 'Excellent', NULL, 91, 11),
(145, 'Good', NULL, 91, 11),
(146, 'Fair', NULL, 91, 11),
(147, 'Poor', NULL, 91, 11),
(148, 'Very poor', NULL, 91, 11),
(149, 'N/A', NULL, 91, 11),
(150, 'Excellent', NULL, 91, 12),
(151, 'Good', NULL, 91, 12),
(152, 'Fair', NULL, 91, 12),
(153, 'Poor', NULL, 91, 12),
(154, 'Very poor', NULL, 91, 12),
(155, 'N/A', NULL, 91, 12),
(157, 'good', NULL, 92, 14),
(158, 'bad', NULL, 92, 14),
(159, 'well', NULL, 92, 14),
(160, 'good', NULL, 92, 15),
(161, 'bad', NULL, 92, 15),
(162, 'well', NULL, 92, 15),
(163, 'bhut bhut', NULL, 93, 0),
(164, 'pyaa', NULL, 93, 0);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `comment`) VALUES
(19, 'good'),
(20, 'Yo ..'),
(21, 'Yes I do Agree!!'),
(22, 'CardiB  '),
(23, 'PutaMadre!!'),
(24, ' I am Satisfed '),
(25, 'Yes i do baaa.........................\r\n...............\r\n...................///>>>>>>>>>>>>>>>...............');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(85),
(85),
(85),
(85);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `q_id` int(11) NOT NULL,
  `q_description` text DEFAULT NULL,
  `q_name` varchar(255) DEFAULT NULL,
  `q_remarks` varchar(255) DEFAULT NULL,
  `a_type` varchar(255) DEFAULT 'radio'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`q_id`, `q_description`, `q_name`, `q_remarks`, `a_type`) VALUES
(1, 'Overall, how satisfied are you with your membership in our Rotary club?', 'Q1', NULL, 'radio'),
(84, 'Considering our club’s culture, members, and meetings, indicate your agreement with the\r\nfollowing statements.', NULL, NULL, 'multiple'),
(87, 'Where do Kalapani belongs?', NULL, NULL, 'radio'),
(91, 'How would you rate the following aspects of our weekly meetings?', NULL, NULL, 'multiple'),
(92, 'How do you feel about the survey??', NULL, NULL, 'multiple'),
(93, 'How does an ignition motor starts??', NULL, NULL, 'radio');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `sub_question`
--

CREATE TABLE `sub_question` (
  `qId` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `q_description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_question`
--

INSERT INTO `sub_question` (`qId`, `id`, `q_description`) VALUES
(84, 2, 'Club meetings are a good use of my time'),
(84, 3, 'My club does a good job involving new members'),
(91, 4, 'Rotary International updates'),
(91, 5, 'Length'),
(91, 6, 'Time for socializing'),
(91, 7, 'Professional connections and networking'),
(91, 8, 'Variety of program topics'),
(91, 9, 'Location'),
(91, 10, 'Meeting time and day'),
(91, 11, 'Meals or refreshments'),
(91, 12, 'Speakers and programs'),
(92, 14, 'On the begining'),
(92, 15, 'in the end');

-- --------------------------------------------------------

--
-- Table structure for table `surveys`
--

CREATE TABLE `surveys` (
  `s_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `surveys`
--

INSERT INTO `surveys` (`s_id`, `u_id`) VALUES
(46, 46);

-- --------------------------------------------------------

--
-- Table structure for table `survey_answer`
--

CREATE TABLE `survey_answer` (
  `id` int(11) NOT NULL,
  `a_id` int(11) NOT NULL,
  `q_id` int(11) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `survey_s_id` int(11) DEFAULT NULL,
  `sub_question_id` int(11) NOT NULL DEFAULT 0,
  `comment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_answer`
--

INSERT INTO `survey_answer` (`id`, `a_id`, `q_id`, `remarks`, `survey_s_id`, `sub_question_id`, `comment_id`) VALUES
(286, 1, 1, NULL, 46, 0, NULL),
(287, 87, 84, NULL, 46, 2, NULL),
(288, 87, 84, NULL, 46, 3, NULL),
(289, 93, 87, NULL, 46, 3, NULL),
(290, 102, 91, NULL, 46, 4, NULL),
(291, 102, 91, NULL, 46, 5, NULL),
(292, 102, 91, NULL, 46, 6, NULL),
(293, 102, 91, NULL, 46, 7, NULL),
(294, 102, 91, NULL, 46, 8, NULL),
(295, 102, 91, NULL, 46, 9, NULL),
(296, 102, 91, NULL, 46, 10, NULL),
(297, 102, 91, NULL, 46, 11, NULL),
(298, 102, 91, NULL, 46, 12, NULL),
(299, 157, 92, NULL, 46, 14, NULL),
(300, 157, 92, NULL, 46, 15, NULL),
(301, 163, 93, NULL, 46, 15, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstname`, `role_id`) VALUES
(46, 'user', 'user', 'userWithoneEye', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `answer_ibfk_1` (`question_q_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`q_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_question`
--
ALTER TABLE `sub_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sub_question_ibfk_1` (`qId`);

--
-- Indexes for table `surveys`
--
ALTER TABLE `surveys`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `survey_answer`
--
ALTER TABLE `survey_answer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgptswrbkpkm48y94mpwwye530` (`survey_s_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sub_question`
--
ALTER TABLE `sub_question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `survey_answer`
--
ALTER TABLE `survey_answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`question_q_id`) REFERENCES `question` (`q_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `sub_question`
--
ALTER TABLE `sub_question`
  ADD CONSTRAINT `sub_question_ibfk_1` FOREIGN KEY (`qId`) REFERENCES `question` (`q_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `survey_answer`
--
ALTER TABLE `survey_answer`
  ADD CONSTRAINT `FKgptswrbkpkm48y94mpwwye530` FOREIGN KEY (`survey_s_id`) REFERENCES `surveys` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
