LOAD DATA
INFILE majestic_million.csv
APPEND INTO TABLE MAJESTIC_INDEX3
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
TRAILING NULLCOLS ( GlobalRank, TldRank, Domain, TLD, RefSubNets, RefIPs, IDN_Domain, IDN_TLD, PrevGlobalRank, PrevTldRank, PrevRefSubNets, PrevRefIPs)