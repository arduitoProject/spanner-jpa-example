# spanner-jpa-example
This project is modify to expose a exception


In your spanner db create:

CREATE TABLE employee (
	employee_id STRING(MAX) NOT NULL,
	lastname STRING(MAX) NOT NULL,
	name STRING(MAX) NOT NULL,
) PRIMARY KEY (employee_id)


CREATE TABLE phone (
	phone_id STRING(MAX) NOT NULL,
	nro_tel INT64,
) PRIMARY KEY (phone_id)


CREATE TABLE emp_phone (
	employee_id STRING(MAX) NOT NULL,
	phone_id STRING(MAX) NOT NULL,
) PRIMARY KEY (employee_id, phone_id)


