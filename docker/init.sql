CREATE DATABASE testdb;
USE testdb;

CREATE TABLE Categories (
      Id int NOT NULL AUTO_INCREMENT,
      Name varchar(255),
      PRIMARY KEY (Id)
);

CREATE TABLE Links (
      Id int NOT NULL AUTO_INCREMENT,
      CategoryId int,
      Name varchar(255),
      Url varchar(255),
      PRIMARY KEY (Id),
      CONSTRAINT FK_CATEGORIES FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
);

INSERT INTO Categories
(
  Id,
  Name
)
VALUES
(
  1,
  'IT-News'
);

INSERT INTO Categories
(
  Id,
  Name
)
VALUES
(
  2,
  'IT-Systems'
);

INSERT INTO Categories
(
  Id,
  Name
)
VALUES
(
  3,
  'Blogs'
);

INSERT INTO Categories
(
  Id,
  Name
)
VALUES
(
  4,
  'General News'
);




INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  1,
  1,
  'Heise.de',
  'https://heise.de'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  2,
  1,
  'Golem.de',
  'https://Golem.de'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  3,
  2,
  'Wifi controller',
  'https://192.168.178.1'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  4,
  2,
  'Webserver',
  'https://192.168.178.2'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  5,
  3,
  'Windowsblog.at',
  'https://windowsblog.at'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  6,
  3,
  'faq-o-matic.net',
  'https://faq-o-matic.net'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  7,
  4,
  'Tagesschau.de',
  'https://tagesschau.de'
);

INSERT INTO Links
(
  Id,
  CategoryId,
  Name,
  Url
)
VALUES
(
  8,
  4,
  'n-tv.de',
  'https://n-tv.de'
);

