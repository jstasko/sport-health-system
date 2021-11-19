select
*
from v$session b, v$process a
where
b.paddr = a.addr
and type='USER'
order by spid;