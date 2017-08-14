--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-08-14 02:56:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2124 (class 1262 OID 32768)
-- Name: contactholder; Type: DATABASE; Schema: -; Owner: postgres
--

--CREATE DATABASE contactholder WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE contactholder OWNER TO postgres;

\connect contactholder

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 32769)
-- Name: contacts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE contacts (
    name character varying,
    id bigint NOT NULL
);


ALTER TABLE contacts OWNER TO postgres;

--
-- TOC entry 2119 (class 0 OID 32769)
-- Dependencies: 185
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO contacts (name, id) VALUES ('a', 1);
INSERT INTO contacts (name, id) VALUES ('A', 2);
INSERT INTO contacts (name, id) VALUES ('ab', 3);
INSERT INTO contacts (name, id) VALUES ('ba', 4);
INSERT INTO contacts (name, id) VALUES ('AB', 5);
INSERT INTO contacts (name, id) VALUES ('BA', 6);
INSERT INTO contacts (name, id) VALUES ('Ab', 7);
INSERT INTO contacts (name, id) VALUES ('aB', 8);
INSERT INTO contacts (name, id) VALUES ('Ba', 9);
INSERT INTO contacts (name, id) VALUES ('bA', 10);
INSERT INTO contacts (name, id) VALUES ('lorem ipsum', 11);
INSERT INTO contacts (name, id) VALUES ('dolor sit amet', 12);
INSERT INTO contacts (name, id) VALUES ('Consectetur', 13);
INSERT INTO contacts (name, id) VALUES ('adipiscing elit', 14);
INSERT INTO contacts (name, id) VALUES ('sed do eiusmod', 15);
INSERT INTO contacts (name, id) VALUES (NULL, 16);
INSERT INTO contacts (name, id) VALUES ('', 17);
INSERT INTO contacts (name, id) VALUES (' ', 18);
INSERT INTO contacts (name, id) VALUES ('tempor incididunt ut labore et', 19);


--
-- TOC entry 2001 (class 2606 OID 32776)
-- Name: contacts contacts_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contacts
    ADD CONSTRAINT contacts_id_pk PRIMARY KEY (id);


-- Completed on 2017-08-14 02:56:26

--
-- PostgreSQL database dump complete
--

