
/*================== UUID Function Query ==================*/

CREATE OR REPLACE FUNCTION public.uuid_generate_v4()
  RETURNS uuid AS
'$libdir/uuid-ossp', 'uuid_generate_v4'
  LANGUAGE c VOLATILE STRICT
  COST 1;
ALTER FUNCTION public.uuid_generate_v4()
  OWNER TO postgres;


/*================== Sales Management Query ==================*/

CREATE TABLE public.users
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    full_name character varying(50) NOT NULL,
    designation character varying(50) NOT NULL,
    email character varying(50),
    phone_number character varying(25),
    address character varying(255),
    username character varying(50),
    password character varying(50),
    user_role character varying(50),
	photo_name character varying(25),
    photo_data bytea,
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE public.business_profile
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    compnay_name character varying(50) NOT NULL,
    company_email character varying(50) NOT NULL,
    company_phone_number character varying(25) NOT NULL,
    company_address character varying(255) NOT NULL,
    logo_name character varying(25),
    logo_data bytea,
    time_zone character varying(25),
    country character varying(25),
    date_format character varying(25),
    currency_format character varying(25),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_business_profile PRIMARY KEY (id)
);

CREATE TABLE public.customers
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    customer_name character varying(50) NOT NULL,
    customer_phone_number character varying(25) NOT NULL,
    customer_email character varying(50),
    customer_contact_person character varying(25),
    customer_discount double precision DEFAULT 0,
    customer_address character varying(255),
    customer_description character varying(255),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE public.products
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    product_name character varying(50) NOT NULL,
    product_code character varying(50) NOT NULL,
    product_quantity integer NOT NULL,
    product_price double precision DEFAULT 0,
    product_expire_date character varying(25),
    product_description character varying(255),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE public.purchases
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    product_name character varying(50) NOT NULL,
	product_id uuid,
    supplier_name character varying(50) NOT NULL,
	supplier_id uuid,
	purchase_product_quantity integer NOT NULL,
	purchase_product_price double precision DEFAULT 0,
    purchase_date character varying(25),
	purchase_amount double precision DEFAULT 0,
	purchase_payment double precision DEFAULT 0,
	purchase_balance double precision DEFAULT 0,
    purchase_description character varying(255),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_purchases PRIMARY KEY (id)
);

CREATE TABLE public.sales
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    product_name character varying(50) NOT NULL,
	product_id uuid,
    product_quantity integer NOT NULL,
    purchase_product_quantity integer,
	customer_name character varying(50) NOT NULL,
	customer_id uuid,
	sales_date character varying(25) NOT NULL,
	sales_discount double precision DEFAULT 0,
	sales_vat double precision DEFAULT 0,
	sales_amount double precision DEFAULT 0,
	sales_payment double precision DEFAULT 0,
	sales_balance double precision DEFAULT 0,
	sales_description character varying(255),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_sales PRIMARY KEY (id)
);

CREATE TABLE public.suppliers
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    supplier_name character varying(50) NOT NULL,
    supplier_company_name character varying(50),
    supplier_contact_person character varying(50),
    supplier_phone_number character varying(25) NOT NULL,
    supplier_address character varying(255),
    supplier_bank_name character varying(50),
    supplier_bank_account character varying(50),
    supplier_email character varying(50),
    supplier_website character varying(50),
    supplier_description character varying(255),
    created_by_id uuid,
    updated_by_id uuid,
    created_at timestamp without time zone,
    CONSTRAINT pk_suppliers PRIMARY KEY (id)
);

/*================== Employee Official Records ==================*/

CREATE TABLE public.hr_employee_educations
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    emp_code character varying(30) COLLATE pg_catalog."default" NOT NULL,
    emp_name character varying COLLATE pg_catalog."default" NOT NULL,
    company_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    company_name character varying COLLATE pg_catalog."default" NOT NULL,
    degree character varying(150) COLLATE pg_catalog."default",
    institution character varying COLLATE pg_catalog."default",
    passing_year character varying(25) COLLATE pg_catalog."default",
    result character varying(50) COLLATE pg_catalog."default",
    education_type character varying(50) COLLATE pg_catalog."default",
    edu_mgt character varying(50) COLLATE pg_catalog."default",
    institute character varying COLLATE pg_catalog."default",
    remark character varying COLLATE pg_catalog."default",
    client_code character varying COLLATE pg_catalog."default",
    client_name character varying COLLATE pg_catalog."default",
    created_by_code character varying COLLATE pg_catalog."default",
    created_by_name character varying COLLATE pg_catalog."default",
    created_by_username character varying COLLATE pg_catalog."default",
    created_by_email character varying COLLATE pg_catalog."default",
    created_by_company_name character varying COLLATE pg_catalog."default",
    created_by_company_code character varying COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    updated_by_code character varying COLLATE pg_catalog."default",
    updated_by_name character varying COLLATE pg_catalog."default",
    updated_by_username character varying COLLATE pg_catalog."default",
    updated_at timestamp without time zone,
    updated_by_company_code character varying(255) COLLATE pg_catalog."default",
    updated_by_company_name character varying(255) COLLATE pg_catalog."default",
    updated_by_email character varying(255) COLLATE pg_catalog."default",
    emp_id uuid,
    CONSTRAINT pk_hr_employee_educations PRIMARY KEY (id)
);

