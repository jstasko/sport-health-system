--------------------------------------------------Osoba---------------------------------------------------------------------
set serveroutput  on;
create or replace procedure add_data_osoby
 as
 type t_riadok is record (
    externe_id m_hrac.id%type
 );
 rod_cislo integer;
 
 prikaz varchar2(1000);
 type t_pole is table of t_riadok;
 pole t_pole;
 begin
   rod_cislo  := 9001010000;
   select id bulk collect into pole FROM m_hrac;
   for i in 1 .. pole.last 
    loop   
       if substr(4, 2, to_char(rod_cislo)) > 27 then 
             rod_cislo :=  rod_cislo + 1000000;
             rod_cislo := to_number(concat(substr(rod_cislo, 1, 4), '010000'));
       end if;
       WHILE mod(rod_cislo, 11) <> 0
       loop
        rod_cislo := +1;
       end loop;
      select 'insert into m_osoba values (''' 
      || pole(i).externe_id || ''', null, ''' 
      || rod_cislo || ''')'  into prikaz from dual;
    --dbms_output.put_line(prikaz);
    execute immediate prikaz;
    end loop;   
 end;
/
--TODO PRERIESIT RODNE CISLA A ICH DNI
--delete  from m_osoba;
--delete from m_osoba;

--select to_number(concat(substr('9001281234', 1, 4), '010000')) from dual;
--execute add_data_osoby;

--------------------------------------------------Poistovna---------------------------------------------------------------------
insert into m_poistovna values (null, 'ALLIANZ - Slovensk� pois�ov�a a. s.',50274235);
insert into m_poistovna values (null, 'AXA pois�ov�a a.s. pobo�ka pois�ovne z in�ho �lensk�ho �t�tu',40556518);
insert into m_poistovna values (null, '�SOB Pois�ov�a a.s.',50256209);
insert into m_poistovna values (null, 'GENERALI Pois�ov�a a. s.',55842570);
insert into m_poistovna values (null, 'GENERALI Pois�ov�a a. s. od�tepn� z�vod Genertel.',749897);
insert into m_poistovna values (null, 'GROUPAMA pois�ov�a a. s. pobo�ka pois�ovne z in�ho �lensk�ho �t�tu',39509328);
insert into m_poistovna values (null, 'GENERALI Pois�ov�a a. s. od�tepn� z�vod Eur�pska cestovn� pois�ov�a',34718090);
insert into m_poistovna values (null, 'KOMUN�LNA pois�ov�a a.s. Vienna Insurance Group',39323152);
insert into m_poistovna values (null, 'KOOPERATIVA pois�ov�a a.s. Vienna Insurance Group',40114038);
insert into m_poistovna values (null, 'NOVIS Pois�ov�a a.s.',34818144);
insert into m_poistovna values (null, 'UNIQA pois�ov�a a.s.',34462129);
insert into m_poistovna values (null, 'UNION pois�ov�a a. s.',49792960);
insert into m_poistovna values (null, 'W�STENROT pois�ov�a a.s.',34880173);

-----------------------------------------------------m_specializacia-------------------------------------------------------------------
insert into m_specializacia(nazov, popis) values ('vn�torn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('infektol�gia', null);
insert into m_specializacia(nazov, popis) values ('pneumol�gia a ftizeol�gia', null);
insert into m_specializacia(nazov, popis) values ('neurol�gia', null);
insert into m_specializacia(nazov, popis) values ('psychiatria', null);
insert into m_specializacia(nazov, popis) values ('pracovn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('pediatria', null);
insert into m_specializacia(nazov, popis) values ('v�eobecn� starostlivos? o deti a dorast', null);
insert into m_specializacia(nazov, popis) values ('gynekol�gia a p�rodn�ctvo', null);
insert into m_specializacia(nazov, popis) values ('chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortop�dia', null);
insert into m_specializacia(nazov, popis) values ('urol�gia', null);
insert into m_specializacia(nazov, popis) values ('�razov� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('otorinolaryngol�gia', null);
insert into m_specializacia(nazov, popis) values ('oftalmol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� gynekol�gia', null);
insert into m_specializacia(nazov, popis) values ('dermatovenerol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('v�eobecn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('dorastov� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('r�diol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� bioch�mia', null);
insert into m_specializacia(nazov, popis) values ('anest�ziol�gia a intenz�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('telov�chovn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('fyziatria balneol�gia a lie�ebn� rehabilit�cia', null);
insert into m_specializacia(nazov, popis) values ('s�dne lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('patologick� anat�mia', null);
insert into m_specializacia(nazov, popis) values ('hematol�gia a transfuziol�gia', null);
insert into m_specializacia(nazov, popis) values ('urgentn� medic�na', null);
insert into m_specializacia(nazov, popis) values ('klinick� mikrobiol�gia', null);
insert into m_specializacia(nazov, popis) values ('neurochirurgia', null);
insert into m_specializacia(nazov, popis) values ('plastick� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('ortopedick� protetika', null);
insert into m_specializacia(nazov, popis) values ('klinick� imunol�gia a alergol�gia', null);
insert into m_specializacia(nazov, popis) values ('radia�n� onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('foniatria', null);
insert into m_specializacia(nazov, popis) values ('reumatol�gia', null);
insert into m_specializacia(nazov, popis) values ('algeziol�gia', null);
insert into m_specializacia(nazov, popis) values ('nukle�rna medic�na', null);
insert into m_specializacia(nazov, popis) values ('gastroenterol�gia', null);
insert into m_specializacia(nazov, popis) values ('kardiol�gia', null);
insert into m_specializacia(nazov, popis) values ('diabetol�gia poruchy l�tkovej premeny a v��ivy', null);
insert into m_specializacia(nazov, popis) values ('neonatol�gia', null);
insert into m_specializacia(nazov, popis) values ('hygiena det� a ml�de�e', null);
insert into m_specializacia(nazov, popis) values ('angiol�gia', null);
insert into m_specializacia(nazov, popis) values ('hygiena �ivotn�ho prostredia', null);
insert into m_specializacia(nazov, popis) values ('hygiena v��ivy', null);
insert into m_specializacia(nazov, popis) values ('epidemiol�gia', null);
insert into m_specializacia(nazov, popis) values ('geriatria', null);
insert into m_specializacia(nazov, popis) values ('medic�nska informatika a bio�tatistika', null);
insert into m_specializacia(nazov, popis) values ('lek�rska genetika', null);
insert into m_specializacia(nazov, popis) values ('nefrol�gia', null);
insert into m_specializacia(nazov, popis) values ('endokrinol�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� farmakol�gia', null);
insert into m_specializacia(nazov, popis) values ('zdravotn�cka informatika', null);
insert into m_specializacia(nazov, popis) values ('gynekologick� sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('cievna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('kardiochirurgia', null);
insert into m_specializacia(nazov, popis) values ('maxilofaci�lna chirurgia', null);
insert into m_specializacia(nazov, popis) values ('medic�na drogov�ch z�vislost�', null);
insert into m_specializacia(nazov, popis) values ('gerontopsychiatria', null);
insert into m_specializacia(nazov, popis) values ('leteck� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('lek�r bez �pecializ�cie', null);
insert into m_specializacia(nazov, popis) values ('lek�r predpisuj�ci lieky pre seba a osoby bl�zke', null);
insert into m_specializacia(nazov, popis) values ('posudkov� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('ochrana zdravia pred ionizuj�cim �iaren�m', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� neurol�gia', null);
insert into m_specializacia(nazov, popis) values ('detsk� psychiatria', null);
insert into m_specializacia(nazov, popis) values ('hrudn�kov� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('detsk� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� ortop�dia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� urol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� otorinolaryngol�gia', null);
insert into m_specializacia(nazov, popis) values ('materno', null);
insert into m_specializacia(nazov, popis) values ('v�chova k zdraviu', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� imunol�gia a alergiol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� reumatol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� endokrinol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� gastroenterol�gia hepatol�gia a v��iva', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� kardiol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� pneumol�gia a ftizeol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� nefrol�gia', null);
insert into m_specializacia(nazov, popis) values ('hepatol�gia', null);
insert into m_specializacia(nazov, popis) values ('gastroenterologick� chirurgia', null);
insert into m_specializacia(nazov, popis) values ('neuropsychiatria', null);
insert into m_specializacia(nazov, popis) values ('laborat�rna medic�na', null);
insert into m_specializacia(nazov, popis) values ('tropick� medic�na', null);
insert into m_specializacia(nazov, popis) values ('verejn� zdravotn�ctvo', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v gynekol�gii', null);
insert into m_specializacia(nazov, popis) values ('psychosomatick� a behavior�lna medic�na', null);
insert into m_specializacia(nazov, popis) values ('ultrazvuk v gynekol�gii a p�rodn�ctve', null);
insert into m_specializacia(nazov, popis) values ('�peci�lne laborat�rne a diagnostick� met�dy v hematol�gii a transf�ziol�gii', null);
insert into m_specializacia(nazov, popis) values ('mamol�gia', null);
insert into m_specializacia(nazov, popis) values ('reproduk�n� medic�na', null);
insert into m_specializacia(nazov, popis) values ('akupunkt�ra', null);
insert into m_specializacia(nazov, popis) values ('androl�gia', null);
insert into m_specializacia(nazov, popis) values ('klinick� pracovn� lek�rstvo a klinick� toxikol�gia', null);
insert into m_specializacia(nazov, popis) values ('gynekologick� urol�gia', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v chirurgii', null);
insert into m_specializacia(nazov, popis) values ('onkol�gia v urol�gii', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� anest�ziol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� hematol�gia a onkol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� infektol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� intenz�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('paliat�vna medic�na', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� oftalmol�gia', null);
insert into m_specializacia(nazov, popis) values ('sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('pediatrick� urgentn� medic�na', null);
insert into m_specializacia(nazov, popis) values ('zdravotn�cka ekol�gia', null);
insert into m_specializacia(nazov, popis) values ('rev�zne lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('prevent�vne pracovn� lek�rstvo a toxikol�gia', null);
insert into m_specializacia(nazov, popis) values ('psychiatrick� sexuol�gia', null);
insert into m_specializacia(nazov, popis) values ('slu�by zdravia pri pr�ci', null);
insert into m_specializacia(nazov, popis) values ('�tudijn� odbor v�eobecn� lek�rstvo', null);
insert into m_specializacia(nazov, popis) values ('�tudijn� odbor detsk� lek�rstvo', null);

