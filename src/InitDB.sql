DROP SCHEMA IF EXISTS module_1;

CREATE SCHEMA IF NOT EXISTS module_1;

alter table if exists developers_skills drop constraint developers_skills_developer_id_fkey;
alter table if exists developers_skills drop constraint developers_skills_skill_id_fkey;
alter table if exists projects drop constraint projects_project_customer_id_fkey;
alter table if exists projects drop constraint projects_project_company_id_fkey;
alter table if exists developers drop constraint developers_developer_company_id_fkey;
alter table if exists developers drop constraint developers_developer_project_id_fkey;

drop table if exists SKILLS;
drop table if exists CUSTOMERS;
drop table if exists COMPANIES;
drop table if exists PROJECTS;
drop table if exists DEVELOPERS;
drop table if exists DEVELOPERS_SKILLS;

create table SKILLS(
skill_id serial PRIMARY KEY NOT NULL,
skill_name character varying NOT NULL
);


create table CUSTOMERS(
customer_id serial PRIMARY KEY NOT NULL,
customer_name character varying NOT NULL
);



create table COMPANIES(
company_id serial PRIMARY KEY NOT NULL,
company_name character varying NOT NULL
);



create table PROJECTS(
project_id serial  PRIMARY KEY NOT NULL,
project_name character varying NOT NULL,
project_company_id integer references  COMPANIES(companie_id),
project_customer_id integer references CUSTOMERS(customer_id) NOT NULL,
project_start_timestamp date NOT NULL
);




create table DEVELOPERS(
developer_id serial PRIMARY KEY NOT NULL,
developer_name character varying NOT NULL,
developer_company_id integer references COMPANIES(companie_id) NOT NULL,
developer_project_id integer references PROJECTS (project_id) NOT NULL,
developer_join_date date
);



create table DEVELOPERS_SKILLS(
  developer_id integer references DEVELOPERS(developer_id) NOT NULL,
  skill_id  integer   references SKILLS(skill_id) NOT NULL
);