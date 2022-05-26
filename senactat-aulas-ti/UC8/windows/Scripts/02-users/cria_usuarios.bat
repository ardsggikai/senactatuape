; SCRIPT AUTOMATIZADO PARA CRIACAO DE USUARIOS NO ACTIVE DIRECTORY
FOR /F "EOL=; TOKENS=1,2,3,* DELIMS=;" %%I IN (fin.csv) DO DSADD USER "CN=%%J %%I, OU=Financeiro, OU=USERS,OU=CORE,DC=CORE,DC=INTRA" -SAMID "%%J.%%I" -UPN "%%J.%%I"@CORE.INTRA -FN %%J -LN %%I -DISPLAY "%%J %%I" -EMAIL "%%J.%%I"@CORE.com.br -title %%K -Dept Financeiro -Company CORE -PWD 123@senac -DISABLED YES
FOR /F "EOL=; TOKENS=1,2,3,* DELIMS=;" %%I IN (mkt.csv) DO DSADD USER "CN=%%J %%I, OU=Marketing, OU=USERS,OU=CORE,DC=CORE,DC=INTRA" -SAMID "%%J.%%I" -UPN "%%J.%%I"@CORE.INTRA -FN %%J -LN %%I -DISPLAY "%%J %%I" -EMAIL "%%J.%%I"@CORE.com.br -title %%K -Dept Marketing -Company CORE -PWD 123@senac -DISABLED YES
FOR /F "EOL=; TOKENS=1,2,3,* DELIMS=;" %%I IN (ven.csv) DO DSADD USER "CN=%%J %%I, OU=Vendas, OU=USERS,OU=CORE,DC=CORE,DC=INTRA" -SAMID "%%J.%%I" -UPN "%%J.%%I"@CORE.INTRA -FN %%J -LN %%I -DISPLAY "%%J %%I" -EMAIL "%%J.%%I"@CORE.com.br -title %%K -Dept Vendas -Company CORE -PWD 123@senac -DISABLED YES
FOR /F "EOL=; TOKENS=1,2,3,* DELIMS=;" %%I IN (ti.csv) DO DSADD USER "CN=%%J %%I, OU=Tecnologia, OU=USERS,OU=CORE,DC=CORE,DC=INTRA" -SAMID "%%J.%%I" -UPN "%%J.%%I"@CORE.INTRA -FN %%J -LN %%I -DISPLAY "%%J %%I" -EMAIL "%%J.%%I"@CORE.com.br -title %%K -Dept Tecnologia -Company CORE -PWD 123@senac -DISABLED YES
FOR /F "EOL=; TOKENS=1,2,3,* DELIMS=;" %%I IN (rh.csv) DO DSADD USER "CN=%%J %%I, OU=RH, OU=USERS,OU=CORE,DC=CORE,DC=INTRA" -SAMID "%%J.%%I" -UPN "%%J.%%I"@CORE.INTRA -FN %%J -LN %%I -DISPLAY "%%J %%I" -EMAIL "%%J.%%I"@CORE.com.br -title %%K -Dept Recursos_Humanos -Company CORE -PWD 123@senac -DISABLED YES

