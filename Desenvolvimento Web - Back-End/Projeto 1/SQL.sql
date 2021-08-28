CREATE DATABASE projeto;
USE projeto;

CREATE TABLE IF NOT EXISTS videos (
 videos_id INT AUTO_INCREMENT PRIMARY KEY,
 uploader VARCHAR (50) NOT NULL,
 title VARCHAR (50) NOT NULL,
 description VARCHAR (50) NOT NULL,
 duration INT NOT NULL,
 url VARCHAR (50) NOT NULL,
 views INT NOT NULL,
 likes INT NOT NULL,
 dislikes INT NOT NULL,
 comments JSON NOT NULL,
 tags JSON NOT NULL
 );
 
INSERT INTO videos (uploader,title,description,duration,url,views,likes,dislikes,comments,tags) VALUES ('João', 'Charlie`s Angels', 'tendi', '3.50', 'a.com', '50', '50', '50', '{"1":"Es o maior"}', '{"1":"Action","2":"Music"}');
