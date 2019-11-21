SET client_encoding = 'UTF8';

drop table if exists "book_ratings";
drop table if exists "book_tags";
drop table if exists "book_comments";
drop table if exists "book_details";
drop table if exists "user_books";
drop table if exists "books";
drop table if exists "devices";
drop table if exists "users";

drop sequence if exists book_comments_id_seq;
drop sequence if exists book_details_id_seq;
drop sequence if exists book_ratings_id_seq;
drop sequence if exists book_tags_id_seq;
drop sequence if exists books_id_seq;
drop sequence if exists devices_id_seq;
drop sequence if exists users_id_seq;


CREATE TABLE public.book_comments (
    id bigint NOT NULL,
    content character varying(500),
    parent_id bigint,
    book_detail_id bigint NOT NULL,
    user_id bigint
);


CREATE SEQUENCE public.book_comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.book_comments_id_seq OWNED BY public.book_comments.id;



CREATE TABLE public.book_details (
    id bigint NOT NULL,
    description character varying(500),
    cover_url character varying,
    source integer,
    book_id bigint NOT NULL
);



CREATE SEQUENCE public.book_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.book_details_id_seq OWNED BY public.book_details.id;



CREATE TABLE public.book_ratings (
    id bigint NOT NULL,
    value integer,
    book_detail_id bigint NOT NULL,
    user_id bigint NOT NULL
);



CREATE SEQUENCE public.book_ratings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.book_ratings_id_seq OWNED BY public.book_ratings.id;



CREATE TABLE public.book_tags (
    id bigint NOT NULL,
    name character varying(255),
    book_detail_id bigint NOT NULL
);



CREATE SEQUENCE public.book_tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.book_tags_id_seq OWNED BY public.book_tags.id;


CREATE TABLE public.books (
    id bigint NOT NULL,
    author character varying(500),
    name character varying(500),
    serial_number character varying(255)
);



CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;



CREATE TABLE public.devices (
    id bigint NOT NULL,
    status character varying(255),
    token character varying(255),
    user_id bigint NOT NULL
);



CREATE SEQUENCE public.devices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.devices_id_seq OWNED BY public.devices.id;



CREATE TABLE public.user_books (
    user_id bigint NOT NULL,
    book_id bigint NOT NULL
);



CREATE TABLE public.users (
    id bigint NOT NULL,
    create_at timestamp without time zone,
    email character varying(255),
    full_name character varying(255),
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);



CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


ALTER TABLE ONLY public.book_comments ALTER COLUMN id SET DEFAULT nextval('public.book_comments_id_seq'::regclass);


ALTER TABLE ONLY public.book_details ALTER COLUMN id SET DEFAULT nextval('public.book_details_id_seq'::regclass);


ALTER TABLE ONLY public.book_ratings ALTER COLUMN id SET DEFAULT nextval('public.book_ratings_id_seq'::regclass);


ALTER TABLE ONLY public.book_tags ALTER COLUMN id SET DEFAULT nextval('public.book_tags_id_seq'::regclass);


ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


ALTER TABLE ONLY public.devices ALTER COLUMN id SET DEFAULT nextval('public.devices_id_seq'::regclass);



ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


ALTER TABLE ONLY public.book_comments
    ADD CONSTRAINT book_comments_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.book_details
    ADD CONSTRAINT book_details_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.book_ratings
    ADD CONSTRAINT book_ratings_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.book_tags
    ADD CONSTRAINT book_tags_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.book_comments
    ADD CONSTRAINT fk8b2kkv55i033vk6nahefaqabt FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.book_ratings
    ADD CONSTRAINT fk9jal0805u2bdtgc7jk68cv1ds FOREIGN KEY (user_id) REFERENCES public.users(id);


ALTER TABLE ONLY public.user_books
    ADD CONSTRAINT fka26s0po2ld5t5mi5sww9ca98 FOREIGN KEY (book_id) REFERENCES public.books(id);


ALTER TABLE ONLY public.book_ratings
    ADD CONSTRAINT fkmcveia1te2q2c7bws3gir2fx8 FOREIGN KEY (book_detail_id) REFERENCES public.book_details(id);

ALTER TABLE ONLY public.book_details
    ADD CONSTRAINT fkoa7sqrtgxwg066s9521udtvpv FOREIGN KEY (book_id) REFERENCES public.books(id);


ALTER TABLE ONLY public.devices
    ADD CONSTRAINT fkrfbri1ymrwywdydc4dgywe1bt FOREIGN KEY (user_id) REFERENCES public.users(id);


ALTER TABLE ONLY public.book_tags
    ADD CONSTRAINT fks96mdgag77synkmnghrpc4b9l FOREIGN KEY (book_detail_id) REFERENCES public.book_details(id);


ALTER TABLE ONLY public.user_books
    ADD CONSTRAINT fkseruwi8quqdx6svnurcamej55 FOREIGN KEY (user_id) REFERENCES public.users(id);


ALTER TABLE ONLY public.book_comments
    ADD CONSTRAINT fkskel1r3q2lqhjyeupd8gnms4n FOREIGN KEY (book_detail_id) REFERENCES public.book_details(id);

--
-- PostgreSQL database dump complete
--

