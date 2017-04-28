
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (1,'IN', 'INDIA');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (2,'UK', 'UK');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (3,'US', 'United States of America');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (4,'AU', 'Australia');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (5,'DE', 'Germany');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (6,'BE', 'Belgium');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (7,'FR', 'France');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (8,'CH', 'Switzerland');
INSERT INTO COUNTRY (ID,COUNTRY_ISO, COUNTRY_NAME)  VALUES (9,'NL', 'Netherlands')

insert into policy (ID, active, category, policy_name, version, policy_id) values (1,'TRUE', 'Data Protection', 'Data protection policy', '1.0', 1);
insert into policy (ID,active, category, policy_name, version, policy_id) values (2,'TRUE', 'Insider Trading', 'Shared dealing policy', '2.0', 2);
insert into policy (ID,active, category, policy_name, version, policy_id) values (3,'TRUE', 'Insider Trading', 'Financial secrets policy', '1.0', 3);
insert into policy (ID,active, category, policy_name, version, policy_id) values (4,'TRUE', 'Money Laundering', 'No Betting policy', '1.0', 4);
insert into policy (ID,active, category, policy_name, version, policy_id) values (5,'TRUE', 'Money Laundering', 'Remittance policy', '1.0', 5);
insert into policy (ID,active, category, policy_name, version, policy_id) values (6,'TRUE', 'Human Rights', 'Equality policy', '1.0', 6);

insert into country_policy (COUNTRY_ISO, policy_id) values ('IN', 1);
insert into country_policy (COUNTRY_ISO, policy_id) values ('UK', 5);
insert into country_policy (COUNTRY_ISO, policy_id) values ('IN', 2);
insert into country_policy (COUNTRY_ISO, policy_id) values ('AU', 3);
insert into country_policy (COUNTRY_ISO, policy_id) values ('BE', 4);
insert into country_policy (COUNTRY_ISO, policy_id) values ('UK', 6);