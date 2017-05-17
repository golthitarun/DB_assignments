create table MAJESTIC (
GlobalRank varchar(100),
TldRank varchar(100),
Domain varchar(100),
TLD varchar(100),
RefSubNets number(38),
RefIPs varchar(100),
IDN_Domain varchar(100),
IDN_TLD varchar(100),
PrevGlobalRank varchar(100),
PrevTldRank varchar(100),
PrevRefSubNets varchar(100),
PrevRefIPs varchar(100),
Primary key (GlobalRank)
);

create table MAJESTIC_INDEX1 (
GlobalRank varchar(100),
TldRank varchar(100),
Domain varchar(100),
TLD varchar(100),
RefSubNets number(38),
RefIPs varchar(100),
IDN_Domain varchar(100),
IDN_TLD varchar(100),
PrevGlobalRank varchar(100),
PrevTldRank varchar(100),
PrevRefSubNets varchar(100),
PrevRefIPs varchar(100),
Primary key (GlobalRank)
);
create index MAJESTIC_TLD on MAJESTIC_INDEX1(TLD);

create table MAJESTIC_INDEX2 (
GlobalRank varchar(100),
TldRank varchar(100),
Domain varchar(100),
TLD varchar(100),
RefSubNets number(38),
RefIPs varchar(100),
IDN_Domain varchar(100),
IDN_TLD varchar(100),
PrevGlobalRank varchar(100),
PrevTldRank varchar(100),
PrevRefSubNets varchar(100),
PrevRefIPs varchar(100),
Primary key (GlobalRank)
);
create index MAJESTIC_RefSubNets on MAJESTIC_INDEX2(RefSubNets);

create table MAJESTIC_INDEX3 (
GlobalRank varchar(100),
TldRank varchar(100),
Domain varchar(100),
TLD varchar(100),
RefSubNets number(38),
RefIPs varchar(100),
IDN_Domain varchar(100),
IDN_TLD varchar(100),
PrevGlobalRank varchar(100),
PrevTldRank varchar(100),
PrevRefSubNets varchar(100),
PrevRefIPs varchar(100),
Primary key (GlobalRank)
);
create index TLD_RefIPs on MAJESTIC_INDEX3(TLD,RefIPs);