CREATE TABLE public.hr_employee_awards
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    emp_code character varying(30) COLLATE pg_catalog."default" NOT NULL,
    emp_name character varying COLLATE pg_catalog."default" NOT NULL,
    company_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    company_name character varying COLLATE pg_catalog."default" NOT NULL,
    award_name character varying(150) COLLATE pg_catalog."default",
    organization_name character varying COLLATE pg_catalog."default",
    achievement_date character varying(25) COLLATE pg_catalog."default",
    client_code character varying COLLATE pg_catalog."default",
    client_name character varying COLLATE pg_catalog."default",
    action_type_code character varying COLLATE pg_catalog."default",
    action_type_name character varying COLLATE pg_catalog."default",
    created_by_code character varying COLLATE pg_catalog."default",
    created_by_name character varying COLLATE pg_catalog."default",
    created_by_username character varying COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    created_by_email character varying COLLATE pg_catalog."default",
    created_by_company_name character varying COLLATE pg_catalog."default",
    created_by_company_code character varying COLLATE pg_catalog."default",
    updated_by_code character varying COLLATE pg_catalog."default",
    updated_by_name character varying COLLATE pg_catalog."default",
    updated_by_username character varying COLLATE pg_catalog."default",
    updated_at timestamp without time zone,
    updated_by_company_code character varying(255) COLLATE pg_catalog."default",
    updated_by_company_name character varying(255) COLLATE pg_catalog."default",
    updated_by_email character varying(255) COLLATE pg_catalog."default",
    emp_id uuid,
    CONSTRAINT pk_hr_employee_awards PRIMARY KEY (id)
);

CREATE TABLE public.hr_employee_experiences
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    emp_code character varying(30) COLLATE pg_catalog."default" NOT NULL,
    emp_name character varying COLLATE pg_catalog."default" NOT NULL,
    company_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    company_name character varying COLLATE pg_catalog."default" NOT NULL,
    orginations character varying(150) COLLATE pg_catalog."default",
    role character varying(200) COLLATE pg_catalog."default",
    start_date character varying(50) COLLATE pg_catalog."default",
    end_date character varying(50) COLLATE pg_catalog."default",
    duration character varying(50) COLLATE pg_catalog."default",
    remark character varying COLLATE pg_catalog."default",
    client_code character varying COLLATE pg_catalog."default",
    client_name character varying COLLATE pg_catalog."default",
    action_type_code character varying COLLATE pg_catalog."default",
    action_type_name character varying COLLATE pg_catalog."default",
    created_by_code character varying COLLATE pg_catalog."default",
    created_by_name character varying COLLATE pg_catalog."default",
    created_by_username character varying COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    created_by_email character varying COLLATE pg_catalog."default",
    created_by_company_name character varying COLLATE pg_catalog."default",
    created_by_company_code character varying COLLATE pg_catalog."default",
    updated_by_code character varying COLLATE pg_catalog."default",
    updated_by_name character varying COLLATE pg_catalog."default",
    updated_by_username character varying COLLATE pg_catalog."default",
    updated_at timestamp without time zone,
    updated_by_company_code character varying(255) COLLATE pg_catalog."default",
    updated_by_company_name character varying(255) COLLATE pg_catalog."default",
    updated_by_email character varying(255) COLLATE pg_catalog."default",
    emp_id uuid,
	CONSTRAINT pk_hr_employee_experiences PRIMARY KEY (id)
);


/*
ALTER TABLE tableName ADD COLUMN columnName dataType;
ALTER TABLE tableName DROP COLUMN columnName, ADD COLUMN columnName dataType;
*/

-------------------------------------------------------- Developed by Mustofa Kamal | www.facebook.com/hikamal
