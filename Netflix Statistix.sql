USE [master]
GO
/****** Object:  Database [Netflix Statistix]    Script Date: 1/14/2020 10:37:35 PM ******/
CREATE DATABASE [Netflix Statistix]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Netflix Statistix', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Netflix Statistix.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Netflix Statistix_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\Netflix Statistix_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Netflix Statistix] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Netflix Statistix].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Netflix Statistix] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Netflix Statistix] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Netflix Statistix] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Netflix Statistix] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Netflix Statistix] SET ARITHABORT OFF 
GO
ALTER DATABASE [Netflix Statistix] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Netflix Statistix] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Netflix Statistix] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Netflix Statistix] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Netflix Statistix] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Netflix Statistix] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Netflix Statistix] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Netflix Statistix] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Netflix Statistix] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Netflix Statistix] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Netflix Statistix] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Netflix Statistix] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Netflix Statistix] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Netflix Statistix] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Netflix Statistix] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Netflix Statistix] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Netflix Statistix] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Netflix Statistix] SET RECOVERY FULL 
GO
ALTER DATABASE [Netflix Statistix] SET  MULTI_USER 
GO
ALTER DATABASE [Netflix Statistix] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Netflix Statistix] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Netflix Statistix] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Netflix Statistix] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Netflix Statistix] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Netflix Statistix', N'ON'
GO
ALTER DATABASE [Netflix Statistix] SET QUERY_STORE = OFF
GO
USE [Netflix Statistix]
GO
/****** Object:  Table [dbo].[account]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[email] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[city] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[episode]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[episode](
	[program_id] [int] NOT NULL,
	[episode_nr] [nvarchar](50) NOT NULL,
	[series_title] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Episode] PRIMARY KEY CLUSTERED 
(
	[program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movie]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie](
	[program_id] [int] NOT NULL,
	[genre] [nvarchar](50) NOT NULL,
	[language] [nvarchar](50) NOT NULL,
	[age_rating] [int] NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[profile]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[profile](
	[email] [nvarchar](50) NOT NULL,
	[profile_name] [nvarchar](50) NOT NULL,
	[age] [int] NOT NULL,
 CONSTRAINT [PK_Profile] PRIMARY KEY CLUSTERED 
(
	[email] ASC,
	[profile_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[program]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[program](
	[program_id] [int] NOT NULL,
	[program_name] [nvarchar](50) NOT NULL,
	[length] [time](7) NOT NULL,
 CONSTRAINT [PK_Program] PRIMARY KEY CLUSTERED 
(
	[program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[series]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[series](
	[series_title] [nvarchar](50) NOT NULL,
	[genre] [nvarchar](50) NOT NULL,
	[language] [nvarchar](50) NOT NULL,
	[age_rating] [nvarchar](50) NOT NULL,
	[recommendation] [nvarchar](50) NULL,
 CONSTRAINT [PK_Series] PRIMARY KEY CLUSTERED 
(
	[series_title] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[watched_program]    Script Date: 1/14/2020 10:37:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[watched_program](
	[email] [nvarchar](50) NOT NULL,
	[profile_name] [nvarchar](50) NOT NULL,
	[program_id] [int] NOT NULL,
	[pct_watched] [int] NOT NULL,
 CONSTRAINT [PK_Watched] PRIMARY KEY CLUSTERED 
(
	[email] ASC,
	[profile_name] ASC,
	[program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'adri34@outlook.com', N'Adri Jaspers', N'Scheldelaan 24', N'Hoeven')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'angelonac@live.nl', N'Angelo Koks', N'Noordeinde 18', N'Sprundel')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'arnobroeders@avans.nl', N'Arno Broeders', N'Lovensdijkstraat 62', N'Breda')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'dj.koeze@avans.nl', N'Dion Koeze', N'Feijenoord 33', N'Rotterdam')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'e.j.devoogt@avans.nl', N'Evert-Jan de Voogt', N'Voogtlaan 9', N'Breda')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'famdamen@kpnmail.nl', N'Wilma Damen', N'Achterste Monnikenland 14', N'Hoeven')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'i.moerenhout@hotmail.com', N'Ivan Moerenhout', N'Molendijk 111', N'Dinteloord')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'iza.moerenhout@hotmail.com', N'Iza Moerenhout', N'Molendijk 111', N'Dinteloord')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'jaspers68@kpnmail.nl', N'Lauran Jaspers', N'St. Bernardusstraat 11A', N'Hoeven')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'joppiebreda@gmail.com', N'Job Haast', N'Lovensdijkstraat 63', N'Breda')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'noahsamuel@gmail.com', N'Noah Korten', N'Stenenstraat 12', N'Steenbergen')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'ppth.vangastel@avans.nl', N'Pascal van Gastel', N'Lovensdijkstraat 61', N'Breda')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'rlm.hermans@avans.nl', N'Ruud Hermans', N'Hermanslaan 28', N'Breda')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'rowino24@hotmail.com', N'Rowin Bol', N'Achterste Monnikenland 24', N'Hoeven')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N's.jaspers1997@gmail.com', N'Stefan Jaspers', N'St. Bernardusstraat 11A', N'Hoeven')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'w.dejonge@hotmail.com', N'Wesley de Jonge', N'Langeweg 35', N'Dordrecht')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'x.naomitje@hotmail.com', N'Naomi de Jong', N'Noordeinde 20', N'Sprundel')
INSERT [dbo].[account] ([email], [name], [address], [city]) VALUES (N'zazet@gmail.com', N'Zareta Usmaeva', N'Pipostraat 9', N'Etten-Leur')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1001, N'S01E01', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1002, N'S01E02', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1003, N'S01E03', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1004, N'S02E01', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1005, N'S02E02', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1006, N'S02E03', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1007, N'S03E01', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1008, N'S03E02', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (1009, N'S03E03', N'Sherlock')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2000, N'S01E01', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2001, N'S01E02', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2002, N'S01E03', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2003, N'S01E04', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2004, N'S01E05', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2005, N'S01E06', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2006, N'S01E07', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2007, N'S02E01', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2008, N'S02E02', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2009, N'S02E03', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2010, N'S02E04', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2011, N'S02E05', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2012, N'S02E06', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2013, N'S02E07', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2014, N'S02E08', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2015, N'S02E09', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2016, N'S02E10', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2017, N'S02E11', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2018, N'S02E12', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (2019, N'S02E13', N'Breaking Bad')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3001, N'S01E01', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3002, N'S01E02', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3003, N'S01E03', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3004, N'S01E04', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3005, N'S01E05', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3006, N'S01E06', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3007, N'S01E07', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3008, N'S01E08', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3009, N'S01E09', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3010, N'S01E10', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3101, N'S02E01', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3102, N'S02E02', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3103, N'S02E03', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3104, N'S02E04', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3105, N'S02E05', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3106, N'S02E06', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3107, N'S02E07', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3108, N'S02E08', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3109, N'S02E09', N'Fargo')
INSERT [dbo].[episode] ([program_id], [episode_nr], [series_title]) VALUES (3110, N'S02E10', N'Fargo')
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (1010, N'Detective', N'English', 12)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8001, N'Humour', N'English', 12)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8002, N'Crime', N'English-American', 16)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8004, N'Eroticism', N'Dutch', 18)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8008, N'Crime', N'English-American', 16)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8010, N'Western', N'English-American', 12)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8011, N'Humour', N'English-American', 16)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8012, N'Humour', N'Dutch', 6)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8014, N'War', N'German', 6)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8016, N'Humour', N'Flemish', 12)
INSERT [dbo].[movie] ([program_id], [genre], [language], [age_rating]) VALUES (8017, N'Science Fiction', N'English', 16)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'dj.koeze@avans.nl', N'Dion', 32)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'dj.koeze@avans.nl', N'Krispijn', 33)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'iza.moerenhout@hotmail.com', N'Ivan', 14)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'iza.moerenhout@hotmail.com', N'Iza', 19)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'iza.moerenhout@hotmail.com', N'Kiki', 52)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'noahsamuel@gmail.com', N'Noah', 18)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 34)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N's.jaspers1997@gmail.com', N'Gerda', 51)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N's.jaspers1997@gmail.com', N'Lauran', 51)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N's.jaspers1997@gmail.com', N'Patrick', 19)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 22)
INSERT [dbo].[profile] ([email], [profile_name], [age]) VALUES (N'zazet@gmail.com', N'Zareta', 16)
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1001, N'A Study in Pink', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1002, N'The Blind Banker', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1003, N'The Great Game', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1004, N'A Scandal in Belgravia', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1005, N'The Hounds of Baskerville', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1006, N'The Reichenbach Fall
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1007, N'The Empty Hearse
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1008, N'The Sign of Three
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1009, N'His Last Vow
', CAST(N'01:28:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (1010, N'The Abominable Bride
', CAST(N'01:29:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2000, N'Pilot', CAST(N'00:58:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2001, N'Cat’s in the Bag', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2002, N'And the Bag’s in the River
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2003, N'Cancer Man
', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2004, N'Gray Matter', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2005, N'Crazy Handful of Nothin''', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2006, N'A No-Rough-Stuff-Type Deal', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2007, N'Seven-Thirty-Seven', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2008, N'Grilled', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2009, N'Bit by a Dead Bee', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2010, N'Down', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2011, N'Breakage', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2012, N'Peekaboo', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2013, N'Negro Y Azul', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2014, N'Better Call Saul', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2015, N'4 Days Out', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2016, N'Over', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2017, N'Mandala', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2018, N'Phoenix', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (2019, N'ABQ', CAST(N'00:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3001, N'The Crocodile''s Dilemma
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3002, N'The Rooster Prince
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3003, N'A Muddy Road
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3004, N'Eating the Blame
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3005, N'The Six Ungraspables
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3006, N'Buridan''s Ass
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3007, N'Who Shaves the Barber?
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3008, N'The Heap
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3009, N'A Fox, a Rabbit, and a Cabbage
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3010, N'Morton''s Fork
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3101, N'Waiting for Dutch
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3102, N'Before the Law', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3103, N'The Myth of Sisyphus
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3104, N'Fear and Trembling
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3105, N'The Gift of the Magi
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3106, N'Rhinoceros
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3107, N'Did you do this? No, you did it!
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3108, N'Loplop
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3109, N'The Castle
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (3110, N'Palindrome
', CAST(N'01:08:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8001, N'The Life of Brian', CAST(N'01:34:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8002, N'Pulp Fiction', CAST(N'02:34:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8004, N'Pruimebloesem', CAST(N'01:20:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8008, N'Reservoir Dogs', CAST(N'01:39:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8010, N'The Good, the Bad and the Ugly', CAST(N'02:41:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8011, N'Andy Warhol''s Dracula', CAST(N'01:43:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8012, N'Ober', CAST(N'01:37:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8014, N'Der Untergang', CAST(N'02:58:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8016, N'De helaasheid der dingen', CAST(N'01:48:00' AS Time))
INSERT [dbo].[program] ([program_id], [program_name], [length]) VALUES (8017, N'A Clockwork Orange', CAST(N'02:16:00' AS Time))
INSERT [dbo].[series] ([series_title], [genre], [language], [age_rating], [recommendation]) VALUES (N'Breaking Bad', N'Drama', N'English-American', N'16+', N'Fargo')
INSERT [dbo].[series] ([series_title], [genre], [language], [age_rating], [recommendation]) VALUES (N'Fargo', N'Drama', N'English-American', N'16+', N'Breaking Bad')
INSERT [dbo].[series] ([series_title], [genre], [language], [age_rating], [recommendation]) VALUES (N'Sherlock', N'Detective', N'English', N'12+', N'Fargo')
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'dj.koeze@avans.nl', N'Dion', 8010, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'dj.koeze@avans.nl', N'Krispijn', 8004, 98)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'dj.koeze@avans.nl', N'Krispijn', 8010, 64)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'iza.moerenhout@hotmail.com', N'Iza', 1001, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'iza.moerenhout@hotmail.com', N'Iza', 2000, 50)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'iza.moerenhout@hotmail.com', N'Iza', 2001, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 1001, 14)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3001, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3002, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3003, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3004, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3005, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3006, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3007, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'noahsamuel@gmail.com', N'Noah', 3008, 34)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 3001, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 3002, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 3003, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 3004, 50)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'rlm.hermans@avans.nl', N'Ruud', 8004, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Patrick', 2000, 44)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Patrick', 2001, 56)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Patrick', 2005, 89)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2000, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2001, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2002, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2003, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2004, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2005, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2006, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2007, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2008, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2009, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2010, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2011, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2012, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2013, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2014, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2015, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2016, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2017, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2018, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 2019, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 3001, 28)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 8004, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 8010, 12)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N's.jaspers1997@gmail.com', N'Stefan', 8012, 100)
INSERT [dbo].[watched_program] ([email], [profile_name], [program_id], [pct_watched]) VALUES (N'zazet@gmail.com', N'Zareta', 2001, 100)
ALTER TABLE [dbo].[episode]  WITH CHECK ADD  CONSTRAINT [FK_episode_program1] FOREIGN KEY([program_id])
REFERENCES [dbo].[program] ([program_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[episode] CHECK CONSTRAINT [FK_episode_program1]
GO
ALTER TABLE [dbo].[episode]  WITH CHECK ADD  CONSTRAINT [FK_episode_series1] FOREIGN KEY([series_title])
REFERENCES [dbo].[series] ([series_title])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[episode] CHECK CONSTRAINT [FK_episode_series1]
GO
ALTER TABLE [dbo].[movie]  WITH CHECK ADD  CONSTRAINT [FK_movie_program1] FOREIGN KEY([program_id])
REFERENCES [dbo].[program] ([program_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[movie] CHECK CONSTRAINT [FK_movie_program1]
GO
ALTER TABLE [dbo].[profile]  WITH CHECK ADD  CONSTRAINT [FK_profile_account1] FOREIGN KEY([email])
REFERENCES [dbo].[account] ([email])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[profile] CHECK CONSTRAINT [FK_profile_account1]
GO
ALTER TABLE [dbo].[series]  WITH CHECK ADD  CONSTRAINT [FK_series_series1] FOREIGN KEY([recommendation])
REFERENCES [dbo].[series] ([series_title])
GO
ALTER TABLE [dbo].[series] CHECK CONSTRAINT [FK_series_series1]
GO
ALTER TABLE [dbo].[watched_program]  WITH CHECK ADD  CONSTRAINT [FK_watched_program_profile] FOREIGN KEY([email], [profile_name])
REFERENCES [dbo].[profile] ([email], [profile_name])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[watched_program] CHECK CONSTRAINT [FK_watched_program_profile]
GO
ALTER TABLE [dbo].[watched_program]  WITH CHECK ADD  CONSTRAINT [FK_watched_program_program] FOREIGN KEY([program_id])
REFERENCES [dbo].[program] ([program_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[watched_program] CHECK CONSTRAINT [FK_watched_program_program]
GO
USE [master]
GO
ALTER DATABASE [Netflix Statistix] SET  READ_WRITE 
GO
