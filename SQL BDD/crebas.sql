/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  12/01/2014 18:38:41                      */
/*==============================================================*/


drop index ECOLEOBJET_PK;

drop table ECOLEOBJET;

drop index EPOQUEOBJET_PK;

drop table EPOQUEOBJET;

drop index ESCROCAEPOQUE_FK;

drop index ESCROCAECOLE_FK;

drop index ESCROCATYPE_FK;

drop index APPARTIENT_FK;

drop index ESCROC_PK;

drop table ESCROC;

drop index GROUPE_PK;

drop table GROUPE;

drop index ESCROCLOG_FK;

drop index HISTORIQUEESCROC_PK;

drop table HISTORIQUEESCROC;

drop index OEUVRELOG_FK;

drop index HISTORIQUEOEUVRE_PK;

drop table HISTORIQUEOEUVRE;

drop index ORGANISATIONLOG_FK;

drop index HISTORIQUEORGANISATION_PK;

drop table HISTORIQUEORGANISATION;

drop index VOLLOG_FK;

drop index HISTORIQUEVOL_PK;

drop table HISTORIQUEVOL;

drop index OBJETAEPOQUE_FK;

drop index OBJETAECOLE_FK;

drop index OEUVREATYPE_FK;

drop index OEUVRE_PK;

drop table OEUVRE;

drop index ORGANISATION_PK;

drop table ORGANISATION;

drop index TYPEOBJET_PK;

drop table TYPEOBJET;

drop index FAITPARTIE_FK;

drop index UTILISATEUR_PK;

drop table UTILISATEUR;

drop index DECLARE_FK;

drop index COMMET_FK;

drop index CONCERNE_FK;

drop index VOL_PK;

drop table VOL;

/*==============================================================*/
/* Table : ECOLEOBJET                                           */
/*==============================================================*/
create table ECOLEOBJET (
   ECOLE_ID             SERIAL               not null,
   ECOLE_VALEUR         CHAR(64)             not null,
   constraint PK_ECOLEOBJET primary key (ECOLE_ID)
);

/*==============================================================*/
/* Index : ECOLEOBJET_PK                                        */
/*==============================================================*/
create unique index ECOLEOBJET_PK on ECOLEOBJET (
ECOLE_ID
);

/*==============================================================*/
/* Table : EPOQUEOBJET                                          */
/*==============================================================*/
create table EPOQUEOBJET (
   EPOQUE_ID            SERIAL               not null,
   EPOQUE_VALEUR        CHAR(64)             not null,
   constraint PK_EPOQUEOBJET primary key (EPOQUE_ID)
);

/*==============================================================*/
/* Index : EPOQUEOBJET_PK                                       */
/*==============================================================*/
create unique index EPOQUEOBJET_PK on EPOQUEOBJET (
EPOQUE_ID
);

/*==============================================================*/
/* Table : ESCROC                                               */
/*==============================================================*/
create table ESCROC (
   ESCROC_ID            SERIAL               not null,
   ECOLE_ID             INT4                 null,
   TYPE_ID              INT4                 null,
   ORGANISATION_ID      INT4                 null,
   EPOQUE_ID            INT4                 null,
   ESCROC_NOM           CHAR(64)             not null,
   ESCROC_PRENOM        CHAR(64)             not null,
   ESCROC_PHOTO         TEXT                 null,
   ESCROC_DATENAISSANCE DATE                 null,
   ESCROC_STATUT        CHAR(8)              not null,
   ESCROC_TYPE          CHAR(8)              not null,
   constraint PK_ESCROC primary key (ESCROC_ID)
);

/*==============================================================*/
/* Index : ESCROC_PK                                            */
/*==============================================================*/
create unique index ESCROC_PK on ESCROC (
ESCROC_ID
);

/*==============================================================*/
/* Index : APPARTIENT_FK                                        */
/*==============================================================*/
create  index APPARTIENT_FK on ESCROC (
ORGANISATION_ID
);

/*==============================================================*/
/* Index : ESCROCATYPE_FK                                       */
/*==============================================================*/
create  index ESCROCATYPE_FK on ESCROC (
TYPE_ID
);

/*==============================================================*/
/* Index : ESCROCAECOLE_FK                                      */
/*==============================================================*/
create  index ESCROCAECOLE_FK on ESCROC (
ECOLE_ID
);

