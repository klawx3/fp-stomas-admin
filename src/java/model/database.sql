DROP DATABASE IF EXISTS fpdb;
CREATE DATABASE fpdb;
USE fpdb;

CREATE TABLE institute( 
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    UNIQUE(name),
    PRIMARY KEY (id)
);

CREATE TABLE user_type(
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    priority INT,
    PRIMARY KEY (id),
    UNIQUE (name)
);


CREATE TABLE user (
    id INT AUTO_INCREMENT,
    fullname VARCHAR(100),
    rut VARCHAR(15),
    user_type_id_fk INT,
    finger_print BLOB,
    institute_fk INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_type_id_fk) REFERENCES user_type(id),
    FOREIGN KEY (institute_fk) REFERENCES institute(id),
    UNIQUE(rut)
);

-- INSERT Y TABLA DE ADMINISTRADOR

CREATE TABLE adminLogin(
id INT AUTO_INCREMENT,
user_name VARCHAR(100) UNIQUE,
password VARCHAR(40),
PRIMARY KEY (id)
);

select * from adminLogin;

INSERT INTO adminLogin VALUES(NULL,'admin',SHA1('123456'));
-- SELECT COUNT(id) FROM adminLogin WHERE user_name = 'admi' AND password = SHA1('123456');

-- UPDATE user SET fullname = 'X', rut = 'X' WHERE id = x
-- DELETE FROM usuario WHERE id = x

CREATE TABLE history (
    id INT AUTO_INCREMENT,
    user_id_fk INT,
    register_date DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id_fk) REFERENCES user(id)
);

-- UPDATE history SET register_date = 'X' WHERE id = x;
-- DELETE FROM history WHERE id = x;


INSERT INTO user_type VALUES(NULL,'Student',100);
INSERT INTO user_type VALUES(NULL,'Teacher',85);
INSERT INTO user_type VALUES(NULL,'Personnel',75);
INSERT INTO user_type VALUES(NULL,'Provider',50);
INSERT INTO user_type VALUES(NULL,'Admin',0);
INSERT INTO user_type VALUES(NULL,'Technician',25);


INSERT INTO institute VALUES(NULL,'Santo Tomas Rancagua');
INSERT INTO institute VALUES(NULL,'Antofagasta');
INSERT INTO institute VALUES(NULL,'Arica');
INSERT INTO institute VALUES(NULL,'Chillán');
INSERT INTO institute VALUES(NULL,'Concepción');
INSERT INTO institute VALUES(NULL,'Copiapó');
INSERT INTO institute VALUES(NULL,'Curicó');
INSERT INTO institute VALUES(NULL,'Iquique');
INSERT INTO institute VALUES(NULL,'La Serena');
INSERT INTO institute VALUES(NULL,'Los Ángeles');
INSERT INTO institute VALUES(NULL,'Osorno');
INSERT INTO institute VALUES(NULL,'Ovalle');
INSERT INTO institute VALUES(NULL,'Puente Alto');
INSERT INTO institute VALUES(NULL,'Puerto Montt');
INSERT INTO institute VALUES(NULL,'Punta Arenas');
INSERT INTO institute VALUES(NULL,'Rancagua');
INSERT INTO institute VALUES(NULL,'San Joaquín');
INSERT INTO institute VALUES(NULL,'Santiago Centro y Estación Central');
INSERT INTO institute VALUES(NULL,'Santiago UST');
INSERT INTO institute VALUES(NULL,'Talca');
INSERT INTO institute VALUES(NULL,'Temuco');
INSERT INTO institute VALUES(NULL,'Valdivia');
INSERT INTO institute VALUES(NULL,'Viña del Mar');

SELECT id, fullname, rut FROM user WHERE id = 1;

/*
DROP PROCEDURE IF EXISTS clone_user;

DELIMITER //
CREATE PROCEDURE clone_user(max_inserts INT, user_id_to_clone INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE j INT DEFAULT 0;
    DECLARE exist_user_id INT;

    -- User data
    DECLARE _id INT;
    DECLARE _fullname VARCHAR(100);
    DECLARE _rut VARCHAR(15);
    DECLARE _user_type_id_fk INT;
    DECLARE _finger_print BLOB;
    DECLARE _institute_fk INT;

    -- fill user data
    SET _fullname = (SELECT fullname FROM user WHERE id = user_id_to_clone);
    SET _rut = (SELECT rut FROM user WHERE id = user_id_to_clone);
    SET _user_type_id_fk = (SELECT user_type_id_fk FROM user WHERE id = user_id_to_clone);
    SET _finger_print = (SELECT finger_print FROM user WHERE id = user_id_to_clone);
    SET _institute_fk = (SELECT institute_fk FROM user WHERE id = user_id_to_clone);
    

    WHILE i < max_inserts DO
        INSERT INTO user VALUES(NULL,_fullname,_rut,_user_type_id_fk,_finger_print,_institute_fk);
        SET i = i + 1;
    END WHILE;

    SELECT CAST(i AS VARCHAR(4)) AS 't';


END; //
DELIMITER ;

CALL clone_user(20,1);



SELECT *
FROM history
INNER JOIN user
ON history.user_id_fk = user.id
WHERE history.register_date > DATE_SUB(CURDATE(), INTERVAL 1 DAY);

SELECT user.fullname, user.rut, user_type.id FROM history
INNER JOIN user ON user.id = history.user_id_fk
INNER JOIN user_type ON user.user_type_id_fk = user_type.id 
WHERE user.institute_fk = x
ORDER BY history.register_date ASC LIMIT x;


SELECT * FROM history 
WHERE register_date 
BETWEEN '2020-10-19 01:29' AND '2020-10-19 01:30'
SELECT user.fullname, user.rut, history.register_date FROM history
INNER JOIN user ON user.id = history.user_id_fk
*/

-- SELECT user.fullname, user.rut, history.register_date FROM history INNER JOIN user ON user.id = history.user_id_fk;
-- INSERT INTO user VALUES(NULL,'nombre1','11-1',1,0000001111111,1);
-- INSERT INTO user VALUES(NULL,'nombre2','22-2',1,0000001111111,1);
-- INSERT INTO user VALUES(NULL,'nombre3','33-3',1,0000001111111,1);
-- 
-- INSERT INTO history VALUES(NULL,1,NOW());
-- INSERT INTO history VALUES(NULL,2,NOW());
-- INSERT INTO history VALUES(NULL,3,NOW());

INSERT INTO history VALUES(NULL,5,NOW());
INSERT INTO user VALUES(NULL,'nombre5','55-5',2,0000001111111,1);

select * from history;



delete from history where id = 5;
delete from user where id = 5;

delete from user u inner join history h on h.user_id_fk = u.id where h.id = 4;

DELETE u
FROM user u 
INNER JOIN history h
    ON u.id = c.user_id_fk
WHERE c.user_id_fk = 4;
;