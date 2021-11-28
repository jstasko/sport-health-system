
/*
grant execute on utl_http to stasko_PDBS;
grant execute on utl_smtp to stasko_PDBS;
grant execute on  utl_tcp to stasko_PDBS;

grant execute on DBMS_NETWORK_ACL_ADMIN to stasko_PDBS;
*/
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'STASKO_PDBS';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'STASKO_PDBS';
SELECT * FROM DBA_TAB_PRIVS WHERE GRANTEE = 'STASKO_PDBS';

BEGIN
 DBMS_NETWORK_ACL_ADMIN.CREATE_ACL (
  acl => '/sys/acls/sysdba-ch-permissions.xml',
  description => 'Permissions for network',
  principal => 'STASKO_PDBS',
  is_grant => TRUE,
  privilege => 'connect');
END;
/
commit;

BEGIN
DBMS_NETWORK_ACL_ADMIN.ASSIGN_ACL (
    acl => '/sys/acls/sysdba-ch-permissions.xml',
    host => '*',
    lower_port => null,
    upper_port => null
);
END;
/

select * from dba_network_acls;

commit;

select * from dba_network_acls;

DESC dba_network_acls;
desc dba_network_acl_privileges;


CREATE OR REPLACE PROCEDURE show_html_from_url (
  p_url  IN  VARCHAR2,
  p_username IN VARCHAR2 DEFAULT NULL,
  p_password IN VARCHAR2 DEFAULT NULL
) AS
  l_http_request   UTL_HTTP.req;
  l_http_response  UTL_HTTP.resp;
  l_text           VARCHAR2(32767);
BEGIN
  l_http_request  := UTL_HTTP.begin_request(p_url);
  IF p_username IS NOT NULL and p_password IS NOT NULL THEN
    UTL_HTTP.set_authentication(l_http_request, p_username, p_password);
  END IF;
  l_http_response := UTL_HTTP.get_response(l_http_request);
  BEGIN
    LOOP
      UTL_HTTP.read_text(l_http_response, l_text, 32766);
      DBMS_OUTPUT.put_line (l_text);
    END LOOP;
  EXCEPTION
    WHEN UTL_HTTP.end_of_body THEN
      UTL_HTTP.end_response(l_http_response);
  END;
EXCEPTION
  WHEN OTHERS THEN
    UTL_HTTP.end_response(l_http_response);
    RAISE;
END show_html_from_url;
/

 select wrl_parameter from V$ENCRYPTION_WALLET;
 
SELECT * FROM dba_network_acls;
SELECT * FROM dba_network_acl_privileges where principal='STASKO_PDBS';


execute show_html_from_url('https://api.sportnet.online/v1/ppo/futbalsfz.sk/users');
--EXEC UTL_HTTP.set_wallet('file:/C:\APP\ORACLE\ADMIN\ORCL\WALLET', 'mojeHeslo');

select utl_http.get_detailed_sqlerrm from dual;

