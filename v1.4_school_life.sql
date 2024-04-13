USE [master]
GO
/****** Object:  Database [school_life]    Script Date: 13-04-2024 15:51:25 ******/
CREATE DATABASE [school_life]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'school_life', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\school_life.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'school_life_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\school_life_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [school_life] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [school_life].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [school_life] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [school_life] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [school_life] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [school_life] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [school_life] SET ARITHABORT OFF 
GO
ALTER DATABASE [school_life] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [school_life] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [school_life] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [school_life] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [school_life] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [school_life] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [school_life] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [school_life] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [school_life] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [school_life] SET  DISABLE_BROKER 
GO
ALTER DATABASE [school_life] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [school_life] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [school_life] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [school_life] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [school_life] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [school_life] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [school_life] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [school_life] SET RECOVERY FULL 
GO
ALTER DATABASE [school_life] SET  MULTI_USER 
GO
ALTER DATABASE [school_life] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [school_life] SET DB_CHAINING OFF 
GO
ALTER DATABASE [school_life] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [school_life] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [school_life] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [school_life] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'school_life', N'ON'
GO
ALTER DATABASE [school_life] SET QUERY_STORE = ON
GO
ALTER DATABASE [school_life] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [school_life]
GO
/****** Object:  Table [dbo].[administradores]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[administradores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apaterno] [varchar](50) NOT NULL,
	[amaterno] [varchar](50) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[telefono] [int] NOT NULL,
	[cuenta] [int] NOT NULL,
	[colegio] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
 CONSTRAINT [PK_administradores] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[apoderados]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[apoderados](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [varchar](13) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apaterno] [varchar](50) NOT NULL,
	[amaterno] [varchar](50) NOT NULL,
	[direccion] [varchar](150) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[telefono] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[estudiante] [int] NOT NULL,
 CONSTRAINT [PK_apoderados] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[asignaturas]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[asignaturas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[hora_inicio] [datetime] NOT NULL,
	[hora_termino] [datetime] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[profesor_encargado] [int] NOT NULL,
 CONSTRAINT [PK_asignaturas] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[asistencias]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[asistencias](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[registro_asignatura] [int] NOT NULL,
	[fecha] [date] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[descripcion] [varchar](150) NULL,
 CONSTRAINT [PK_asistencias] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[colegios]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[colegios](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[telefono] [int] NOT NULL,
	[rbd] [int] NOT NULL,
	[direccion] [varchar](150) NOT NULL,
	[descripcion] [varchar](150) NULL,
 CONSTRAINT [PK_colegios] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cursos]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cursos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[seccion] [char](10) NOT NULL,
	[cantidad] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[profesor_jefe] [int] NOT NULL,
 CONSTRAINT [PK_cursos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[estudiantes]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[estudiantes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [varchar](13) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apaterno] [varchar](50) NOT NULL,
	[amaterno] [varchar](50) NOT NULL,
	[direccion] [varchar](150) NOT NULL,
	[telefono] [int] NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[colegio] [int] NOT NULL,
	[cuenta_sys] [int] NOT NULL,
	[curso] [int] NOT NULL,
 CONSTRAINT [PK_estudiantes] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[login]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[login](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_login] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[matriculas]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[matriculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](150) NULL,
	[estado] [varchar](50) NOT NULL,
	[estudiante] [int] NOT NULL,
	[apoderado] [int] NOT NULL,
	[colegio] [int] NOT NULL,
 CONSTRAINT [PK_matriculas] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[profesores]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[profesores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apaterno] [varchar](50) NOT NULL,
	[amaterno] [varchar](50) NOT NULL,
	[rut] [varchar](13) NOT NULL,
	[correo] [varchar](50) NOT NULL,
	[telefono] [int] NOT NULL,
	[especialidad] [varchar](50) NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[tipo] [int] NOT NULL,
	[colegio] [int] NOT NULL,
 CONSTRAINT [PK_profesores] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[registro_asignatura]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[registro_asignatura](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[estudiante] [int] NOT NULL,
	[asignatura] [int] NOT NULL,
	[descripcion] [varchar](150) NULL,
 CONSTRAINT [PK_registro_asignatura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[registro_conexiones]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[registro_conexiones](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](500) NOT NULL,
	[fecha] [date] NOT NULL,
 CONSTRAINT [PK_registro_conexiones] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[registro_cursos]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[registro_cursos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[estudiante] [int] NOT NULL,
	[curso] [int] NOT NULL,
	[descripcion] [varchar](200) NULL,
 CONSTRAINT [PK_registro_cursos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipo_profesor]    Script Date: 13-04-2024 15:51:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipo_profesor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_tipo_profesor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[administradores]  WITH CHECK ADD  CONSTRAINT [FK_admin_colegio] FOREIGN KEY([colegio])
REFERENCES [dbo].[colegios] ([id])
GO
ALTER TABLE [dbo].[administradores] CHECK CONSTRAINT [FK_admin_colegio]
GO
ALTER TABLE [dbo].[administradores]  WITH CHECK ADD  CONSTRAINT [FK_admin_login] FOREIGN KEY([cuenta])
REFERENCES [dbo].[login] ([id])
GO
ALTER TABLE [dbo].[administradores] CHECK CONSTRAINT [FK_admin_login]
GO
ALTER TABLE [dbo].[apoderados]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_apoderados] FOREIGN KEY([estudiante])
REFERENCES [dbo].[estudiantes] ([id])
GO
ALTER TABLE [dbo].[apoderados] CHECK CONSTRAINT [FK_estudiante_apoderados]
GO
ALTER TABLE [dbo].[asignaturas]  WITH CHECK ADD  CONSTRAINT [FK_profe_asignaturas] FOREIGN KEY([profesor_encargado])
REFERENCES [dbo].[profesores] ([id])
GO
ALTER TABLE [dbo].[asignaturas] CHECK CONSTRAINT [FK_profe_asignaturas]
GO
ALTER TABLE [dbo].[asistencias]  WITH CHECK ADD  CONSTRAINT [FK_registro_asistencia] FOREIGN KEY([registro_asignatura])
REFERENCES [dbo].[registro_asignatura] ([id])
GO
ALTER TABLE [dbo].[asistencias] CHECK CONSTRAINT [FK_registro_asistencia]
GO
ALTER TABLE [dbo].[cursos]  WITH CHECK ADD  CONSTRAINT [FK_curso_profesor] FOREIGN KEY([profesor_jefe])
REFERENCES [dbo].[profesores] ([id])
GO
ALTER TABLE [dbo].[cursos] CHECK CONSTRAINT [FK_curso_profesor]
GO
ALTER TABLE [dbo].[estudiantes]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_curso] FOREIGN KEY([curso])
REFERENCES [dbo].[cursos] ([id])
GO
ALTER TABLE [dbo].[estudiantes] CHECK CONSTRAINT [FK_estudiante_curso]
GO
ALTER TABLE [dbo].[estudiantes]  WITH CHECK ADD  CONSTRAINT [FK_estudiantes_colegios] FOREIGN KEY([colegio])
REFERENCES [dbo].[colegios] ([id])
GO
ALTER TABLE [dbo].[estudiantes] CHECK CONSTRAINT [FK_estudiantes_colegios]
GO
ALTER TABLE [dbo].[estudiantes]  WITH CHECK ADD  CONSTRAINT [FK_estudiantes_login] FOREIGN KEY([cuenta_sys])
REFERENCES [dbo].[login] ([id])
GO
ALTER TABLE [dbo].[estudiantes] CHECK CONSTRAINT [FK_estudiantes_login]
GO
ALTER TABLE [dbo].[matriculas]  WITH CHECK ADD  CONSTRAINT [FK_apoderado_matricula] FOREIGN KEY([apoderado])
REFERENCES [dbo].[apoderados] ([id])
GO
ALTER TABLE [dbo].[matriculas] CHECK CONSTRAINT [FK_apoderado_matricula]
GO
ALTER TABLE [dbo].[matriculas]  WITH CHECK ADD  CONSTRAINT [FK_colegio_matricula] FOREIGN KEY([colegio])
REFERENCES [dbo].[colegios] ([id])
GO
ALTER TABLE [dbo].[matriculas] CHECK CONSTRAINT [FK_colegio_matricula]
GO
ALTER TABLE [dbo].[matriculas]  WITH CHECK ADD  CONSTRAINT [FK_matricula_estudiante] FOREIGN KEY([estudiante])
REFERENCES [dbo].[estudiantes] ([id])
GO
ALTER TABLE [dbo].[matriculas] CHECK CONSTRAINT [FK_matricula_estudiante]
GO
ALTER TABLE [dbo].[profesores]  WITH CHECK ADD  CONSTRAINT [FK_profe_colegio] FOREIGN KEY([colegio])
REFERENCES [dbo].[colegios] ([id])
GO
ALTER TABLE [dbo].[profesores] CHECK CONSTRAINT [FK_profe_colegio]
GO
ALTER TABLE [dbo].[profesores]  WITH CHECK ADD  CONSTRAINT [FK_profesor_tipo] FOREIGN KEY([tipo])
REFERENCES [dbo].[tipo_profesor] ([id])
GO
ALTER TABLE [dbo].[profesores] CHECK CONSTRAINT [FK_profesor_tipo]
GO
ALTER TABLE [dbo].[registro_asignatura]  WITH CHECK ADD  CONSTRAINT [FK_asignatura_asistencia] FOREIGN KEY([asignatura])
REFERENCES [dbo].[asignaturas] ([id])
GO
ALTER TABLE [dbo].[registro_asignatura] CHECK CONSTRAINT [FK_asignatura_asistencia]
GO
ALTER TABLE [dbo].[registro_asignatura]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_asistencia] FOREIGN KEY([estudiante])
REFERENCES [dbo].[estudiantes] ([id])
GO
ALTER TABLE [dbo].[registro_asignatura] CHECK CONSTRAINT [FK_estudiante_asistencia]
GO
ALTER TABLE [dbo].[registro_cursos]  WITH CHECK ADD  CONSTRAINT [FK_datos_curso] FOREIGN KEY([curso])
REFERENCES [dbo].[cursos] ([id])
GO
ALTER TABLE [dbo].[registro_cursos] CHECK CONSTRAINT [FK_datos_curso]
GO
ALTER TABLE [dbo].[registro_cursos]  WITH CHECK ADD  CONSTRAINT [FK_datos_estudiante] FOREIGN KEY([estudiante])
REFERENCES [dbo].[estudiantes] ([id])
GO
ALTER TABLE [dbo].[registro_cursos] CHECK CONSTRAINT [FK_datos_estudiante]
GO
USE [master]
GO
ALTER DATABASE [school_life] SET  READ_WRITE 
GO
