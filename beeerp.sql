--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: wage_states; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE wage_states (
    id integer NOT NULL,
    weekly_wage integer NOT NULL,
    holliday_rate double precision NOT NULL,
    normal_week_time double precision NOT NULL
);


ALTER TABLE wage_states OWNER TO postgres;

--
-- Name: wage_states_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE wage_states_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE wage_states_id_seq OWNER TO postgres;

--
-- Name: wage_states_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE wage_states_id_seq OWNED BY wage_states.id;


--
-- Name: weekly_time; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE weekly_time (
    id integer NOT NULL,
    date date NOT NULL,
    "time" double precision NOT NULL,
    holliday_time_use double precision DEFAULT 0 NOT NULL,
    lost_overtime double precision DEFAULT 0 NOT NULL,
    sick_time double precision DEFAULT 0 NOT NULL
);


ALTER TABLE weekly_time OWNER TO postgres;

--
-- Name: weekly_time_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE weekly_time_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE weekly_time_id_seq OWNER TO postgres;

--
-- Name: weekly_time_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE weekly_time_id_seq OWNED BY weekly_time.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY wage_states ALTER COLUMN id SET DEFAULT nextval('wage_states_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY weekly_time ALTER COLUMN id SET DEFAULT nextval('weekly_time_id_seq'::regclass);


--
-- Data for Name: wage_states; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY wage_states (id, weekly_wage, holliday_rate, normal_week_time) FROM stdin;
\.


--
-- Name: wage_states_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('wage_states_id_seq', 1, false);


--
-- Data for Name: weekly_time; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY weekly_time (id, date, "time", holliday_time_use, lost_overtime, sick_time) FROM stdin;
3	2014-12-26	30	0	0	0
1	2014-12-29	2.39999999999999991	0	0	0
2	2014-12-26	7.25	0	0	0
263	2016-01-02	1	0	0	0
\.


--
-- Name: weekly_time_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('weekly_time_id_seq', 373, true);


--
-- Name: PK_wageStates_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY wage_states
    ADD CONSTRAINT "PK_wageStates_id" PRIMARY KEY (id);


--
-- Name: PK_weeklyTime_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY weekly_time
    ADD CONSTRAINT "PK_weeklyTime_id" PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

