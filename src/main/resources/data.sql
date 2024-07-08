CREATE TABLE Tool_Type(
type varchar(64) NOT NULL,
daily_Charge numeric(8,2) NOT NULL,
is_WeekDay_Charge Boolean NOT NULL,
is_WeekEnd_Charge Boolean NOT NULL,
is_Holiday_Charge Boolean NOT NULL,
PRIMARY KEY(type));

CREATE TABLE Tool(
code varchar(64) NOT NULL,
tool_Type varchar(64) NOT NULL,
brand varchar(64) NOT NULL,
PRIMARY KEY(code),
FOREIGN KEY(tool_Type)
REFERENCES Tool_Type(type)
);

INSERT INTO Tool_Type(type,daily_Charge,is_WeekDay_Charge,is_WeekEnd_Charge,is_Holiday_Charge )
values('Chainsaw',1.49,true, false,true);
INSERT INTO Tool_Type(type,daily_Charge,is_WeekDay_Charge,is_WeekEnd_Charge,is_Holiday_Charge )
values('Ladder',1.99,true, false,true);
INSERT INTO Tool_Type(type,daily_Charge,is_WeekDay_Charge,is_WeekEnd_Charge,is_Holiday_Charge )
values('Jackhammer',2.99,true, false,true);

INSERT INTO Tool(code, tool_type, brand) values('CHNS', 'Chainsaw', 'Stihl');
INSERT INTO Tool(code, tool_type, brand)
values('LADW', 'Ladder', 'Werner');
INSERT INTO Tool(code, tool_type, brand)
values('JAKD', 'Jackhammer', 'DeWalt');
INSERT INTO Tool(code, tool_type, brand)
values('JAKR', 'Jackhammer', 'Ridgid');
