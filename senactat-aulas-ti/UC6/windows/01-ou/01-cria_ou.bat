:: CRIA OU PRINCIPAL
dsadd ou "OU=BRAGA, DC=BRAGA, DC=INTRA" -desc "BRAGA"

:: CRIA SUB-OU
FOR /F "EOL=; TOKENS=1,* DELIMS=," %%I IN (02-SUB-OUs.TXT) DO dsadd ou "OU=%%I, OU=BRAGA,DC=BRAGA, DC=INTRA"
FOR /F "EOL=; TOKENS=1,* DELIMS=," %%I IN (deptos.TXT) DO dsadd ou "OU=%%I, OU=USERS, OU=BRAGA,DC=BRAGA, DC=INTRA"








