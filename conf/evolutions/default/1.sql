# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table app_download_url (
  id                        bigint auto_increment not null,
  ver                       nvarchar(32),
  download_url              nvarchar(64),
  constraint pk_app_download_url primary key (id))
;

create table contents (
  id                        bigint auto_increment not null,
  title                     nvarchar(255),
  contents                  text,
  bus_tag                   nvarchar(255),
  create_date               datetime,
  rec_count                 integer,
  view_count                integer,
  status                    char(1),
  is_best                   char(1),
  is_notice                 char(1),
  user_id                   bigint,
  constraint pk_contents primary key (id))
;

create table recommands (
  user_id                   bigint,
  content_id                bigint,
  create_date               datetime,
  status                    char(1))
;

create table replies (
  user_id                   bigint,
  content_id                bigint,
  reply_contents            text,
  create_date               datetime,
  status                    char(1))
;

create table users (
  id                        bigint auto_increment not null,
  nickname                  nvarchar(255),
  udid                      nvarchar(100),
  memo                      text,
  status                    char(1),
  gender                    char(1),
  create_date               datetime,
  image_url                 nvarchar(255),
  constraint pk_users primary key (id))
;

alter table contents add constraint fk_contents_user_1 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_contents_user_1 on contents (user_id);
alter table recommands add constraint fk_recommands_user_2 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_recommands_user_2 on recommands (user_id);
alter table recommands add constraint fk_recommands_content_3 foreign key (content_id) references contents (id) on delete restrict on update restrict;
create index ix_recommands_content_3 on recommands (content_id);
alter table replies add constraint fk_replies_user_4 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_replies_user_4 on replies (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table app_download_url;

drop table contents;

drop table recommands;

drop table replies;

drop table users;

SET FOREIGN_KEY_CHECKS=1;