/*==============================================================*/
/* Index : ESCROCAEPOQUE_FK                                     */
/*==============================================================*/
create  index ESCROCAEPOQUE_FK on ESCROC (
EPOQUE_ID
);

/*==============================================================*/
/* Table : GROUPE                                               */
/*==============================================================*/
create table GROUPE (
   GROUPE_ID            CHAR(8)              not null,
   GROUPE_NOM           CHAR(64)             not null,
   constraint PK_GROUPE primary key (GROUPE_ID)
);

/*==============================================================*/
/* Index : GROUPE_PK                                            */
/*==============================================================*/
create unique index GROUPE_PK on GROUPE (
GROUPE_ID
);

/*==============================================================*/
/* Table : HISTORIQUEESCROC                                     */
/*==============================================================*/
create table HISTORIQUEESCROC (
   HIST_ESCROC_ID       SERIAL               not null,
   ESCROC_ID            INT4                 null,
   HIST_ESCROC_ACTION   CHAR(8)              not null,
   HIST_ESCROC_ACTEUR   CHAR(128)            not null,
   HIST_ESCROC_DATE     DATE                 not null,
   constraint PK_HISTORIQUEESCROC primary key (HIST_ESCROC_ID)
);

/*==============================================================*/
/* Index : HISTORIQUEESCROC_PK                                  */
/*==============================================================*/
create unique index HISTORIQUEESCROC_PK on HISTORIQUEESCROC (
HIST_ESCROC_ID
);

/*==============================================================*/
/* Index : ESCROCLOG_FK                                         */
/*==============================================================*/
create  index ESCROCLOG_FK on HISTORIQUEESCROC (
ESCROC_ID
);

/*==============================================================*/
/* Table : HISTORIQUEOEUVRE                                     */
/*==============================================================*/
create table HISTORIQUEOEUVRE (
   HIST_OEUVRE_ID       SERIAL               not null,
   OEUVRE_ID            INT4                 null,
   HIST_OEUVRE_ACTION   CHAR(8)              not null,
   HIST_OEUVRE_ACTEUR   CHAR(128)            not null,
   HIST_OEUVRE_DATE     DATE                 not null,
   constraint PK_HISTORIQUEOEUVRE primary key (HIST_OEUVRE_ID)
);

/*==============================================================*/
/* Index : HISTORIQUEOEUVRE_PK                                  */
/*==============================================================*/
create unique index HISTORIQUEOEUVRE_PK on HISTORIQUEOEUVRE (
HIST_OEUVRE_ID
);

/*==============================================================*/
/* Index : OEUVRELOG_FK                                         */
/*==============================================================*/
create  index OEUVRELOG_FK on HISTORIQUEOEUVRE (
OEUVRE_ID
);

/*==============================================================*/
/* Table : HISTORIQUEORGANISATION                               */
/*==============================================================*/
create table HISTORIQUEORGANISATION (
   HIST_ORGANISATION_ID SERIAL               not null,
   ORGANISATION_ID      INT4                 null,
   HIST_ORGANISATION_ACTION CHAR(8)              not null,
   HIST_ORGANISATION_ACTEUR CHAR(128)            not null,
   HIST_ORGANISATION_DATE DATE                 not null,
   constraint PK_HISTORIQUEORGANISATION primary key (HIST_ORGANISATION_ID)
);

/*==============================================================*/
/* Index : HISTORIQUEORGANISATION_PK                            */
/*==============================================================*/
create unique index HISTORIQUEORGANISATION_PK on HISTORIQUEORGANISATION (
HIST_ORGANISATION_ID
);

/*==============================================================*/
/* Index : ORGANISATIONLOG_FK                                   */
/*==============================================================*/
create  index ORGANISATIONLOG_FK on HISTORIQUEORGANISATION (
ORGANISATION_ID
);

/*==============================================================*/
/* Table : HISTORIQUEVOL                                        */
/*==============================================================*/
create table HISTORIQUEVOL (
   HIST_VOL_ID          SERIAL               not null,
   VOL_ID               INT4                 null,
   HIST_VOL_ACTION      CHAR(8)              not null,
   HIST_VOL_ACTEUR      CHAR(128)            not null,
   HIST_VOL_DATE        DATE                 not null,
   constraint PK_HISTORIQUEVOL primary key (HIST_VOL_ID)
);

