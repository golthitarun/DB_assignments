SET timing ON
SELECT Domain, GlobalRank, RefSubNets 
FROM MAJESTIC_INDEX2 m
WHERE m.TLD='in';