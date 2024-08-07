USE [master]
GO
/****** Object:  Database [daem_hualpen]    Script Date: 11-07-2024 21:57:56 ******/
CREATE DATABASE [daem_hualpen]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'daem_hualpen', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\daem_hualpen.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'daem_hualpen_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\daem_hualpen_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [daem_hualpen] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [daem_hualpen].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [daem_hualpen] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [daem_hualpen] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [daem_hualpen] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [daem_hualpen] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [daem_hualpen] SET ARITHABORT OFF 
GO
ALTER DATABASE [daem_hualpen] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [daem_hualpen] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [daem_hualpen] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [daem_hualpen] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [daem_hualpen] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [daem_hualpen] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [daem_hualpen] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [daem_hualpen] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [daem_hualpen] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [daem_hualpen] SET  DISABLE_BROKER 
GO
ALTER DATABASE [daem_hualpen] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [daem_hualpen] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [daem_hualpen] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [daem_hualpen] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [daem_hualpen] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [daem_hualpen] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [daem_hualpen] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [daem_hualpen] SET RECOVERY FULL 
GO
ALTER DATABASE [daem_hualpen] SET  MULTI_USER 
GO
ALTER DATABASE [daem_hualpen] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [daem_hualpen] SET DB_CHAINING OFF 
GO
ALTER DATABASE [daem_hualpen] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [daem_hualpen] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [daem_hualpen] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [daem_hualpen] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'daem_hualpen', N'ON'
GO
ALTER DATABASE [daem_hualpen] SET QUERY_STORE = ON
GO
ALTER DATABASE [daem_hualpen] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [daem_hualpen]
GO
/****** Object:  Table [dbo].[apoderados]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[apoderados](
	[run_apoderado] [varchar](12) NOT NULL,
	[estudiante_id] [varchar](12) NULL,
	[numero_documento] [int] NULL,
	[nombres] [varchar](255) NULL,
	[apaterno] [varchar](255) NULL,
	[amaterno] [varchar](255) NULL,
	[pasaporte] [varchar](20) NULL,
	[parentesco] [varchar](100) NULL,
	[tipo_apoderado] [varchar](100) NULL,
	[fecha_nacimiento] [date] NULL,
	[domicilio] [varchar](255) NULL,
	[comuna] [varchar](100) NULL,
	[nivel_educacion] [varchar](250) NULL,
	[ocupacion] [varchar](250) NULL,
	[telefono] [varchar](20) NULL,
	[celular] [varchar](20) NULL,
	[correo_electronico] [varchar](255) NULL,
	[es_tutor] [bit] NULL,
	[acepta_manual_convivencia_escolar] [bit] NULL,
	[autorizacion_fotografia_grabacion] [bit] NULL,
	[autorizado_retirar_establecimiento] [bit] NULL,
	[estado_civil] [varchar](50) NULL,
 CONSTRAINT [PK__apoderad__D878D53644462B45] PRIMARY KEY CLUSTERED 
(
	[run_apoderado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[asignaturas]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[asignaturas](
	[id_asignatura] [int] NOT NULL,
	[nombre] [varchar](250) NULL,
	[tiene_profesor_titular] [bit] NULL,
	[profesor_id] [varchar](100) NULL,
	[curso_id] [int] NOT NULL,
 CONSTRAINT [PK_asignaturas] PRIMARY KEY CLUSTERED 
(
	[id_asignatura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[asistencias]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[asistencias](
	[id_asistencia] [int] NOT NULL,
	[fecha] [date] NULL,
	[asistio] [bit] NULL,
	[estudiante_id] [varchar](12) NOT NULL,
	[curso_id] [int] NOT NULL,
 CONSTRAINT [PK_asistencias] PRIMARY KEY CLUSTERED 
(
	[id_asistencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cursos]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cursos](
	[id_curso] [int] IDENTITY(1,1) NOT NULL,
	[nivel_ensenanza] [varchar](255) NULL,
	[nivel] [varchar](255) NULL,
	[letra] [varchar](255) NULL,
	[jornada] [varchar](100) NULL,
	[capacidad] [int] NULL,
	[local] [varchar](255) NULL,
	[numero_sala] [varchar](10) NULL,
	[apodo] [varchar](255) NULL,
	[establecimiento_id] [int] NULL,
 CONSTRAINT [PK__cursos__5D3F75027B1044C4] PRIMARY KEY CLUSTERED 
(
	[id_curso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[establecimientos]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[establecimientos](
	[rbd] [int] NOT NULL,
	[nombre] [varchar](255) NULL,
	[direccion] [varchar](255) NULL,
	[region] [varchar](100) NULL,
	[comuna] [varchar](100) NULL,
	[fecha_aniversario] [date] NULL,
	[correo_electronico] [varchar](255) NULL,
	[pagina_web] [varchar](255) NULL,
	[numero_telefonico] [varchar](20) NULL,
	[zona_horaria] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[rbd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[estudiantes]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[estudiantes](
	[run_estudiante] [varchar](12) NOT NULL,
	[nombre] [varchar](255) NULL,
	[apaterno] [varchar](255) NULL,
	[amaterno] [varchar](255) NULL,
	[numero_matricula] [int] NULL,
	[fecha_matricula] [date] NULL,
	[fecha_nacimiento] [date] NULL,
	[pais_nacimiento] [varchar](100) NULL,
	[genero] [varchar](50) NULL,
	[direccion] [varchar](255) NULL,
	[comuna] [varchar](100) NULL,
	[correo_electronico] [varchar](255) NULL,
	[telefono] [varchar](20) NULL,
	[celular] [varchar](20) NULL,
	[colegio_procedencia] [varchar](255) NULL,
	[nombre_contacto_emergencia] [varchar](255) NULL,
	[telefono_emergencia] [varchar](20) NULL,
	[vive_con] [varchar](100) NULL,
	[cantidad_computadores_casa] [int] NULL,
	[religion] [varchar](100) NULL,
	[acepta_clases_religion] [bit] NULL,
	[beca] [varchar](max) NULL,
	[estatura] [int] NULL,
	[peso] [decimal](5, 2) NULL,
	[grupo_sanguineo] [varchar](10) NULL,
	[alergias_alimentos] [varchar](max) NULL,
	[alergias_medicamentos] [varchar](max) NULL,
	[medicamentos_contraindicados] [varchar](max) NULL,
	[enfermedades_cronicas] [varchar](max) NULL,
	[vacuna_covid] [bit] NULL,
	[cantidad_vacunas_covid] [int] NULL,
	[esquema_completo_vacunacion_covid] [bit] NULL,
	[fecha_ultima_vacuna_COVID] [date] NULL,
	[apto_educacion_fisica] [bit] NULL,
	[sistema_prevision] [varchar](100) NULL,
	[seguro_escolar_privado] [bit] NULL,
	[nacionalidad] [varchar](100) NULL,
	[etnia] [varchar](100) NULL,
	[consultorio_clinica] [varchar](255) NULL,
	[observaciones_medicas] [varchar](max) NULL,
	[estado] [bit] NULL,
	[establecimiento_id] [int] NOT NULL,
	[curso_id] [int] NOT NULL,
	[es_pie] [bit] NULL,
 CONSTRAINT [PK__estudian__B91DDEF227770094] PRIMARY KEY CLUSTERED 
(
	[run_estudiante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[historial_estudiante]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[historial_estudiante](
	[id_historial] [int] IDENTITY(1,1) NOT NULL,
	[id_estudiante] [varchar](12) NULL,
	[nombre] [varchar](255) NULL,
	[apaterno] [varchar](255) NULL,
	[amaterno] [varchar](255) NULL,
	[numero_matricula] [int] NULL,
	[curso] [varchar](50) NULL,
	[establecimiento] [varchar](250) NULL,
	[es_pie] [varchar](250) NULL,
	[fecha_matricula] [date] NULL,
	[fecha_nacimiento] [date] NULL,
	[hoja_de_vida] [varchar](500) NULL,
 CONSTRAINT [PK_historial_estudiante] PRIMARY KEY CLUSTERED 
(
	[id_historial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoja_de_vida]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoja_de_vida](
	[id_hoja_de_vida] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NULL,
	[tipo_evento] [varchar](100) NULL,
	[asignatura] [varchar](100) NULL,
	[detalle] [varchar](250) NULL,
	[archivo] [varchar](250) NULL,
	[usuario_id] [varchar](100) NOT NULL,
	[estudiante_id] [varchar](12) NOT NULL,
 CONSTRAINT [PK_hoja_de_vida] PRIMARY KEY CLUSTERED 
(
	[id_hoja_de_vida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[notas]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[notas](
	[id_nota] [int] NOT NULL,
	[semestre] [varchar](50) NULL,
	[nota] [decimal](5, 2) NULL,
	[escala_numerica] [varchar](100) NULL,
	[escala_conceptual] [varchar](100) NULL,
	[promedio] [decimal](5, 2) NULL,
	[id_estudiante] [varchar](12) NOT NULL,
	[id_asignatura] [int] NOT NULL,
 CONSTRAINT [PK_notas] PRIMARY KEY CLUSTERED 
(
	[id_nota] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[periodo_bloqueo]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[periodo_bloqueo](
	[id_periodo] [int] NOT NULL,
	[fecha_inicio] [date] NULL,
	[fecha_fin] [date] NULL,
 CONSTRAINT [PK_periodo_bloqueo] PRIMARY KEY CLUSTERED 
(
	[id_periodo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[programa_integracion]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[programa_integracion](
	[id_Programa] [int] IDENTITY(1,1) NOT NULL,
	[estudiante_id] [varchar](12) NULL,
	[permanencia_pie] [bit] NULL,
	[tipo_permanencia] [varchar](100) NULL,
	[indicaciones_generales] [varchar](max) NULL,
 CONSTRAINT [PK__programa__D1FDCC476075D8E2] PRIMARY KEY CLUSTERED 
(
	[id_Programa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id_rol] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[descripcion] [varchar](200) NULL,
 CONSTRAINT [PK_rol] PRIMARY KEY CLUSTERED 
(
	[id_rol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuarios]    Script Date: 11-07-2024 21:57:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuarios](
	[rut_usuario] [varchar](100) NOT NULL,
	[pass] [varchar](250) NULL,
	[nombre] [varchar](50) NULL,
	[apaterno] [varchar](50) NULL,
	[amaterno] [varchar](50) NULL,
	[correo] [varchar](150) NULL,
	[telefono] [varchar](50) NULL,
	[fecha_nacimiento] [date] NULL,
	[genero] [varchar](50) NULL,
	[estudios] [varchar](50) NULL,
	[cargo] [varchar](50) NULL,
	[establecimiento_id] [int] NOT NULL,
	[rol_id] [int] NULL,
 CONSTRAINT [PK_usuarios] PRIMARY KEY CLUSTERED 
(
	[rut_usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'10716977-6', N'38692036-2', 222112, N'Roberto Pédro', N'Alvarado', N'Soteldo', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda 33', N'Hualpén', N'Educacion superior', N'Informatico', N'87678866', N'87665566', N'ribariba@gmail.com', 1, 1, 1, 1, N'casado')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'10961134-4', N'3768057-5', 222112, N'Fernanda Alejandra', N'Perez', N'Soteldo', N'', N'MADRE', N'APODERADO TITULAR', CAST(N'2024-05-28' AS Date), N'avda san andrés', N'Hualpén', N'PROFESIONAL INCOMPLETA', N'Informático', N'9876655', N'98767655', N'solteldo@info.cl', 1, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'13586228-2', N'7564781-6', 222112, N'alfredo', N'Soto', N'Ramirez', N'', N'OTROS', N'APODERADO TITULAR', CAST(N'1990-04-19' AS Date), N'avda san andrés 66', N'Concepción', N'TÉCNICA NIVEL SUPERIOR COMPLETA', N'Informático', N'4426655', N'98767655', N'info@info.cl', 1, 1, 1, 1, N'SOLTERO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'16593247-1', N'3039080-6', 222112, N'luis', N'navarrete', N'perez', N'', N'MADRE', N'APODERADO TITULAR', CAST(N'1967-10-09' AS Date), N'avda san andrés', N'Concepción', N'PROFESIONAL INCOMPLETA', N'Informático', N'9876655', N'98767655', N'info6@info.cl', 1, 1, 1, 1, N'SOLTERO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'16594285-k', N'2161373-8', 222112, N'Mireya Laura', N'Montecinos', N'Altamirano', N'', N'MADRE', N'APODERADO TITULAR', CAST(N'1969-10-09' AS Date), N'avda san andrés 66', N'Hualpén', N'TÉCNICA NIVEL SUPERIOR INCOMPLETA', N'Dueña de casa', N'442343456', N'987786655', N'mireyaalta@gmail.com', 1, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'17663724-2', N'25679175-7', 222112, N'Ricardo Aalejandro', N'Meruane', N'Merino', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda34', N'Hualpén', N'Educacion superior', N'Informatico', N'88776688', N'87667788', N'palabrass@gmail.com', 1, 1, 1, 1, N'casado')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'20112799-8', N'10754406-2', 222112, N'Julia Javiera', N'Avendaño', N'Zamorano', N'121211', N'MADRE', N'APODERADO TITULAR', CAST(N'2024-05-30' AS Date), N'avda san andrés 66', N'Concepción', N'PROFESIONAL COMPLETA', N'Informático', N'4426655', N'98767655', N'juliajav@info.cl', 1, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'23937298-8', N'14967096-3', 11112223, N'Pedro Francisco', N'Perez', N'Maturana', N'', N'TÍO', N'APODERADO TITULAR', CAST(N'1970-10-09' AS Date), N'avda san andrés 66', N'Concepción', N'TÉCNICA NIVEL SUPERIOR INCOMPLETA', N'Mecanico Automotríz', N'4426655', N'98767655', N'pedrofran@gmail.com', 1, 1, 1, 1, N'VIUDO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'26874680-3', N'19740489-2', 222112, N'Alberto Andrés', N'Valenzuela', N'Morales', N'121211', N'TÍO', N'APODERADO TITULAR', CAST(N'2024-05-27' AS Date), N'avda san andrés 60', N'Concepción', N'PROFESIONAL INCOMPLETA', N'Informático', N'9876655', N'98767655', N'alberto@info.cl', 0, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'2822211-4', N'19827133-0', 9, N'Alfredo', N'Fuentes', N'Gallardo', N'', N'ABUELO', N'APODERADO TITULAR', CAST(N'1959-05-27' AS Date), N'avda san andrés 66', N'Hualpén', N'POSGRADO/POSTÍTULOS', N'Ingeniero en Administración', N'9876655', N'987676556', N'info@info.cl', 0, 0, 1, 1, N'SEPARADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'36493031-3', N'56449023-7', 22211, N'Ignacio', N'Norin', N'Norin', N'', N'PADRE', N'APODERADO TITULAR', CAST(N'1970-05-28' AS Date), N'avda san andrés 66', N'Hualpén', N'TÉCNICA NIVEL SUPERIOR COMPLETA', N'Informático', N'', N'9876765', N'norinnorin@info.cl', 1, 1, 1, 1, N'SEPARADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'37554210-2', N'1006959-9', 222112, N'Pedro Juan', N'Alvarado', N'Soteldo', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda 33', N'Hualpén', N'Educacion superior', N'Informatico', N'87678866', N'87665566', N'prueba3@gmail.com', 1, 1, 1, 1, N'casado')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'50946586-k', N'15438925-3', 222112, N'Ricardo Aalejandro', N'Meruane', N'Merino', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda34', N'Hualpén', N'Educacion superior', N'Informatico', N'88776688', N'87667788', N'prueba4@gmail.com', 1, 1, 1, 1, N'casado')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'57111599-9', N'48938092-7', 222112, N'Franco Bayron', N'Pardo', N'Peres', N'', N'HERMANO', N'APODERADO TITULAR', CAST(N'2024-05-28' AS Date), N'avda san andrés', N'Hualpén', N'PROFESIONAL INCOMPLETA', N'Informático', N'9876655', N'98767655', N'franco@info.cl', 1, 1, 1, 1, N'SOLTERO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'7034751-2', N'9396369-5', 222112, N'Francisco Manuel', N'Roca', N'Martinez', N'121211', N'PADRE', N'APODERADO TITULAR', CAST(N'2024-05-28' AS Date), N'avda san andrés', N'Hualpén', N'PROFESIONAL INCOMPLETA', N'Informático', N'98766553', N'98767655', N'roca@info.cl', 1, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'7731765-1', N'33489746-k', 222112, N'Prueba3', N'prueba4', N'apmaterno3', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda 33', N'Hualpén', N'Educacion superior', N'Informatico', N'87678866', N'87665566', N'prueba3@gmail.com', 0, 0, 0, 0, N'casado')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'9289507-6', N'3399584-9', 222112, N'Maximiliano', N'Hernandez', N'Palma', N'', N'PADRE', N'APODERADO TITULAR', CAST(N'2024-05-29' AS Date), N'avda san andrés', N'Hualpén', N'PROFESIONAL COMPLETA', N'Informático', N'987665523', N'98767655', N'maxip@info.cl', 1, 1, 1, 1, N'CASADO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'9719977-9', N'7528007-6', 222112, N'Roberto José', N'Canifru', N'Caleido', N'121211', N'PADRE', N'APODERADO TITULAR', CAST(N'2024-05-26' AS Date), N'avda san andrés 66', N'Concepción', N'TÉCNICA NIVEL SUPERIOR COMPLETA', N'Informático', N'4426655', N'98767655', N'canifru@info.cl', 1, 1, 1, 1, N'SOLTERO')
INSERT [dbo].[apoderados] ([run_apoderado], [estudiante_id], [numero_documento], [nombres], [apaterno], [amaterno], [pasaporte], [parentesco], [tipo_apoderado], [fecha_nacimiento], [domicilio], [comuna], [nivel_educacion], [ocupacion], [telefono], [celular], [correo_electronico], [es_tutor], [acepta_manual_convivencia_escolar], [autorizacion_fotografia_grabacion], [autorizado_retirar_establecimiento], [estado_civil]) VALUES (N'9915837-9', N'33770255-4', 222112, N'Prueba4', N'prueba44', N'amaterno4', N'123456', N'Padre', N'Titular', CAST(N'2023-10-10' AS Date), N'avda34', N'Hualpén', N'Educacion superior', N'Informatico', N'88776688', N'87667788', N'prueba4@gmail.com', 0, 0, 0, 0, N'casado')
GO
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (1, N'Matemáticas', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (2, N'Historia', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (3, N'Inglés', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (4, N'Lenguaje y Comunicación', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (5, N'Educación Física', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (6, N'Artes visuales', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (7, N'Música', 0, NULL, 1)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (8, N'Matemáticas', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (9, N'Historia', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (10, N'Inglés', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (11, N'Lenguaje y Comunicación', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (12, N'Educación Física', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (13, N'Artes visuales', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (14, N'Música', 0, NULL, 2)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (15, N'Matemáticas', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (16, N'Historia', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (17, N'Inglés', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (18, N'Lenguaje y Comunicación', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (19, N'Educación Física', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (20, N'Artes visuales', 0, NULL, 3)
INSERT [dbo].[asignaturas] ([id_asignatura], [nombre], [tiene_profesor_titular], [profesor_id], [curso_id]) VALUES (21, N'Música', 0, NULL, 3)
GO
SET IDENTITY_INSERT [dbo].[cursos] ON 

INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (1, N'Media - Rama Comercial y Técnica', N'PRIMERO', N'A', N'MAÑANA', 45, N'PRINCIPAL', N'', N'1° A', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (2, N'Media - Rama Comercial y Técnica', N'PRIMERO', N'B', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (3, N'Media - Rama Comercial y Técnica', N'SEGUNDO', N'A', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (4, N'Media - Rama Comercial y Técnica', N'SEGUNDO', N'B', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (5, N'Media - Rama Comercial y Técnica', N'TERCERO', N'A', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (6, N'Educación Parvularia - Sala cuna', N'TERCERO', N'B', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (7, N'Media - Rama Comercial y Técnica', N'CUARTO', N'A', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
INSERT [dbo].[cursos] ([id_curso], [nivel_ensenanza], [nivel], [letra], [jornada], [capacidad], [local], [numero_sala], [apodo], [establecimiento_id]) VALUES (8, N'Media - Rama Comercial y Técnica', N'CUARTO', N'B', N'MAÑANA', 45, N'PRINCIPAL', N'', N'', 4706)
SET IDENTITY_INSERT [dbo].[cursos] OFF
GO
INSERT [dbo].[establecimientos] ([rbd], [nombre], [direccion], [region], [comuna], [fecha_aniversario], [correo_electronico], [pagina_web], [numero_telefonico], [zona_horaria]) VALUES (4706, N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Génova 8260', N'Región del Biobío', N'Hualpén', CAST(N'2019-08-05' AS Date), N'pedrodelrio@daemhualpen.cl', N'NO REGISTRADO', N'412668873', N'America/Santiago (UTC-4)')
INSERT [dbo].[establecimientos] ([rbd], [nombre], [direccion], [region], [comuna], [fecha_aniversario], [correo_electronico], [pagina_web], [numero_telefonico], [zona_horaria]) VALUES (4722, N'ESCUELA BLANCA ESTELA PRAT CARVAJAL', N'Bulgaria 3421', N'Región del Biobío', N'Hualpén', CAST(N'1973-10-21' AS Date), N'bleestela@gmail.com', N'No registrado', N'2178544', N'America/Santiago (UTC-4)')
INSERT [dbo].[establecimientos] ([rbd], [nombre], [direccion], [region], [comuna], [fecha_aniversario], [correo_electronico], [pagina_web], [numero_telefonico], [zona_horaria]) VALUES (4730, N'ESCUELA ALONKURA', N'Curanilahue 499', N'Región del Biobío', N'Hualpén', CAST(N'2022-11-16' AS Date), N'alonkura@educahualpen.cl', N'No registrado', N'12345678', N'America/Santiago (UTC-4)')
GO
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'1006959-9', N'Eduardo', N'Fuentes', N'Santana', 11, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'coronel', N'jordan2@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'laura valenzuela', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, 2, 0, CAST(N'2024-06-12' AS Date), 1, N'si', 0, N'chileno', N'ninguno', N'consultorio', N'observaciónes', 1, 4706, 1, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'10754406-2', N'Matilde Sofía', N'Fernandez', N'Opazo', 5, CAST(N'2024-06-11' AS Date), CAST(N'2024-06-03' AS Date), N'CHILENA', N'femenino', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'matilde@info.cl', N'933114267', N'988665577', N'Comercial de Hualpén', N'Marcela Fernandez', N'988667755', N'AMBOS PADRES', 3, N'Cristianismo', 0, N'Beca indigena', 165, CAST(69.00 AS Decimal(5, 2)), N'B +', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 1, 2, 0, CAST(N'2024-05-27' AS Date), 1, N'Fonasa', 1, N'CHILENA', N'NINGUNO', N'centro médico sepya', N'Estudiante con trastorno de ansiedad, TDH y trastorno limitrofe de la personalidad.', 1, 4706, 2, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'14967096-3', N'Pedro Juan', N'Maldonado', N'Soria', 10, CAST(N'2024-07-07' AS Date), CAST(N'2005-10-09' AS Date), N'CHILENA', N'masculino', N'Los Alamos 776 ', N'Hualpén', N'pedroj@gmail.com', N'442556677', N'955667766', N'Liceo de Hualpén', N'Oriana Melo', N'955667766', N'AMBOS PADRES', 3, N'Catolicismo', 1, N'Beca indigena', 150, CAST(60.00 AS Decimal(5, 2)), N'A -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Fonasa', 0, N'CHILENA', N'MAPUCHE', N'consultorio', N'', 1, 4706, 4, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'15438925-3', N'Felipe', N'Avello', N'Morelios', 9, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'coronel', N'jordan2@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'laura valenzuela', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, NULL, 0, CAST(N'2024-06-12' AS Date), 1, N'no', 0, N'chileno', N'ninguno', N'consultorio', N'', 1, 4706, 2, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'19740489-2', N'Pablo Andrés', N'Contreras', N'Merino', 2, CAST(N'2024-06-12' AS Date), CAST(N'2024-05-26' AS Date), N'CHILENA', N'masculino', N'Los Alamos 779 Hualpén, Hualpén', N'Hualpén', N'pablocon@gmail.com', N'933114267', N'966346544', N'Comercial de Hualpén', N'Marcela Pérez', N'966556677', N'AMBOS PADRES', 3, N'Otras', 1, N'Ninguna', 169, CAST(74.00 AS Decimal(5, 2)), N'O -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 1, 2, 0, CAST(N'2022-05-26' AS Date), 1, N'Fonasa A', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'prueba.', 0, 4706, 1, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'19827133-0', N'Eugenio', N'Reyes', N'Conejero', 14, CAST(N'2024-06-16' AS Date), CAST(N'2024-05-26' AS Date), N'CHILENA', N'masculino', N'Génova 8260 ', N'Hualpén', N'kenor@info.cl', N'933114267', N'98987654', N'Liceo de Hualpén', N'Marcela Fernandez', N'87678789', N'AMBOS PADRES', 2, N'Bahaísmo', 1, N'Beca indigena', 169, CAST(69.00 AS Decimal(5, 2)), N'B +', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Fonasa', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'', 0, 4706, 3, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'2161373-8', N'Samanta Javiera', N'Durán', N'Montecinos', 12, CAST(N'2024-07-06' AS Date), CAST(N'2005-05-09' AS Date), N'CHILENA', N'femenino', N'Los Alamos 779 Hualpén, Hualpén', N'Hualpén', N'samantahavi@gmail.com', N'442768545', N'933445544', N'Liceo de Hualpén', N'Mireya Montecinos', N'986334465', N'AMBOS PADRES', 3, N'Catolicismo', 1, N'Ninguna', 155, CAST(62.00 AS Decimal(5, 2)), N'AB +', N'no tiene', N'no tiene', N'no tiene', N'AUDITIVO', 0, NULL, 0, NULL, 1, N'Fonasa', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'', 1, 4706, 2, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'25679175-7', N'Germán Franco', N'Avello', N'Morelios', 18, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'Hualpén', N'german@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'laura valenzuela', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, NULL, 0, CAST(N'2024-06-12' AS Date), 1, N'no', 0, N'chileno', N'ninguno', N'consultorio', N'', 1, 4706, 2, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'3039080-6', N'pedro alberto', N'reyes', N'soto', 19, CAST(N'2024-07-08' AS Date), CAST(N'2005-10-09' AS Date), N'CHILENA', N'masculino', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'pedro@gmail.com', N'442334455', N'966556677', N'Liceo de Hualpén', N'Marcela Soto', N'977887766', N'AMBOS PADRES', 3, N'Catolicismo', 1, N'Beca indigena', 150, CAST(60.00 AS Decimal(5, 2)), N'B +', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Fonasa', 1, N'CHILENA', N'NINGUNO', N'consultorio', N'', 1, 4706, 1, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'33489746-k', N'Roberto', N'Rojas', N'soto', 13, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'coronel', N'jordan2@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'laura valenzuela', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, 2, 0, CAST(N'2024-06-12' AS Date), 1, N'no', 0, N'chileno', N'ninguno', N'consultorio', N'4706', 1, 4706, 1, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'33770255-4', N'Pablo', N'Contreras', N'soto', 15, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'coronel', N'jordan2@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'laura valenzuela', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, 2, 0, CAST(N'2024-06-12' AS Date), 1, N'no', 0, N'chileno', N'ninguno', N'consultorio', N'4706', 1, 4706, 2, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'3399584-9', N'Wacoldo', N'Saez', N'Pereira', 6, CAST(N'2024-06-15' AS Date), CAST(N'2024-05-26' AS Date), N'CHILENA', N'masculino', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'pablos@info.cl', N'9331142', N'98877887', N'Liceo de Hualpén', N'Mauricio Machuca', N'87876543', N'AMBOS PADRES', NULL, N'Bahaísmo', 1, N'No tiene', 170, CAST(75.00 AS Decimal(5, 2)), N'A -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Dipreca', 1, N'CHILENA', N'NINGUNO', N'consultorio', N'', 1, 4706, 1, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'3768057-5', N'Ivan', N'Zamora', N'Zamorano', 1, CAST(N'2024-06-15' AS Date), CAST(N'2024-06-03' AS Date), N'CHILENA', N'otro', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'pablocon@gmail.com', N'933114267', N'87878787', N'Liceo de Hualpén', N'Mauricio Machuca', N'76546789', N'AMBOS PADRES', 4, N'Islam', 1, N'No tiene', 169, CAST(60.00 AS Decimal(5, 2)), N'AB -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 1, 2, 0, CAST(N'2022-12-25' AS Date), 0, N'Fonasa', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'Es un alumno TDA.', 1, 4706, 4, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'38692036-2', N'Amelia Antonia', N'Fuentes', N'Santana', 17, CAST(N'2024-06-12' AS Date), CAST(N'2024-06-12' AS Date), N'Chile', N'masculino', N'avda aa', N'Hualpén', N'amelia@gmail.com', N'933114267', N'933114267', N'liceo de coronel', N'Amelia Ribarola', N'966556677', N'padres', 3, N'si', 1, N'no tiene', 165, CAST(90.00 AS Decimal(5, 2)), N'a-', N'no', N'no', N'no', N'no', 1, 2, 0, CAST(N'2024-06-12' AS Date), 1, N'si', 0, N'chileno', N'ninguno', N'consultorio', N'observaciónes', 1, 4706, 1, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'48938092-7', N'jairo', N'Valenzuela', N'Soto', 7, CAST(N'2024-06-12' AS Date), CAST(N'2024-05-22' AS Date), N'CHILENA', N'masculino', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'jairo@info.cl', N'9331142', N'988776677', N'Liceo de Hualpén', N'Mauricio Machuca', N'87878787', N'AMBOS PADRES', 3, N'Cheondoísmo', 0, N'Beca indigena', 165, CAST(78.00 AS Decimal(5, 2)), N'AB +', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Fonasa', 1, N'CHILENA', N'ALACALUFE', N'no aplica', N'tiene TDH', 1, 4706, 1, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'56449023-7', N'Francisco', N'Reyes', N'Mieres', 8, CAST(N'2024-06-16' AS Date), CAST(N'1995-06-04' AS Date), N'CHILENA', N'otro', N'Los Alamos 779 Hualpén, Hualpén', N'Hualpén', N'panchito@gmail.com', N'933114267', N'98765678', N'Liceo de Hualpén', N'Mauricio Machuca', N'87878787', N'AMBOS PADRES', NULL, N'Islam', 1, N'Ninguna', 168, CAST(50.00 AS Decimal(5, 2)), N'AB -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Isapre', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,Tiene TDA,.', 1, 4706, 2, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'7528007-6', N'Pedro José', N'Canifru', N'Saez', 3, CAST(N'2024-06-10' AS Date), CAST(N'2024-05-26' AS Date), N'CHILENA', N'masculino', N'Los Alamos 776 Hualpén, Hualpén', N'Hualpén', N'pedrocanifru@gmail.com', N'933114267', N'933114267', N'Comercial de Hualpén', N'Nelly Soto', N'968753344', N'AMBOS PADRES', 4, N'Cristianismo', 1, N'No tiene', 165, CAST(96.00 AS Decimal(5, 2)), N'AB +', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 1, 4, 0, CAST(N'2022-04-25' AS Date), 1, N'Fonasa', 0, N'CHILENA', N'NINGUNO', N'consultorio', N'no aplica.', 1, 4706, 1, 1)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'7564781-6', N'Martin', N'Reyes', N'Soto', 16, CAST(N'2024-07-07' AS Date), CAST(N'2008-07-07' AS Date), N'CHILENA', N'masculino', N'Curanilahue 499', N'Hualpén', N'ejemplo@ejemplo.com', N'442334455', N'933445544', N'Liceo de Hualpén', N'Marcela Fernandez', N'977887766', N'AMBOS PADRES', 3, N'Sin religión', 1, N'Beca indigena', 165, CAST(70.00 AS Decimal(5, 2)), N'A -', N'no tiene', N'no tiene', N'no tiene', N'NINGUNA', 0, NULL, 0, NULL, 1, N'Fonasa A', 1, N'CHILENA', N'NINGUNO', N'consultorio', N'', 1, 4706, 3, 0)
INSERT [dbo].[estudiantes] ([run_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [fecha_matricula], [fecha_nacimiento], [pais_nacimiento], [genero], [direccion], [comuna], [correo_electronico], [telefono], [celular], [colegio_procedencia], [nombre_contacto_emergencia], [telefono_emergencia], [vive_con], [cantidad_computadores_casa], [religion], [acepta_clases_religion], [beca], [estatura], [peso], [grupo_sanguineo], [alergias_alimentos], [alergias_medicamentos], [medicamentos_contraindicados], [enfermedades_cronicas], [vacuna_covid], [cantidad_vacunas_covid], [esquema_completo_vacunacion_covid], [fecha_ultima_vacuna_COVID], [apto_educacion_fisica], [sistema_prevision], [seguro_escolar_privado], [nacionalidad], [etnia], [consultorio_clinica], [observaciones_medicas], [estado], [establecimiento_id], [curso_id], [es_pie]) VALUES (N'9396369-5', N'Daniel ', N'Millar', N'Muñoz', 4, CAST(N'2024-06-08' AS Date), CAST(N'2024-05-23' AS Date), N'CHILENA', N'masculino', N'Los Alamos 779 Hualpén, Hualpén', N'Hualpén', N'danimu@info.cl', N'933114267', N'966776655', N'Comercial de Hualpén', N'Marcela Soto', N'955667766', N'AMBOS PADRES', 2, N'Johrei', 1, N'Chile solidario', 165, CAST(73.00 AS Decimal(5, 2)), N'AB +', N'no tiene', N'no tiene', N'no tiene', N'OTROS', 1, 2, 0, CAST(N'2024-05-31' AS Date), 1, N'Fonasa', 0, N'CHILENA', N'COLLA', N'consultorio', N'aplica. ', 1, 4706, 1, 0)
GO
SET IDENTITY_INSERT [dbo].[historial_estudiante] ON 

INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1, N'48938092-7', N'jairo', N'Valenzuela', N'Soto', 1, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-16' AS Date), CAST(N'2024-05-26' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (2, N'9396369-5', N'Daniel ', N'Millar', N'Muñoz', 4, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-06-09' AS Date), CAST(N'2024-05-24' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (3, N'48938092-7', N'jairo', N'Valenzuela', N'Soto', 1, N'SEGUNDO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-13' AS Date), CAST(N'2024-05-23' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (4, N'9396369-5', N'Daniel ', N'Millar', N'Muñoz', 4, N'PRIMERO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-06-08' AS Date), CAST(N'2024-05-23' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (5, N'48938092-7', N'jairo', N'Valenzuela', N'Soto', 1, N'PRIMERO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-12' AS Date), CAST(N'2024-05-22' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (6, N'3399584-9', N'Pablo luis', N'Saez', N'Pereira', 1, N'PRIMERO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-06-16' AS Date), CAST(N'2024-05-27' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (7, N'3768057-5', N'Ivan', N'Zamora', N'Zamorano', 1, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-16' AS Date), CAST(N'2024-06-04' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (8, N'56449023-7', N'Francisco', N'Reyes', N'Mieres', 1, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-16' AS Date), CAST(N'1995-06-04' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (10, N'19827133-0', N'Eugenio', N'Reyes', N'Conejero', 1309, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-06-17' AS Date), CAST(N'2024-05-27' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (11, N'19827133-0', N'Eugenio', N'Reyes', N'Conejero', 1309, N'SEGUNDO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-06-16' AS Date), CAST(N'2024-05-26' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1002, N'10754406-2', N'Matilde Sofía', N'Fernandez', N'Opazo', 1, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-11' AS Date), CAST(N'2024-06-03' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1004, N'2161373-8', N'Samanta Javiera', N'Durán', N'Montecinos', 21, N'PRIMERO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-07-06' AS Date), CAST(N'2005-05-09' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1005, N'7564781-6', N'Martin', N'Reyes', N'Soto', 24, N'SEGUNDO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-07-07' AS Date), CAST(N'2008-07-07' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1006, N'14967096-3', N'Pedro Juan', N'Maldonado', N'Soria', 27, N'SEGUNDO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-07-07' AS Date), CAST(N'2005-10-09' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1007, N'3768057-5', N'Ivan', N'Zamora', N'Zamorano', 1, N'SEGUNDO B(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'Estudiante PIE', CAST(N'2024-06-15' AS Date), CAST(N'2024-06-03' AS Date), N'')
INSERT [dbo].[historial_estudiante] ([id_historial], [id_estudiante], [nombre], [apaterno], [amaterno], [numero_matricula], [curso], [establecimiento], [es_pie], [fecha_matricula], [fecha_nacimiento], [hoja_de_vida]) VALUES (1008, N'3039080-6', N'pedro alberto', N'reyes', N'soto', 19, N'PRIMERO A(Media - Rama Comercial y Técnica)', N'
LICEO TÉCNICO PROFESIONAL PEDRO DEL RÍO ZAÑARTU', N'No aplica', CAST(N'2024-07-08' AS Date), CAST(N'2005-10-09' AS Date), N'')
SET IDENTITY_INSERT [dbo].[historial_estudiante] OFF
GO
SET IDENTITY_INSERT [dbo].[hoja_de_vida] ON 

INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1, CAST(N'2024-06-15' AS Date), N'FALTA', N'Historia', N'No hizo su tarea. cambio.', NULL, N'17861759-1', N'10754406-2')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (2, CAST(N'2023-06-13' AS Date), N'RECONOCIMIENTO', N'Matemáticas', N'fue un buen estudiante y ayudo al profesor.', NULL, N'17861759-1', N'10754406-2')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (7, CAST(N'2024-06-13' AS Date), N'RECONOCIMIENTO', N'Historia', N'prueba 6 cambio2', N'1718431504123_Listado epub distopía.pdf.pdf', N'17861759-1', N'9396369-5')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (8, CAST(N'2024-06-15' AS Date), N'RECONOCIMIENTO', N'Matemáticas', N'prueba vacio 6', NULL, N'17861759-1', N'7528007-6')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (9, CAST(N'2024-06-15' AS Date), N'RECONOCIMIENTO', N'Matemáticas', N'prueba 7 con archivo', N'1718424550609_prueba.pdf.pdf', N'17861759-1', N'7528007-6')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (10, CAST(N'2022-06-14' AS Date), N'RECONOCIMIENTO', N'Inglés', N'vfdgbcfbcv fvbcvbcvbc', N'1718511157668_1718431504123_Listado epub distopía.pdf.pdf.pdf', N'17861759-1', N'7528007-6')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (11, CAST(N'2024-06-16' AS Date), N'RECONOCIMIENTO', N'Inglés', N'Muy participativo en clases.', NULL, N'17861759-1', N'48938092-7')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (12, CAST(N'2024-06-15' AS Date), N'RECONOCIMIENTO', N'Inglés', N'El alumno fue sorprendido, lanzando papel por la ventana a la gente de la calle.', N'1718598552360_1718424417180_prueba.pdf (2).pdf.pdf', N'17861759-1', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (14, CAST(N'2024-06-17' AS Date), N'RECONOCIMIENTO', N'Matemáticas', N'prueba', N'1718638990217_1718424417180_prueba.pdf (2).pdf.pdf', N'17861759-1', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1011, CAST(N'2024-06-21' AS Date), N'FALTA', N'Matemáticas', N'prueba.', NULL, N'17861759-1', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1012, CAST(N'2024-07-06' AS Date), N'FALTA', N'Matemáticas', N'cometio una falta', NULL, N'25415405-9', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1013, CAST(N'2024-07-06' AS Date), N'FALTA LEVE', N'Matemáticas', N'falta leve', NULL, N'25415405-9', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1014, CAST(N'2024-07-06' AS Date), N'FALTA GRAVE', N'Inglés', N'falta grave en inglés', NULL, N'25415405-9', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1015, CAST(N'2024-07-06' AS Date), N'FALTA GRAVÍSIMA', N'Artes visuales', N'Falta muy grave en artes', NULL, N'25415405-9', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1016, CAST(N'2024-07-06' AS Date), N'FALTA', N'Matemáticas', N'falta', NULL, N'25415405-9', N'19827133-0')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1017, CAST(N'2024-07-06' AS Date), N'FALTA', N'Matemáticas', N'falta por no llevar la taréa', NULL, N'25415405-9', N'3768057-5')
INSERT [dbo].[hoja_de_vida] ([id_hoja_de_vida], [fecha], [tipo_evento], [asignatura], [detalle], [archivo], [usuario_id], [estudiante_id]) VALUES (1018, CAST(N'2024-07-08' AS Date), N'FALTA', N'Matemáticas', N'se porto mal.', NULL, N'17861759-1', N'25679175-7')
SET IDENTITY_INSERT [dbo].[hoja_de_vida] OFF
GO
SET IDENTITY_INSERT [dbo].[programa_integracion] ON 

INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1, N'7528007-6', 0, N'Transitorio', N'TDH.')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (2, N'10754406-2', 1, N'Permanente', N'Aquí va el diagnostico traspasado de la información del informe médico pero mayormente resumido.')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (3, N'10754406-2', 0, N'Transitorio', N'')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (4, N'10754406-2', 0, N'Transitorio', N'')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (5, N'48938092-7', 1, N'Permanente', N'Tiene TDA.')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (6, N'56449023-7', 1, N'Transitorio', N'Tiene TDA.')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1103, N'33489746-k', 0, N'PERMANENTE', N'no aplica')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1104, N'33770255-4', 0, N'Transitorio', N'no aplica')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1107, N'1006959-9', 1, N'PERMANENTE', N'no aplica')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1108, N'15438925-3', 0, N'Transitorio', N'no aplica')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1109, N'38692036-2', 1, N'PERMANENTE', N'no aplica')
INSERT [dbo].[programa_integracion] ([id_Programa], [estudiante_id], [permanencia_pie], [tipo_permanencia], [indicaciones_generales]) VALUES (1110, N'25679175-7', 0, N'Transitorio', N'no aplica')
SET IDENTITY_INSERT [dbo].[programa_integracion] OFF
GO
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([id_rol], [nombre], [descripcion]) VALUES (1, N'ADMIN', N'acceso total al colegio')
INSERT [dbo].[roles] ([id_rol], [nombre], [descripcion]) VALUES (2, N'USER', N'acceso parcial al colegio')
INSERT [dbo].[roles] ([id_rol], [nombre], [descripcion]) VALUES (3, N'SUPERADMIN', N'acceso total a la aplicación')
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
INSERT [dbo].[usuarios] ([rut_usuario], [pass], [nombre], [apaterno], [amaterno], [correo], [telefono], [fecha_nacimiento], [genero], [estudios], [cargo], [establecimiento_id], [rol_id]) VALUES (N'17861759-1', N'$2a$12$rCNWFENcPOn88HWGWFHShOO/beatlAjDrmlZgubfgX64bPysPPJfe', N'Jordan Johani', N'Escobar', N'Soto', N'jordanescosoto@gmail.com', N'933114267', CAST(N'1990-12-25' AS Date), N'masculino', N'PROFESIONAL INCOMPLETA', N'Encargado de informática', 4706, 1)
INSERT [dbo].[usuarios] ([rut_usuario], [pass], [nombre], [apaterno], [amaterno], [correo], [telefono], [fecha_nacimiento], [genero], [estudios], [cargo], [establecimiento_id], [rol_id]) VALUES (N'19827133-0', N'$2a$12$No4m/AVRdzi2Ab5rw7t7Euxxt/RGiDKyAsqpnyQPecWTgzCsHJ53K', N'Laura', N'Valenzuela', N'Bouniot', N'laura@gmail.com', N'933114267', CAST(N'1998-07-05' AS Date), N'femenino', N'PROFESIONAL INCOMPLETA', N'Docente', 4722, 2)
INSERT [dbo].[usuarios] ([rut_usuario], [pass], [nombre], [apaterno], [amaterno], [correo], [telefono], [fecha_nacimiento], [genero], [estudios], [cargo], [establecimiento_id], [rol_id]) VALUES (N'25415405-9', N'$2a$12$b99argMz3ghbkruv/BoqI.mQKhvs8XYZx/x04WD61iKbP6rLq6ZG.', N'Mauricio', N'Mieres', N'Mieres', N'mieres@gmail.com', N'933114267', CAST(N'1995-05-27' AS Date), N'masculino', N'PROFESIONAL INCOMPLETA', N'Encargado de informática', 4706, 3)
INSERT [dbo].[usuarios] ([rut_usuario], [pass], [nombre], [apaterno], [amaterno], [correo], [telefono], [fecha_nacimiento], [genero], [estudios], [cargo], [establecimiento_id], [rol_id]) VALUES (N'3729209-5', N'$2a$12$6.VsO754B/37bH0jVGpoD.N.nJGQrBV7WETb9lS1l9JSIbaqzPqCu', N'Martin', N'Reyes', N'Reyes', N'mreyes@gmail.com', N'933114267', CAST(N'1994-05-26' AS Date), N'masculino', N'PROFESIONAL INCOMPLETA', N'Encargado de informática', 4706, 1)
INSERT [dbo].[usuarios] ([rut_usuario], [pass], [nombre], [apaterno], [amaterno], [correo], [telefono], [fecha_nacimiento], [genero], [estudios], [cargo], [establecimiento_id], [rol_id]) VALUES (N'5713680-4', N'$2a$12$G.9ytaIVhFcmBHHJKexDQObD2opDJhI0MNgnMLtv.GAaP7kojGfTO', N'Alfonso Marcos', N'Pedrerol', N'Morelios', N'alfonsope@gmail.com', N'988445566', CAST(N'2024-06-13' AS Date), N'masculino', N'PROFESIONAL COMPLETA', N'Encargado de informática', 4722, 1)
GO
ALTER TABLE [dbo].[apoderados]  WITH CHECK ADD  CONSTRAINT [FK__apoderado__estud__4222D4EF] FOREIGN KEY([estudiante_id])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[apoderados] CHECK CONSTRAINT [FK__apoderado__estud__4222D4EF]
GO
ALTER TABLE [dbo].[asignaturas]  WITH CHECK ADD  CONSTRAINT [FK_asignatura_profesor] FOREIGN KEY([profesor_id])
REFERENCES [dbo].[usuarios] ([rut_usuario])
GO
ALTER TABLE [dbo].[asignaturas] CHECK CONSTRAINT [FK_asignatura_profesor]
GO
ALTER TABLE [dbo].[asignaturas]  WITH CHECK ADD  CONSTRAINT [FK_curso_asignatura] FOREIGN KEY([curso_id])
REFERENCES [dbo].[cursos] ([id_curso])
GO
ALTER TABLE [dbo].[asignaturas] CHECK CONSTRAINT [FK_curso_asignatura]
GO
ALTER TABLE [dbo].[asistencias]  WITH CHECK ADD  CONSTRAINT [FK_curso_asistencia] FOREIGN KEY([curso_id])
REFERENCES [dbo].[cursos] ([id_curso])
GO
ALTER TABLE [dbo].[asistencias] CHECK CONSTRAINT [FK_curso_asistencia]
GO
ALTER TABLE [dbo].[asistencias]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_asistencia] FOREIGN KEY([estudiante_id])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[asistencias] CHECK CONSTRAINT [FK_estudiante_asistencia]
GO
ALTER TABLE [dbo].[cursos]  WITH CHECK ADD  CONSTRAINT [FK__cursos__establec__403A8C7D] FOREIGN KEY([establecimiento_id])
REFERENCES [dbo].[establecimientos] ([rbd])
GO
ALTER TABLE [dbo].[cursos] CHECK CONSTRAINT [FK__cursos__establec__403A8C7D]
GO
ALTER TABLE [dbo].[estudiantes]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_establecimiento] FOREIGN KEY([establecimiento_id])
REFERENCES [dbo].[establecimientos] ([rbd])
GO
ALTER TABLE [dbo].[estudiantes] CHECK CONSTRAINT [FK_estudiante_establecimiento]
GO
ALTER TABLE [dbo].[estudiantes]  WITH CHECK ADD  CONSTRAINT [FK_estudiantes_curso] FOREIGN KEY([curso_id])
REFERENCES [dbo].[cursos] ([id_curso])
GO
ALTER TABLE [dbo].[estudiantes] CHECK CONSTRAINT [FK_estudiantes_curso]
GO
ALTER TABLE [dbo].[historial_estudiante]  WITH CHECK ADD  CONSTRAINT [FK_historial_estudiante] FOREIGN KEY([id_estudiante])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[historial_estudiante] CHECK CONSTRAINT [FK_historial_estudiante]
GO
ALTER TABLE [dbo].[hoja_de_vida]  WITH CHECK ADD  CONSTRAINT [FK_usuario_hoja_vida] FOREIGN KEY([estudiante_id])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[hoja_de_vida] CHECK CONSTRAINT [FK_usuario_hoja_vida]
GO
ALTER TABLE [dbo].[notas]  WITH CHECK ADD  CONSTRAINT [FK_asginatura_notas] FOREIGN KEY([id_asignatura])
REFERENCES [dbo].[asignaturas] ([id_asignatura])
GO
ALTER TABLE [dbo].[notas] CHECK CONSTRAINT [FK_asginatura_notas]
GO
ALTER TABLE [dbo].[notas]  WITH CHECK ADD  CONSTRAINT [FK_estudiante_notas] FOREIGN KEY([id_estudiante])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[notas] CHECK CONSTRAINT [FK_estudiante_notas]
GO
ALTER TABLE [dbo].[programa_integracion]  WITH CHECK ADD  CONSTRAINT [FK__programa___estud__3E52440B] FOREIGN KEY([estudiante_id])
REFERENCES [dbo].[estudiantes] ([run_estudiante])
GO
ALTER TABLE [dbo].[programa_integracion] CHECK CONSTRAINT [FK__programa___estud__3E52440B]
GO
ALTER TABLE [dbo].[usuarios]  WITH CHECK ADD  CONSTRAINT [FK_usuarios_roles] FOREIGN KEY([rol_id])
REFERENCES [dbo].[roles] ([id_rol])
GO
ALTER TABLE [dbo].[usuarios] CHECK CONSTRAINT [FK_usuarios_roles]
GO
USE [master]
GO
ALTER DATABASE [daem_hualpen] SET  READ_WRITE 
GO
