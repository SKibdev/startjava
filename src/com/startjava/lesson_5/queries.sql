\echo ¬ыводим всех роботов
SELECT *
  FROM jaegers
 ORDER BY model_name;

\echo ќтображаем не уничтоженных роботов
SELECT *
  FROM jaegers 
 WHERE status = 'Active'
 ORDER BY model_name;

\echo ќтображаем роботов серий: Mark-1 и Mark-4
SELECT * 
  FROM jaegers 
 WHERE mark IN (1, 4)
 ORDER BY model_name;

\echo ќтображаем всех роботов, кроме Mark-1 и Mark-4 
SELECT * 
  FROM jaegers 
 WHERE mark NOT IN (1, 4)
 ORDER BY mark DESC;

\echo ќтображаем информацию о самом старом роботе
SELECT * 
  FROM jaegers 
 WHERE launch = (SELECT MIN(launch)
                 FROM jaegers)
 ORDER BY model_name;

\echo ќтображаем роботов, которые уничтожили больше всех kaiju, 
SELECT * 
  FROM jaegers
 WHERE kaiju_kill = (SELECT MAX(kaiju_kill)
                       FROM jaegers)
 ORDER BY kaiju_kill DESC;

\echo ќтображаем средний вес роботов, округлив его до трех знаков после зап€той
SELECT ROUND (AVG(weight), 3) AS avg_weight
  FROM jaegers;

\echo  оличество уничтоженных kaiju у не разрушеных роботов увеличено на еденицу
UPDATE jaegers 
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = 'Active';

SELECT * 
  FROM jaegers
 ORDER BY model_name;

\echo ”ничтоженные роботы удалены
DELETE FROM jaegers
 WHERE status = 'Destroyed';

SELECT *
  FROM jaegers
 ORDER BY model_name;

