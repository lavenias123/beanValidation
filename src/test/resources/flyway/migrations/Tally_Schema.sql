-- Drop DB tallyCalCarbsDaily;

-- use tallyCalCarbsDaily;

Drop Table if Exists user_food;
Drop Table if Exists food;
Drop Table if Exists user_goals;
Drop Table if Exists users; 

create Table users (
	user_pk int unsigned NOT NULL auto_increment,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(60) NOT NULL,
	phone varchar(15) NOT NULL,
	PRIMARY KEY (user_pk)
);

create Table user_goals (
	goals_pk int unsigned NOT NULL,
	user_fk int unsigned NOT NULL,
	calorie_limit int unsigned NOT NULL,
	daily_calorie_total int unsigned NOT NULL,
	carbs_grams_limit int NOT NULL,
	FOREIGN KEY (user_fk) References users(user_pk) on delete cascade
);

create Table food (
	food_pk int unsigned NOT NULL auto_increment,
	food_name varchar(70) NOT NULL,
	carb_serving_grams int NULL,
	calories_per_serving int NULL,
	meal_type enum ('BREAKFAST', 'LUNCH', 'DINNER', 'SNACK_1', 'SNACK_2') NOT NULL,
	PRIMARY KEY (food_pk)
);

create Table user_food (
	
    user_fk int unsigned not null,
    food_fk int unsigned not null,
    FOREIGN KEY (user_fk) References users (user_pk) on delete cascade,
    FOREIGN KEY (food_fk) References food (food_pk) on delete cascade
 );      