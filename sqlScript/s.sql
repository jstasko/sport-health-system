select
*
from v$session b, v$process a
where
b.paddr = a.addr
and type='USER'
order by spid;

DEFINE _O_VERSION
SHOW USER
SELECT  *
  FROM  DBA_OBJECTS
  WHERE OBJECT_NAME = 'DBMS_NETWORK_ACL_ADMIN'
/

select * from v$version;