--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0 (Debian 16.0-1.pgdg120+1)
-- Dumped by pg_dump version 16.1 (Debian 16.1-1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: annonce; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.annonce (
    idannonce integer NOT NULL,
    annee integer NOT NULL,
    description_annonce character varying(50),
    nombre_place integer NOT NULL,
    nombre_porte integer NOT NULL,
    puissance double precision NOT NULL,
    kilometrage numeric(25,2) NOT NULL,
    tarif numeric(25,2) NOT NULL,
    date_annonce date DEFAULT now(),
    temps_annonce time without time zone DEFAULT now(),
    etat integer DEFAULT 5 NOT NULL,
    idutilisateur integer NOT NULL,
    idcarburant integer NOT NULL,
    idcategorie_voiture integer NOT NULL,
    idmodele_voiture integer NOT NULL
);


ALTER TABLE public.annonce OWNER TO postgres;

--
-- Name: annonce_idannonce_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.annonce_idannonce_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.annonce_idannonce_seq OWNER TO postgres;

--
-- Name: annonce_idannonce_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.annonce_idannonce_seq OWNED BY public.annonce.idannonce;


--
-- Name: carburant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carburant (
    idcarburant integer NOT NULL,
    nom character varying(50) NOT NULL
);


ALTER TABLE public.carburant OWNER TO postgres;

--
-- Name: carburant_idcarburant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carburant_idcarburant_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.carburant_idcarburant_seq OWNER TO postgres;

--
-- Name: carburant_idcarburant_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carburant_idcarburant_seq OWNED BY public.carburant.idcarburant;


--
-- Name: categorie_voiture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie_voiture (
    idcategorie_voiture integer NOT NULL,
    nom character varying(50) NOT NULL
);


ALTER TABLE public.categorie_voiture OWNER TO postgres;

--
-- Name: categorie_voiture_idcategorie_voiture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_voiture_idcategorie_voiture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categorie_voiture_idcategorie_voiture_seq OWNER TO postgres;

--
-- Name: categorie_voiture_idcategorie_voiture_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorie_voiture_idcategorie_voiture_seq OWNED BY public.categorie_voiture.idcategorie_voiture;


--
-- Name: commission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commission (
    idcommission integer NOT NULL,
    min_tarif double precision NOT NULL,
    max_tarif double precision NOT NULL,
    pourcentage integer NOT NULL
);


ALTER TABLE public.commission OWNER TO postgres;

--
-- Name: commission_idcommission_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commission_idcommission_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.commission_idcommission_seq OWNER TO postgres;

--
-- Name: commission_idcommission_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commission_idcommission_seq OWNED BY public.commission.idcommission;


--
-- Name: commission_vente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commission_vente (
    idcommission_vente integer NOT NULL,
    idvente integer NOT NULL,
    valeur_comission double precision NOT NULL,
    statut integer NOT NULL
);


ALTER TABLE public.commission_vente OWNER TO postgres;

--
-- Name: commission_vente_idcommission_vente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commission_vente_idcommission_vente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.commission_vente_idcommission_vente_seq OWNER TO postgres;

--
-- Name: commission_vente_idcommission_vente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commission_vente_idcommission_vente_seq OWNED BY public.commission_vente.idcommission_vente;


--
-- Name: favori; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favori (
    idfavori integer NOT NULL,
    idutilisateur integer NOT NULL,
    idannonce integer NOT NULL
);


ALTER TABLE public.favori OWNER TO postgres;

--
-- Name: favori_idfavori_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.favori_idfavori_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.favori_idfavori_seq OWNER TO postgres;

--
-- Name: favori_idfavori_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.favori_idfavori_seq OWNED BY public.favori.idfavori;


--
-- Name: info_utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.info_utilisateur (
    idinfo_utilisateur integer NOT NULL,
    nom character varying(50),
    prenom character varying(50),
    contact character varying(50),
    adresse character varying(50),
    idutilisateur integer NOT NULL
);


ALTER TABLE public.info_utilisateur OWNER TO postgres;

--
-- Name: info_utilisateur_idinfo_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.info_utilisateur_idinfo_utilisateur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.info_utilisateur_idinfo_utilisateur_seq OWNER TO postgres;

--
-- Name: info_utilisateur_idinfo_utilisateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.info_utilisateur_idinfo_utilisateur_seq OWNED BY public.info_utilisateur.idinfo_utilisateur;


--
-- Name: marque_voiture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marque_voiture (
    idmarque_voiture integer NOT NULL,
    nom character varying(50) NOT NULL
);


ALTER TABLE public.marque_voiture OWNER TO postgres;

--
-- Name: marque_voiture_idmarque_voiture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marque_voiture_idmarque_voiture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.marque_voiture_idmarque_voiture_seq OWNER TO postgres;

--
-- Name: marque_voiture_idmarque_voiture_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marque_voiture_idmarque_voiture_seq OWNED BY public.marque_voiture.idmarque_voiture;


--
-- Name: modele_voiture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modele_voiture (
    idmodele_voiture integer NOT NULL,
    nom character varying(50) NOT NULL,
    idmarque_voiture integer NOT NULL
);


ALTER TABLE public.modele_voiture OWNER TO postgres;

--
-- Name: modele_voiture_idmodele_voiture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modele_voiture_idmodele_voiture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.modele_voiture_idmodele_voiture_seq OWNER TO postgres;

--
-- Name: modele_voiture_idmodele_voiture_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modele_voiture_idmodele_voiture_seq OWNED BY public.modele_voiture.idmodele_voiture;


--
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    id_photo integer NOT NULL,
    idannonce integer NOT NULL,
    url_photo character varying(255) NOT NULL
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- Name: photo_id_photo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.photo_id_photo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.photo_id_photo_seq OWNER TO postgres;

--
-- Name: photo_id_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.photo_id_photo_seq OWNED BY public.photo.id_photo;


--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    idrole integer NOT NULL,
    designation character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_idrole_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_idrole_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.role_idrole_seq OWNER TO postgres;

--
-- Name: role_idrole_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_idrole_seq OWNED BY public.role.idrole;


--
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    idutilisateur integer NOT NULL,
    email character varying(255),
    password character varying(255)
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- Name: utilisateur_idutilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_idutilisateur_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.utilisateur_idutilisateur_seq OWNER TO postgres;

--
-- Name: utilisateur_idutilisateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_idutilisateur_seq OWNED BY public.utilisateur.idutilisateur;


--
-- Name: utilisateur_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur_role (
    idutilisateur integer NOT NULL,
    idrole integer NOT NULL
);


ALTER TABLE public.utilisateur_role OWNER TO postgres;

--
-- Name: vente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vente (
    idvente integer NOT NULL,
    date_vente date DEFAULT now() NOT NULL,
    idannonce integer NOT NULL,
    idutilisateur integer NOT NULL
);


ALTER TABLE public.vente OWNER TO postgres;

--
-- Name: vente_idvente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vente_idvente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vente_idvente_seq OWNER TO postgres;

--
-- Name: vente_idvente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vente_idvente_seq OWNED BY public.vente.idvente;


--
-- Name: annonce idannonce; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce ALTER COLUMN idannonce SET DEFAULT nextval('public.annonce_idannonce_seq'::regclass);


--
-- Name: carburant idcarburant; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carburant ALTER COLUMN idcarburant SET DEFAULT nextval('public.carburant_idcarburant_seq'::regclass);


--
-- Name: categorie_voiture idcategorie_voiture; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_voiture ALTER COLUMN idcategorie_voiture SET DEFAULT nextval('public.categorie_voiture_idcategorie_voiture_seq'::regclass);


--
-- Name: commission idcommission; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission ALTER COLUMN idcommission SET DEFAULT nextval('public.commission_idcommission_seq'::regclass);


--
-- Name: commission_vente idcommission_vente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission_vente ALTER COLUMN idcommission_vente SET DEFAULT nextval('public.commission_vente_idcommission_vente_seq'::regclass);


--
-- Name: favori idfavori; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favori ALTER COLUMN idfavori SET DEFAULT nextval('public.favori_idfavori_seq'::regclass);


--
-- Name: info_utilisateur idinfo_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.info_utilisateur ALTER COLUMN idinfo_utilisateur SET DEFAULT nextval('public.info_utilisateur_idinfo_utilisateur_seq'::regclass);


--
-- Name: marque_voiture idmarque_voiture; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marque_voiture ALTER COLUMN idmarque_voiture SET DEFAULT nextval('public.marque_voiture_idmarque_voiture_seq'::regclass);


--
-- Name: modele_voiture idmodele_voiture; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modele_voiture ALTER COLUMN idmodele_voiture SET DEFAULT nextval('public.modele_voiture_idmodele_voiture_seq'::regclass);


--
-- Name: photo id_photo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo ALTER COLUMN id_photo SET DEFAULT nextval('public.photo_id_photo_seq'::regclass);


--
-- Name: role idrole; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN idrole SET DEFAULT nextval('public.role_idrole_seq'::regclass);


--
-- Name: utilisateur idutilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN idutilisateur SET DEFAULT nextval('public.utilisateur_idutilisateur_seq'::regclass);


--
-- Name: vente idvente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente ALTER COLUMN idvente SET DEFAULT nextval('public.vente_idvente_seq'::regclass);


--
-- Data for Name: annonce; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.annonce (idannonce, annee, description_annonce, nombre_place, nombre_porte, puissance, kilometrage, tarif, date_annonce, temps_annonce, etat, idutilisateur, idcarburant, idcategorie_voiture, idmodele_voiture) FROM stdin;
5	2004	RAS	9	4	0	1100.00	65000000.00	2024-01-29	09:12:44.418505	5	2	1	2	2
21	1999	Etat 4/10	7	4	0	521000.00	33000000.00	2024-01-29	19:12:16.099	10	3	2	3	3
25	2014	Etat 4/10	7	4	0	100000.00	550000000.00	2024-02-02	22:13:59.818	10	2	2	2	2
60	2018	Etat 3/10	7	4	0	100.00	99000000.00	2024-02-09	04:54:11.921	5	3	2	2	2
62	2018	Etat 3/10	7	4	0	100.00	99000000.00	2024-02-09	05:29:13.738	5	3	2	2	2
\.


--
-- Data for Name: carburant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carburant (idcarburant, nom) FROM stdin;
1	Sans plomb 95
2	Gasoil
3	Electricite
\.


--
-- Data for Name: categorie_voiture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorie_voiture (idcategorie_voiture, nom) FROM stdin;
1	SUV full-size
2	Pickup SUV
3	Familiale
4	Van
5	Coupe
6	Petite familiale
7	Cabriolet
8	Limousine
9	Autre
\.


--
-- Data for Name: commission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commission (idcommission, min_tarif, max_tarif, pourcentage) FROM stdin;
1	1000000	10000000	5
2	10000001	30000000	10
3	30000001	50000000	15
4	50000001	80000000	20
5	80000001	200000000	25
6	200000001	400000000	30
7	400000001	700000000	35
8	700000001	900000001	37
9	900000001	1000000000	40
\.


--
-- Data for Name: commission_vente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commission_vente (idcommission_vente, idvente, valeur_comission, statut) FROM stdin;
1	5	4950000	5
\.


--
-- Data for Name: favori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.favori (idfavori, idutilisateur, idannonce) FROM stdin;
1	3	5
2	2	21
\.


--
-- Data for Name: info_utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.info_utilisateur (idinfo_utilisateur, nom, prenom, contact, adresse, idutilisateur) FROM stdin;
1	RASOANAIVO	Liantsiky Malalariniaina	0326577909	IPP 49 Manjakatompo	1
2	RAMANANA	Miaro	0325642233	IPJ 17 A Andranonahoatra	3
3	RATOLOJA	Ny Aina Sababa	032754698	IPP 49 Ambohimiandra	4
4	JEAN LUX	Noums	0323333323	JPP Andoharanofotsy	5
\.


--
-- Data for Name: marque_voiture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marque_voiture (idmarque_voiture, nom) FROM stdin;
1	Nissan
2	Toyota
3	Ford
\.


--
-- Data for Name: modele_voiture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modele_voiture (idmodele_voiture, nom, idmarque_voiture) FROM stdin;
1	Patrol	1
2	Navara	1
3	Corolla Verso	2
4	Land Cruiser	2
5	Focus	3
6	Expedition	3
\.


--
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.photo (id_photo, idannonce, url_photo) FROM stdin;
3	25	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/8951666.jpg?alt=media
4	25	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/8951528.jpg?alt=media
16	60	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/windows-fluent-lines-4k-b2.jpg?alt=media
17	60	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/windows-11-dark-mode-blue-stock-official-2560x1440-5630.jpg?alt=media
18	62	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/windows-fluent-lines-4k-b2.jpg?alt=media
19	62	https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/windows-11-dark-mode-blue-stock-official-2560x1440-5630.jpg?alt=media
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (idrole, designation) FROM stdin;
1	Client
2	Administrateur
\.


--
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (idutilisateur, email, password) FROM stdin;
2	liantsiky@gmail.com	$2a$10$VHp9Ys828poMsth//nkE2u.y3ryvMOx8skPfqbBh.njVWr2.MlxN.
3	miaro@gmail.com	$2a$10$VBMZaO2wjeDDDMi81GQwoeNeG6B.ucWV4kLqYAysSAKBpfojBV60m
4	sababa@gmail.com	$2a$10$HtmnnqueBLGlxxV2g9fZzOLRFfDlg8jPeB2H3XTXJ7qMagHid6Ymy
5	nomena@gmail.com	$2a$10$vE5IKES34oMwZxG8FYQU1.anzbfbtbNBobOTJCKvOUs3/rCiU27j6
\.


--
-- Data for Name: utilisateur_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur_role (idutilisateur, idrole) FROM stdin;
5	1
4	2
2	1
3	1
\.


--
-- Data for Name: vente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vente (idvente, date_vente, idannonce, idutilisateur) FROM stdin;
5	2024-01-29	21	2
\.


--
-- Name: annonce_idannonce_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.annonce_idannonce_seq', 62, true);


--
-- Name: carburant_idcarburant_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carburant_idcarburant_seq', 3, true);


--
-- Name: categorie_voiture_idcategorie_voiture_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorie_voiture_idcategorie_voiture_seq', 9, true);


--
-- Name: commission_idcommission_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commission_idcommission_seq', 9, true);


--
-- Name: commission_vente_idcommission_vente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commission_vente_idcommission_vente_seq', 1, true);


--
-- Name: favori_idfavori_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.favori_idfavori_seq', 2, true);


--
-- Name: info_utilisateur_idinfo_utilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.info_utilisateur_idinfo_utilisateur_seq', 4, true);


--
-- Name: marque_voiture_idmarque_voiture_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marque_voiture_idmarque_voiture_seq', 3, true);


--
-- Name: modele_voiture_idmodele_voiture_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modele_voiture_idmodele_voiture_seq', 6, true);


--
-- Name: photo_id_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_id_photo_seq', 19, true);


--
-- Name: role_idrole_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_idrole_seq', 2, true);


--
-- Name: utilisateur_idutilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_idutilisateur_seq', 5, true);


--
-- Name: vente_idvente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vente_idvente_seq', 5, true);


--
-- Name: annonce annonce_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_pkey PRIMARY KEY (idannonce);


--
-- Name: carburant carburant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carburant
    ADD CONSTRAINT carburant_pkey PRIMARY KEY (idcarburant);


--
-- Name: categorie_voiture categorie_voiture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_voiture
    ADD CONSTRAINT categorie_voiture_pkey PRIMARY KEY (idcategorie_voiture);


--
-- Name: commission commission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission
    ADD CONSTRAINT commission_pkey PRIMARY KEY (idcommission);


--
-- Name: commission_vente commission_vente_idvente_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission_vente
    ADD CONSTRAINT commission_vente_idvente_key UNIQUE (idvente);


--
-- Name: commission_vente commission_vente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commission_vente
    ADD CONSTRAINT commission_vente_pkey PRIMARY KEY (idcommission_vente);


--
-- Name: favori favori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favori
    ADD CONSTRAINT favori_pkey PRIMARY KEY (idfavori);


--
-- Name: info_utilisateur info_utilisateur_idutilisateur_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.info_utilisateur
    ADD CONSTRAINT info_utilisateur_idutilisateur_key UNIQUE (idutilisateur);


--
-- Name: info_utilisateur info_utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.info_utilisateur
    ADD CONSTRAINT info_utilisateur_pkey PRIMARY KEY (idinfo_utilisateur);


--
-- Name: marque_voiture marque_voiture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marque_voiture
    ADD CONSTRAINT marque_voiture_pkey PRIMARY KEY (idmarque_voiture);


--
-- Name: modele_voiture modele_voiture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modele_voiture
    ADD CONSTRAINT modele_voiture_pkey PRIMARY KEY (idmodele_voiture);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (idrole);


--
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (idutilisateur);


--
-- Name: utilisateur_role utilisateur_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur_role
    ADD CONSTRAINT utilisateur_role_pkey PRIMARY KEY (idutilisateur, idrole);


--
-- Name: vente vente_idannonce_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_idannonce_key UNIQUE (idannonce);


--
-- Name: vente vente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_pkey PRIMARY KEY (idvente);


--
-- Name: annonce annonce_idcarburant_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_idcarburant_fkey FOREIGN KEY (idcarburant) REFERENCES public.carburant(idcarburant);


--
-- Name: annonce annonce_idcategorie_voiture_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_idcategorie_voiture_fkey FOREIGN KEY (idcategorie_voiture) REFERENCES public.categorie_voiture(idcategorie_voiture);


--
-- Name: annonce annonce_idmodele_voiture_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_idmodele_voiture_fkey FOREIGN KEY (idmodele_voiture) REFERENCES public.modele_voiture(idmodele_voiture);


--
-- Name: annonce annonce_idutilisateur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_idutilisateur_fkey FOREIGN KEY (idutilisateur) REFERENCES public.utilisateur(idutilisateur);


--
-- Name: favori favori_idannonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favori
    ADD CONSTRAINT favori_idannonce_fkey FOREIGN KEY (idannonce) REFERENCES public.annonce(idannonce);


--
-- Name: favori favori_idutilisateur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favori
    ADD CONSTRAINT favori_idutilisateur_fkey FOREIGN KEY (idutilisateur) REFERENCES public.utilisateur(idutilisateur);


--
-- Name: modele_voiture modele_voiture_idmarque_voiture_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modele_voiture
    ADD CONSTRAINT modele_voiture_idmarque_voiture_fkey FOREIGN KEY (idmarque_voiture) REFERENCES public.marque_voiture(idmarque_voiture);


--
-- Name: photo photo_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_id_annonce_fkey FOREIGN KEY (idannonce) REFERENCES public.annonce(idannonce);


--
-- Name: utilisateur_role utilisateur_role_idrole_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur_role
    ADD CONSTRAINT utilisateur_role_idrole_fkey FOREIGN KEY (idrole) REFERENCES public.role(idrole);


--
-- Name: vente vente_idannonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_idannonce_fkey FOREIGN KEY (idannonce) REFERENCES public.annonce(idannonce);


--
-- Name: vente vente_idutilisateur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_idutilisateur_fkey FOREIGN KEY (idutilisateur) REFERENCES public.utilisateur(idutilisateur);


--
-- PostgreSQL database dump complete
--

