create table public.employee (
	empl_id bigint not null generated always as identity,
	empl_name varchar(100) not null,
	empl_job varchar(20) not null,
	empl_date_of_birth date not null,
	empl_date_of_hire date not null,
	empl_department varchar(20) not null,
	last_updated_by varchar(100) not null,
	last_updated_at date not null,
	constraint employee_pk primary key (empl_id)
);

create unique index employee_empl_id_idx on public.employee (empl_id);
