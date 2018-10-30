CREATE DATABASE travel_frog;

CREATE TABLE commodity
(
  id    int      NOT NULL AUTO_INCREMENT,
  name  varchar(255)     NOT NULL ,
  price decimal(8,2)  NOT NULL ,
  description  varchar(255),
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO commodity(id, name, price, description)
VALUES(1005, '野葡萄烤饼', 10, '吃完还有点饿');
INSERT INTO commodity(id, name, price, description)
VALUES(1006, '巨石三明治', 20, '蔬菜、快速轻食');
INSERT INTO commodity(id, name, price, description)
VALUES(1007, '南瓜百吉饼', 50, '份大量足，可以去很远的地方');
INSERT INTO commodity(id, name, price, description)
VALUES(1008, '乳蛋饼', 80, '想快点吃到拍，身心都轻快了，快速回家');