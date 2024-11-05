CREATE DATABASE xuongthuchanh
GO
USE [xuongthuchanh]
GO
/****** Object:  Table [dbo].[brand]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[brand](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[brand_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[cate_code] [varchar](255) NOT NULL,
	[cate_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[origin_price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[sell_price] [float] NOT NULL,
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[status_id] [bigint] NULL,
	[subcate_id] [bigint] NULL,
	[color] [varchar](255) NOT NULL,
	[description] [varchar](255) NULL,
	[product_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_brand]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_brand](
	[brand_id] [bigint] NOT NULL,
	[product_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[brand_id] ASC,
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[status_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sub_category]    Script Date: 6/17/2024 2:18:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sub_category](
	[cate_id] [bigint] NULL,
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[sub_cate_code] [varchar](255) NOT NULL,
	[sub_cate_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK8556hocjcb04st51nt8yknfbg] FOREIGN KEY([status_id])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK8556hocjcb04st51nt8yknfbg]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FKirxcln8pingvfkgbvdwgsmien] FOREIGN KEY([subcate_id])
REFERENCES [dbo].[sub_category] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FKirxcln8pingvfkgbvdwgsmien]
GO
ALTER TABLE [dbo].[product_brand]  WITH CHECK ADD  CONSTRAINT [FK4ifks1l2dre6xgfenp6esphh5] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[product_brand] CHECK CONSTRAINT [FK4ifks1l2dre6xgfenp6esphh5]
GO
ALTER TABLE [dbo].[product_brand]  WITH CHECK ADD  CONSTRAINT [FKn3q2blfsr3x3olbkydrre5h1j] FOREIGN KEY([brand_id])
REFERENCES [dbo].[brand] ([id])
GO
ALTER TABLE [dbo].[product_brand] CHECK CONSTRAINT [FKn3q2blfsr3x3olbkydrre5h1j]
GO
ALTER TABLE [dbo].[sub_category]  WITH CHECK ADD  CONSTRAINT [FKlesuwl96jgbc9gey9eqsxgfo5] FOREIGN KEY([cate_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[sub_category] CHECK CONSTRAINT [FKlesuwl96jgbc9gey9eqsxgfo5]
GO
-- Insert into brand
INSERT INTO [dbo].[brand] (brand_name)
VALUES 
('Brand A'),
('Brand B'),
('Brand C'),
('Brand D'),
('Brand E');

-- Insert into category
INSERT INTO [dbo].[category] (cate_code, cate_name)
VALUES
('CAT001', 'Category 1'),
('CAT002', 'Category 2'),
('CAT003', 'Category 3'),
('CAT004', 'Category 4'),
('CAT005', 'Category 5');

-- Insert into sub_category
INSERT INTO [dbo].[sub_category] (cate_id, sub_cate_code, sub_cate_name)
VALUES
(1, 'SUBCAT001', 'Sub Category 1'),
(2, 'SUBCAT002', 'Sub Category 2'),
(3, 'SUBCAT003', 'Sub Category 3'),
(4, 'SUBCAT004', 'Sub Category 4'),
(5, 'SUBCAT005', 'Sub Category 5');

-- Insert into status
INSERT INTO [dbo].[status] (status_name)
VALUES
('Available'),
('Out of Stock'),
('Discontinued'),
('Backorder'),
('Preorder');

-- Insert into product
INSERT INTO [dbo].[product] (origin_price, quantity, sell_price, status_id, subcate_id, color, description, product_name)
VALUES
(100.00, 50, 120.00, 1, 1, 'Red', 'Product 1 description', 'Product 1'),
(200.00, 30, 240.00, 2, 2, 'Blue', 'Product 2 description', 'Product 2'),
(150.00, 40, 180.00, 3, 3, 'Green', 'Product 3 description', 'Product 3'),
(250.00, 20, 300.00, 4, 4, 'Yellow', 'Product 4 description', 'Product 4'),
(300.00, 10, 350.00, 5, 5, 'Black', 'Product 5 description', 'Product 5');

-- Insert into product_brand
INSERT INTO [dbo].[product_brand] (brand_id, product_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