/*==============================================================*/
/* Index : HISTORIQUEVOL_PK                                     */
/*==============================================================*/
create unique index HISTORIQUEVOL_PK on HISTORIQUEVOL (
HIST_VOL_ID
);

/*==============================================================*/
/* Index : VOLLOG_FK                                            */
/*==============================================================*/
create  index VOLLOG_FK on HISTORIQUEVOL (
VOL_ID
);

/*==============================================================*/
/* Table : OEUVRE                                               */
/*==============================================================*/
create table OEUVRE (
   OEUVRE_ID            SERIAL               not null,
   EPOQUE_ID            INT4                 null,
   ECOLE_ID             INT4                 null,
   TYPE_ID              INT4                 null,
   OEUVRE_NOM           CHAR(256)            not null,
   OEUVRE_PHOTO         TEXT                 null,
   OEUVRE_STATUT        CHAR(32)             not null,
   OEUVRE_PROPRIETAIRE  CHAR(128)            null,
   constraint PK_OEUVRE primary key (OEUVRE_ID)
);

/*==============================================================*/
/* Index : OEUVRE_PK                                            */
/*==============================================================*/
create unique index OEUVRE_PK on OEUVRE (
OEUVRE_ID
);

/*==============================================================*/
/* Index : OEUVREATYPE_FK                                       */
/*==============================================================*/
create  index OEUVREATYPE_FK on OEUVRE (
TYPE_ID
);

/*==============================================================*/
/* Index : OBJETAECOLE_FK                                       */
/*==============================================================*/
create  index OBJETAECOLE_FK on OEUVRE (
ECOLE_ID
);

/*==============================================================*/
/* Index : OBJETAEPOQUE_FK                                      */
/*==============================================================*/
create  index OBJETAEPOQUE_FK on OEUVRE (
EPOQUE_ID
);

/*==============================================================*/
/* Table : ORGANISATION                                         */
/*==============================================================*/
create table ORGANISATION (
   ORGANISATION_ID      SERIAL               not null,
   ORGANISATION_NOM     TEXT                 not null,
   constraint PK_ORGANISATION primary key (ORGANISATION_ID)
);

/*==============================================================*/
/* Index : ORGANISATION_PK                                      */
/*==============================================================*/
create unique index ORGANISATION_PK on ORGANISATION (
ORGANISATION_ID
);

/*==============================================================*/
/* Table : TYPEOBJET                                            */
/*==============================================================*/
create table TYPEOBJET (
   TYPE_ID              SERIAL               not null,
   TYPE_VALEUR          CHAR(64)             not null,
   constraint PK_TYPEOBJET primary key (TYPE_ID)
);

/*==============================================================*/
/* Index : TYPEOBJET_PK                                         */
/*==============================================================*/
create unique index TYPEOBJET_PK on TYPEOBJET (
TYPE_ID
);

/*==============================================================*/
/* Table : UTILISATEUR                                          */
/*==============================================================*/
create table UTILISATEUR (
   UTILISATEUR_ID       CHAR(8)              not null,
   GROUPE_ID            CHAR(8)              null,
   UTILISATEUR_NOM      CHAR(64)             not null,
   UTILISATEUR_PRENOM   CHAR(64)             not null,
   UTILISATEUR_MDP      CHAR(16)             not null,
   UTILISATEUR_CREATION DATE                 not null,
   constraint PK_UTILISATEUR primary key (UTILISATEUR_ID)
);

/*==============================================================*/
/* Index : UTILISATEUR_PK                                       */
/*==============================================================*/
create unique index UTILISATEUR_PK on UTILISATEUR (
UTILISATEUR_ID
);

/*==============================================================*/
/* Index : FAITPARTIE_FK                                        */
/*==============================================================*/
create  index FAITPARTIE_FK on UTILISATEUR (
GROUPE_ID
);

/*==============================================================*/
/* Table : VOL                                                  */
/*==============================================================*/
create table VOL (
   VOL_ID               SERIAL               not null,
   ESCROC_ID            INT4                 null,
   OEUVRE_ID            INT4                 null,
   UTILISATEUR_ID       CHAR(8)              null,
   VOL_DATE             DATE                 not null,
   VOL_LIEU             CHAR(256)            not null,
   VOL_RESOLU           BOOL                 not null,
   VOL_AUTRE            TEXT                 null,
   constraint PK_VOL primary key (VOL_ID)
);

