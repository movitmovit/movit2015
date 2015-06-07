
CREATE TABLE Member (
    memberIdx int not null primary key, /*auto increase ���� �� ã�ƺ���*/
    m_id varchar(80) not null,
    m_pw varchar(80) not null,
    m_name varchar(80) null,
    m_rateAvg float null, 
    m_commonRate float null, 
    m_totalRate float null, 
    m_totalTime int null
);

create table StorageMv (
    memberIdx int REFERENCES Member(memberIdx), 
    storageIdx int not null primary key,
    s_title varchar(80) not null,
	s_director varchar(80) not null,
	s_img varchar(80),
	s_nation varchar(80),
	s_time varchar(80),
    s_rating varchar(80),
    s_pubYear varchar(80),
    s_actor varchar(80),
    s_genre varchar(80)
    );

drop table StorageMv;

insert into StorageMv (storageIdx, memberIdx, s_title, s_director, s_img, s_nation, s_time, s_rating, s_pubYear, s_actor, s_genre) values (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
insert into StorageMv (storageIdx, memberIdx, s_title, s_director, s_img, s_nation, s_time, s_rating, s_pubYear, s_actor, s_genre) values (1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
insert into StorageMv (storageIdx, memberIdx, s_title, s_director, s_img, s_nation, s_time, s_rating, s_pubYear, s_actor, s_genre) values (2, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

/*grant all on supplier to public;*/

create table WishMv (
	memberIdx int not null references Member(memberIdx),
	wishIdx int not null primary key,
	w_title varchar(80) not null,
	w_director varchar(80) not null,
	w_img varchar(80)
	);

/* constraint pk_signon primary key (username) */
/*grant all on signon to public;*/

create table WishMv (
	memberIdx int not null references Member(memberIdx),
	wishIdx int not null primary key,
	w_title varchar(80) not null,
	w_director varchar(80) not null,
	w_img varchar(80)
	);

/*    constraint pk_account primary key (userid)*/
/*grant all on account to public;*/

create table TasteGenre (
    g_tasteIdx int not null primary key,
    memberIdx int REFERENCES Member(memberIdx),
    g_drama int,
    g_romance int,
    g_action int,
    g_horror int,
    g_adventure int,
    g_sf int,
    g_thriller int,
    g_comedy int,
    g_family int, 
    g_noir int, 
    g_animation int, 
    g_fantasy int, 
    g_war int, 
    g_docu int   
);


/*여기서 부터 바꿔야함! 5.22*/
drop table wishMv;
drop table StorageMv;
drop table TasteGenre;
drop table customer;
drop table preferGenre;
drop table preferDirector;
drop table preferNation;
drop table Movie; 
drop table Storage; drop table MvWishMv;

/*05.22 선호 genre, director, nation 다시 아직 테이블 안만들음!*/
create table preferGenre (
    memberIdx int REFERENCES Member(memberIdx),
   	genre varchar(80), 
   	score int
);

create table preferDirector (
    memberIdx int REFERENCES Member(memberIdx),
   	director varchar(80), 
   	score int
);

create table preferNation (
    memberIdx int REFERENCES Member(memberIdx),
   	nation varchar(80), 
   	score int
);

/*5.22 movie 테이블 생성 -> movie 관련 class생성해야함 domain dao...*/

CREATE TABLE Movie (
    movieIdx int not null primary key,
    title varchar(80), 
    genre varchar(80), 
   	director varchar(80),
   	nation varchar(80),
   	img varchar(80)
);

/*5.22 movie 와 member relation table이 진정 storagemv 테이블인것인가 */
CREATE TABLE StorageMv(
	memberIdx int REFERENCES Member(memberIdx),
    movieIdx int REFERENCES Movie(movieIdx),
    rate varchar(80)
);

DROP TABLE StorageMv;

/*5.22 wish도 간단해지네.. */
create table WishMv(
	memberIdx int REFERENCES Member(memberIdx),
    movieIdx int REFERENCES Movie(movieIdx)
);



insert into StorageMv (memberIdx, movieIdx, rate) values (1,2,3);

alter table Movie 
MODIFY (img VARCHAR(900)); 
