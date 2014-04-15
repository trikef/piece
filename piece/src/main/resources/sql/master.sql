INSERT INTO user_info (name) VALUES ('autoinfo');--自動返信用

INSERT INTO piece (id,project_id,user_id,title,description,goal) VALUES(0,0,0,'PROJECT','-','-');

--INSERT INTO project (user_id,title,description,goal) 
--SELECT id,'マイプロジェクト','あなた専用のプロジェクトです。非公開設定にしてあるのでご自由にChatでメモをしたり、Taskでちょっとした用事などのToDo管理に使ってください','使い勝手が悪ければ「灯」プロジェクトにご連絡ください。改善しますよー' FROM user_info;

--INSERT INTO group_member (user_id,project_id,piece_id) 
--SELECT user_id,id, 0 FROM project WHERE title='マイプロジェクト';

--INSERT INTO chat (project_id,piece_id,user_id,text) 
--SELECT id,0,user_id,'あなた専用のプロジェクトです。非公開設定にしてあるのでご自由にChatでメモをしたり、Taskでちょっとした用事などのToDo管理に使ってください' FROM project WHERE title='マイプロジェクト';