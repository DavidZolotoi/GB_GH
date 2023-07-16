/*--  Задание 1  --*/
-- Создайте функцию, которая принимает количество секунд и форматирует их в количество дней, часов, минут и секунд.
CREATE OR REPLACE FUNCTION format_seconds(seconds INT)
RETURNS VARCHAR AS $$
	DECLARE
    	days INT;
    	hours INT;
    	minutes INT;
	BEGIN
    	days := seconds / 86400;  -- 86400 секунд в одном дне
    	seconds := seconds % 86400;
    
    	hours := seconds / 3600;  -- 3600 секунд в одном часе
    	seconds := seconds % 3600;
    
    	minutes := seconds / 60;  -- 60 секунд в одной минуте
    	seconds := seconds % 60;
    
    	RETURN days || ' дней ' || hours || ' часов ' || minutes || ' минут ' || seconds || ' секунд';
	END;
$$ LANGUAGE plpgsql;

SELECT format_seconds(7777777);

/*--  Задание 2  --*/
-- Выведите только четные числа от 1 до 10 (Через цикл).
CREATE OR REPLACE FUNCTION get_even_numbers(start_pos INT, end_pos INT)
RETURNS VARCHAR AS $$
	DECLARE
    	result_text VARCHAR := '';
	BEGIN
    	FOR i IN start_pos..end_pos LOOP
        	IF i % 2 = 0 THEN
            	result_text := result_text || ' ' || i;
        	END IF;
    	END LOOP;
    	return result_text;
	END;
$$ LANGUAGE plpgsql;

SELECT get_even_numbers(1, 10);