/*==============================================================*/
/* Index : VOL_PK                                               */
/*==============================================================*/
create unique index VOL_PK on VOL (
VOL_ID
);

/*==============================================================*/
/* Index : CONCERNE_FK                                          */
/*==============================================================*/
create  index CONCERNE_FK on VOL (
OEUVRE_ID
);

/*==============================================================*/
/* Index : COMMET_FK                                            */
/*==============================================================*/
create  index COMMET_FK on VOL (
ESCROC_ID
);

/*==============================================================*/
/* Index : DECLARE_FK                                           */
/*==============================================================*/
create  index DECLARE_FK on VOL (
UTILISATEUR_ID
);

alter table ESCROC
   add constraint FK_ESCROC_APPARTIEN_ORGANISA foreign key (ORGANISATION_ID)
      references ORGANISATION (ORGANISATION_ID)
      on delete restrict on update restrict;

alter table ESCROC
   add constraint FK_ESCROC_ESCROCAEC_ECOLEOBJ foreign key (ECOLE_ID)
      references ECOLEOBJET (ECOLE_ID)
      on delete restrict on update restrict;

alter table ESCROC
   add constraint FK_ESCROC_ESCROCAEP_EPOQUEOB foreign key (EPOQUE_ID)
      references EPOQUEOBJET (EPOQUE_ID)
      on delete restrict on update restrict;

alter table ESCROC
   add constraint FK_ESCROC_ESCROCATY_TYPEOBJE foreign key (TYPE_ID)
      references TYPEOBJET (TYPE_ID)
      on delete restrict on update restrict;

alter table HISTORIQUEESCROC
   add constraint FK_HISTORIQ_ESCROCLOG_ESCROC foreign key (ESCROC_ID)
      references ESCROC (ESCROC_ID)
      on delete restrict on update restrict;

alter table HISTORIQUEOEUVRE
   add constraint FK_HISTORIQ_OEUVRELOG_OEUVRE foreign key (OEUVRE_ID)
      references OEUVRE (OEUVRE_ID)
      on delete restrict on update restrict;

alter table HISTORIQUEORGANISATION
   add constraint FK_HISTORIQ_ORGANISAT_ORGANISA foreign key (ORGANISATION_ID)
      references ORGANISATION (ORGANISATION_ID)
      on delete restrict on update restrict;

alter table HISTORIQUEVOL
   add constraint FK_HISTORIQ_VOLLOG_VOL foreign key (VOL_ID)
      references VOL (VOL_ID)
      on delete restrict on update restrict;

alter table OEUVRE
   add constraint FK_OEUVRE_OBJETAECO_ECOLEOBJ foreign key (ECOLE_ID)
      references ECOLEOBJET (ECOLE_ID)
      on delete restrict on update restrict;

alter table OEUVRE
   add constraint FK_OEUVRE_OBJETAEPO_EPOQUEOB foreign key (EPOQUE_ID)
      references EPOQUEOBJET (EPOQUE_ID)
      on delete restrict on update restrict;

alter table OEUVRE
   add constraint FK_OEUVRE_OEUVREATY_TYPEOBJE foreign key (TYPE_ID)
      references TYPEOBJET (TYPE_ID)
      on delete restrict on update restrict;

alter table UTILISATEUR
   add constraint FK_UTILISAT_FAITPARTI_GROUPE foreign key (GROUPE_ID)
      references GROUPE (GROUPE_ID)
      on delete restrict on update restrict;

alter table VOL
   add constraint FK_VOL_COMMET_ESCROC foreign key (ESCROC_ID)
      references ESCROC (ESCROC_ID)
      on delete restrict on update restrict;

alter table VOL
   add constraint FK_VOL_CONCERNE_OEUVRE foreign key (OEUVRE_ID)
      references OEUVRE (OEUVRE_ID)
      on delete restrict on update restrict;

alter table VOL
   add constraint FK_VOL_DECLARE_UTILISAT foreign key (UTILISATEUR_ID)
      references UTILISATEUR (UTILISATEUR_ID)
      on delete restrict on update restrict;

