

-- Method 3 - SQL Server 2008+ Row Construction
INSERT INTO users (first_name, last_name, email, phone)
VALUES ('Dan', 'BoshDan', 'info@BoshDan.com', '213-666-4444'), 
		('Carol', 'Butters', 'sam@d1tm.org', '767-888-2323'), 
		('David', 'Biten', 'biten@district112.org', '213-666-3333'), 
		('Lisa', '.Twlight', 'sales@district113.org', '313-555-4444'), 
		('Randall', 'Bosher', 'info@BosherRandall.com', '313-555-4224'), 
		('Susan', 'Zutters', 'susan@d4tm.org', '713-222-6227'), 
		('Faid', 'Riddenzer', 'members@district142.org', '717-212-9227'), 
		('Cellesa', 'Dawne', 'recruitment@district163.org', '913-222-6233'), 
		('Jennifer', 'Daniels', 'hr@JenDaniels.com', '709-444-6228'), 
		('Sally', 'Walkers', 'sally@d133tm.org', '413-282-6887'), 
		('Dan', 'Givens', 'givens@district110.org', '703-202-6999'), 
		('Reese', 'Otter', 'otterR@district17.org', '718-522-6427')

;
-- select * from users;

-- Clean up
-- can't drop this table it's ref in user_goals
-- DROP TABLE users;