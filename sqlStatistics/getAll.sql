select * from M_KRAJINA mka
join M_KRAJ MK on mka.ID = MK.ID_KRAJINY
join M_OKRES MO on MK.ID = MO.ID_KRAJA
join M_ADRESA MA on MO.ID = MA.ID_OKRESU
where MK.ID = :id
