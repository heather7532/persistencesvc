DROP TABLE IF EXISTS cadata.outbox;
DROP TABLE IF EXISTS cadata.repadm;
DROP TABLE IF EXISTS cadata.unallocated_sn;
DROP TABLE IF EXISTS cadata.assigned_sn;
DROP SCHEMA IF EXISTS cadata;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- SCHEMA: cadata
CREATE SCHEMA cadata
    AUTHORIZATION postgres;


CREATE TABLE cadata.outbox
(
    id uuid NOT NULL,
    topic_name character varying(256),
    database character varying(256),
    schema character varying(256),
    created_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    content json,
    CONSTRAINT outbox_pkey PRIMARY KEY (id)
);

CREATE TABLE cadata.repadm
(
    id uuid NOT NULL,
    location character varying(32),
    topic_type character varying(32),
    topic_name character varying(256),
    topic_conn_info json,
    created_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    modified_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT repadm_pkey PRIMARY KEY (id)
);

CREATE TABLE cadata.unallocated_sn
(
    id uuid NOT NULL,
    rid bytea,
    ca_pkidx bytea,
    range_start int,
    range_end int,
    alloc_size int,
    realloc_level int,
    created_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    modified_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unallocated_sn_pkey PRIMARY KEY (id)
);

CREATE TABLE cadata.assigned_sn
(
    id uuid NOT NULL,
    location character varying(32),
    rid bytea,
    ca_pkidx bytea,
    range_start int,
    range_end int,
    last_sn int,
    created_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    modified_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT assigned_sn_pkey PRIMARY KEY (id)
);

INSERT INTO cadata.unallocated_sn
( id, rid, ca_pkidx, range_start, range_end, alloc_size, realloc_level)
VALUES ( uuid_generate_v4(), 'A000000005', '05', 1,  16777216, 10000, 100);