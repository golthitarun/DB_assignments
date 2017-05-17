SET timing ON
SELECT Domain, GlobalRank, RefSubNets 
FROM MAJESTIC_INDEX1 m
WHERE m.TLD='in';