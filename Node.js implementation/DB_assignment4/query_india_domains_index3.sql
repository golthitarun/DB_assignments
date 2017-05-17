SET timing ON
SELECT Domain, GlobalRank, RefSubNets 
FROM MAJESTIC_INDEX3 m
WHERE m.TLD='in';