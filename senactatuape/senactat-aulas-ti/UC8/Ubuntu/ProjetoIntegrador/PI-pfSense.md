#Projeto Integrador do Técnico em Informática do SENAC Tatuapé.

Desafio das aulas de GNU/Linux: pfSense, Ubuntu Server e Linux Mint.

Primeira etapa: Instalação e Configuração do Firewall/Proxy e VPN pfSense

#01_ Instalar a versão do pfSense 2.6.0<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-001-InstalacaoDopfSense-2.6.txt

#02_ Configuração das Interfaces de Rede de LAN e WAN<br>
#02_A = Interface On-Board WAN DHCP<br>
#02_B = Interface Off-Board LAN Static:<br>
			IPv4: 172.16.X.254/24<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-002-ConsoleDopfSense.txt

#03_ Habilitar o recurso da Versão Plus 22.01 do pfSense<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-001-InstalacaoDopfSense-Plus-22.01.txt

#04_ Configuração do WebConfigurator do pfSense Plus<br>
#04_A = Usuário padrão: admin<br>
#04_B = Senha padrão..: 123@senac<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-003-WebconfiguratorDopfSense.txt

#05_ Configuração do Dashboard do pfSense Plus<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-004-ConfiguracoesDoDashboard.txt

#06_ Configuração do OpenSSH do pfSense Plus<br>
Observação importante: não configurar o suporte a Chave Pública/Privada<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-007-ConfgurandoConsole_SSH.txt

#07_ Configuração da Unidade Certificadora Raiz CA do pfSense Plus<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-008-ConfigurandoCA.txt

#08_ Configuração do Suporte ao HTTPS no pfSense Plus<br>
#08_A = Observação importante: configurar a porta 10443<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-008-ConfigurandoCA.txt<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-013-Firewall-Rules-WAN.txt

#09_ Configuração das Regras de NAT<br>
#09_A = Regras de NAT da Porta: 80 Apache2 para o Servidor GNU/Linux Ubuntu Server;<br>
#09_B = regras de NAT da Porta: 22 OpenSSH para o Servidor GNU/Linux Ubuntu Server;<br>
#09_C = regras de NAT da Porta: 8080 Tomcat para o Servidor GNU/Linux Ubuntu Server;<br>
#09_D = regras de NAT da Porta: 10000 Webmin para o Servidor GNU/Linux Ubuntu Server;<br>
#09_E = regras de NAT da Porta: 3306 MySQL para o Servidor GNU/Linux Ubuntu Server;<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-010-NAT-PortForwarding.txt

#10_ Configuração das Regras de Firewall na LAN<br>
#10_A = Observação importante: liberação das portas padrão e deixar desabilitado as regras padrão<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-011-Firewall-Rules-LAN.txt

#11_ Configuração das Regras de Firewall na WAN<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-013-Firewall-Rules-WAN.txt

#12_ Configuração do suporte ao IPSec da VPN da Matriz (filial será o PC do Professor)<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-017-ConfiguracoesVPNIPsec-Matriz.txt

#13_ Configuração do suporte ao OpenVPn da VPN da Matriz (home office será o PC do Professor)<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-019-ConfiguracoesUsuariosGrupos.txt<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-020-ConfiguracoesOpenVPN-Matriz.txt

#14_ Configuração do Proxy com suporte a Interceptação HTTPS<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-098-ConfigurandoProxySquid.txt<br>
Material de apoio: https://github.com/vaamonde/senactat/blob/main/pfsense/settings/Etapa-099-ConfigurandoLightSquid.txt
