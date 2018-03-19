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
	phone_order INT64 NOT NULL,
) PRIMARY KEY (employee_id, phone_id)


The exception generated is
Caused by: nl.topicus.jdbc.shaded.io.grpc.StatusRuntimeException: INVALID_ARGUMENT: No parameter found for binding: p1
	at nl.topicus.jdbc.shaded.io.grpc.Status.asRuntimeException(Status.java:526) ~[spanner-jdbc-0.25.jar:na]
	... 19 common frames omitted



-------------------------------------------------------------------------------------------------------------


=================this exception was fixed in 			
<groupId>nl.topicus</groupId>
<artifactId>spanner-jdbc</artifactId>
<version>0.25</version>


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



Exception: StatusRuntimeException
Caused by: nl.topicus.jdbc.shaded.io.grpc.StatusRuntimeException: INVALID_ARGUMENT: No matching signature for operator = for argument types: STRING, BOOL. Supported signature: ANY = ANY [at 1:81]
...emp_phone`.`PHONE_ID` FROM `emp_phone` WHERE employee_id = @p1
                                                ^
	at nl.topicus.jdbc.shaded.io.grpc.Status.asRuntimeException(Status.java:543) ~[spanner-jdbc-0.22.jar:na]
	... 15 common frames omitted



=================this exception was fixed in 			
<groupId>nl.topicus</groupId>
<artifactId>spanner-jdbc</artifactId>
<version>0.25</version>





----------------------------------------------------------------------------

